package com.stayhere.app.service;

import com.stayhere.app.model.UserDto;
import com.stayhere.app.repo.UserRepository;
import com.stayhere.app.security.JwtUtil;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public final class UserServiceTest {

    //Test class
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepositoryMock;

    @Mock
    private AuthenticationManager authenticationManagerMock;

    @Mock
    private JwtUtil jwtUtilMock;

    @Mock
    private PasswordEncoder passwordEncoderMock;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    public void setUp() {
        mockitoCloseable = openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        mockitoCloseable.close();
    }

    // ✅ Fixed test for addUser(null)
    @Test
    @DisplayName("addUser: should throw IllegalArgumentException when user is null")
    public void testAddUser_NullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userService.addUser(null));
        assertEquals("User cannot be null", exception.getMessage());
    }

    // ✅ Fixed test for addUser()
    @Test
    @DisplayName("addUser: should add new user successfully")
    public void testAddUser() {
        UserDto user = new UserDto();
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setPassword("password");

        when(userRepositoryMock.findByUsernameOrEmail(any(), any())).thenReturn(Optional.empty());
        when(passwordEncoderMock.encode(any())).thenReturn("encodedPassword");
        when(userRepositoryMock.save(any())).thenReturn(user);

        UserDto result = userService.addUser(user);

        assertNotNull(result);
        assertEquals("testUser", result.getUsername());
    }

    // ✅ Fixed test for getUsers()
    @Test
    @DisplayName("getUsers: should return non-empty user list")
    public void testGetUsers() {
        UserDto user = new UserDto();
        when(userRepositoryMock.findAll()).thenReturn(List.of(user));

        List<UserDto> users = userService.getUsers();

        assertNotNull(users);
        assertFalse(users.isEmpty());
    }


    // ✅ Fixed test for deleteUser()
    @Test
    @DisplayName("deleteUser: should throw exception when user not found")
    public void testDeleteUser_NotFound() {
        when(userRepositoryMock.findById(any())).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> userService.deleteUser(1L));
        assertEquals("No user exists with the given ID: 1", exception.getMessage());
    }

    // ✅ Fixed test for authenticateUser()
    @Test
    @DisplayName("authenticateUser: should throw exception when user not found")
    public void testAuthenticateUser_UserNotFound() {
        when(userRepositoryMock.findByEmail(any())).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> userService.authenticateUser("email@example.com", "password"));
        assertEquals("User not found with email: email@example.com", exception.getMessage());
    }
}
