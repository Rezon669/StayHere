package com.stayhere.app.controller;

import com.stayhere.app.model.UserDto;
import com.stayhere.app.model.UserDto.Role;
import com.stayhere.app.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userServiceMock;

    private UserDto dummyUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dummyUser = new UserDto();
        dummyUser.setUserid(1L);
        dummyUser.setUsername("testUser");
        dummyUser.setEmail("test@example.com");
        dummyUser.setPassword("password123");
        dummyUser.setRole(Role.USER);
    }


    @Test
    @DisplayName("authenticateUser: Should return a token")
    public void testAuthenticateUser() throws JSONException{
        when(userServiceMock.authenticateUser(any(), any())).thenReturn("validToken");

        ResponseEntity<?> response = userController.authenticateUser("test@example.com", "password123");
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        JSONObject jsonObject = new JSONObject(response.getBody().toString());
        String value = jsonObject.getString("token");
        assertEquals("validToken", value);
    }

    @Test
    @DisplayName("addUser: Should add a new user successfully")
    public void testAddUser() {
        when(userServiceMock.addUser(any())).thenReturn(dummyUser);

        ResponseEntity<UserDto> response = userController.addUser(dummyUser);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(dummyUser, response.getBody());
    }

    @Test
    @DisplayName("getUsers: Should return list of users")
    public void testGetUsers() {
        when(userServiceMock.getUsers()).thenReturn(Collections.singletonList(dummyUser));

        ResponseEntity<List<UserDto>> response = userController.getUsers();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
    }

    @Test
    @DisplayName("deleteUser: Should delete a user successfully")
    public void testDeleteUser() {
        when(userServiceMock.deleteUser(anyLong())).thenReturn(dummyUser);

        ResponseEntity<UserDto> response = userController.deleteUser(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("User deleted successfully", response.getBody());
    }

    @Test
    @DisplayName("updateUser: Should update user details")
    public void testUpdateUser() {
        when(userServiceMock.updateUser(anyLong(), any())).thenReturn(dummyUser);

        ResponseEntity<UserDto> response = userController.updateUser(1L, dummyUser);

        assertEquals(202, response.getStatusCodeValue());
        assertEquals(dummyUser, response.getBody());
    }
}
