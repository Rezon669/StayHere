package com.stayhere.app.controller;

import com.stayhere.app.model.PropertyDto;
import com.stayhere.app.model.UserDto;
import com.stayhere.app.service.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @InjectMocks
    private PropertyController propertyController;

    @Mock
    private PropertyService propertyServiceMock;

    private PropertyDto dummyProperty;

    @BeforeEach
    void setUp() {
        dummyProperty = new PropertyDto();
        dummyProperty.setUser(new UserDto()); // Ensure user is set
    }

    // ✅ Test for successful property addition
    @Test
    @DisplayName("addProperty: should add property successfully")
    public void testAddProperty_Success() {
        when(propertyServiceMock.addProperty(any(PropertyDto.class))).thenReturn(dummyProperty);

        ResponseEntity<PropertyDto> response = propertyController.addProperty(dummyProperty);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    // ✅ Test when service returns null
    @Test
    @DisplayName("addProperty: should throw NullPointerException when service returns null")
    public void testAddProperty_ServiceReturnsNull() {
        when(propertyServiceMock.addProperty(any())).thenReturn(null);

        Exception exception = assertThrows(NullPointerException.class, () -> propertyController.addProperty(dummyProperty));

        assertNotNull(exception);
    }

    // ✅ Test for retrieving properties successfully
    @Test
    @DisplayName("getProperties: should return a list of properties")
    public void testGetProperties_Success() {
        List<PropertyDto> propertyList = List.of(dummyProperty);
        when(propertyServiceMock.getProperties()).thenReturn(propertyList);

        ResponseEntity<List<PropertyDto>> response = propertyController.getProperties();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // ✅ Test for empty list scenario
    @Test
    @DisplayName("getProperties: should return an empty list when no properties exist")
    public void testGetProperties_EmptyList() {
        when(propertyServiceMock.getProperties()).thenReturn(Collections.emptyList());

        ResponseEntity<List<PropertyDto>> response = propertyController.getProperties();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isEmpty());
    }

    // ✅ Test when service throws an exception
    @Test
    @DisplayName("getProperties: should throw exception when service fails")
    public void testGetProperties_ServiceFailure() {
        when(propertyServiceMock.getProperties()).thenThrow(new RuntimeException("Service unavailable"));

        Exception exception = assertThrows(RuntimeException.class, () -> propertyController.getProperties());

        assertEquals("Service unavailable", exception.getMessage());
    }
}
