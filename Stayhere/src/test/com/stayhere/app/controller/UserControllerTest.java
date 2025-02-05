package com.stayhere.app.controller;

import com.stayhere.app.model.UserDto;
import com.stayhere.app.model.UserDto.Role;
import com.stayhere.app.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMapAdapter;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.utbot.runtime.utils.java.UtUtils.*;

public final class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userServiceMock;

    private AutoCloseable mockitoCloseable;

    ///region Test suites for executable com.stayhere.app.controller.UserController.authenticateUser

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method authenticateUser(java.lang.String, java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserController}
     * @utbot.methodUnderTest {@link UserController#authenticateUser(String, String)}
     */
    @Test
    @DisplayName("authenticateUser: email = 'abc', password = 'error'")
    public void testAuthenticateUserWithNonEmptyStrings() throws Exception {
        (when(userServiceMock.authenticateUser(any(), any()))).thenReturn(((String) null));

        ResponseEntity actual = userController.authenticateUser("abc", "error");

        ResponseEntity expected = ((ResponseEntity) createInstance("org.springframework.http.ResponseEntity"));
        HttpStatus status = HttpStatus.OK;
        setField(expected, "org.springframework.http.ResponseEntity", "status", status);
        Object headers = createInstance("org.springframework.http.ReadOnlyHttpHeaders");
        MultiValueMapAdapter headers1 = ((MultiValueMapAdapter) createInstance("org.springframework.util.MultiValueMapAdapter"));
        Map targetMap = new LinkedHashMap();
        setField(headers1, "org.springframework.util.MultiValueMapAdapter", "targetMap", targetMap);
        setField(headers, "org.springframework.http.HttpHeaders", "headers", headers1);
        setField(expected, "org.springframework.http.HttpEntity", "headers", headers);
        Map body = new LinkedHashMap();
        String string = "token";
        body.put(string, null);
        setField(expected, "org.springframework.http.HttpEntity", "body", body);

        HttpStatusCode expectedStatus = ((HttpStatusCode) getFieldValue(expected, "org.springframework.http.ResponseEntity", "status"));
        HttpStatusCode actualStatus = ((HttpStatusCode) getFieldValue(actual, "org.springframework.http.ResponseEntity", "status"));
        assertEquals(expectedStatus, actualStatus);

        HttpHeaders expectedHeaders = expected.getHeaders();
        HttpHeaders actualHeaders = actual.getHeaders();
        // org.springframework.http.HttpHeaders is iterable or Map, use outer deep equals to iterate over
        assertTrue(deepEquals(expectedHeaders, actualHeaders));

        Object expectedBody = expected.getBody();
        Object actualBody = actual.getBody();
        assertTrue(deepEquals(expectedBody, actualBody));

    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.controller.UserController.addUser

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method addUser(com.stayhere.app.model.UserDto)

    /**
     * @utbot.classUnderTest {@link UserController}
     * @utbot.methodUnderTest {@link UserController#addUser(UserDto)}
     * @utbot.throwsException {@link NullPointerException} in: UserDto addedUser = userService.addUser(user);
     */
    @Test
    @DisplayName("addUser: addedUser = userService.addUser(user) : True -> ThrowNullPointerException")
    public void testAddUser_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(userController, "com.stayhere.app.controller.UserController", "userService", null);
        
        /* This test fails because method [com.stayhere.app.controller.UserController.addUser] produces [java.lang.NullPointerException]
            com.stayhere.app.controller.UserController.addUser(UserController.java:50) */
        userController.addUser(null);
    }

    /**
     * @utbot.classUnderTest {@link UserController}
     * @utbot.methodUnderTest {@link UserController#addUser(UserDto)}
     * @utbot.throwsException {@link NullPointerException} in: log.info("User added successfully: {}", user.getUsername());
     */
    @Test
    @DisplayName("addUser: log.info(\"User added successfully: {}\", user.getUsername()) : True -> ThrowNullPointerException")
    public void testAddUser_ThrowNullPointerException_2() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class userControllerClazz = Class.forName("com.stayhere.app.controller.UserController");
            Logger prevLog = ((Logger) getStaticFieldValue(userControllerClazz, "log"));
            try {
                setStaticField(userControllerClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(userServiceMock.addUser(any()))).thenReturn(((UserDto) null));

                /* This test fails because method [com.stayhere.app.controller.UserController.addUser] produces [java.lang.NullPointerException] */
                userController.addUser(null);
            } finally {
                setStaticField(UserController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link UserController}
     * @utbot.methodUnderTest {@link UserController#addUser(UserDto)}
     * @utbot.invokes {@link Logger#info(String, Object)}
     * @utbot.throwsException {@link NullPointerException} in: log.info("User added successfully: {}", user.getUsername());
     */
    @Test
    @DisplayName("addUser: log.info(\"User added successfully: {}\", user.getUsername()) : True -> ThrowNullPointerException")
    public void testAddUser_ThrowNullPointerException_1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class userControllerClazz = Class.forName("com.stayhere.app.controller.UserController");
            Logger prevLog = ((Logger) getStaticFieldValue(userControllerClazz, "log"));
            try {
                setStaticField(userControllerClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(userServiceMock.addUser(any()))).thenReturn(((UserDto) null));
                UserDto userMock = mock(UserDto.class);
                (when(userMock.getUsername())).thenReturn(((String) null));

                /* This test fails because method [com.stayhere.app.controller.UserController.addUser] produces [java.lang.NullPointerException] */
                userController.addUser(userMock);
            } finally {
                setStaticField(UserController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.controller.UserController.getUsers

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method getUsers()

    /**
     * @utbot.classUnderTest {@link UserController}
     * @utbot.methodUnderTest {@link UserController#getUsers()}
     * @utbot.throwsException {@link NullPointerException} in: List<UserDto> users = userService.getUsers();
     */
    @Test
    @DisplayName("getUsers: users = userService.getUsers() : True -> ThrowNullPointerException")
    public void testGetUsers_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(userController, "com.stayhere.app.controller.UserController", "userService", null);
        
        /* This test fails because method [com.stayhere.app.controller.UserController.getUsers] produces [java.lang.NullPointerException]
            com.stayhere.app.controller.UserController.getUsers(UserController.java:58) */
        userController.getUsers();
    }

    /**
     * @utbot.classUnderTest {@link UserController}
     * @utbot.methodUnderTest {@link UserController#getUsers()}
     * @utbot.invokes {@link Logger#info(String)}
     * @utbot.throwsException {@link NullPointerException} in: log.info("Users information fetched successfully");
     */
    @Test
    @DisplayName("getUsers: log.info(\"Users information fetched successfully\") : True -> ThrowNullPointerException")
    public void testGetUsers_ThrowNullPointerException_1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class userControllerClazz = Class.forName("com.stayhere.app.controller.UserController");
            Logger prevLog = ((Logger) getStaticFieldValue(userControllerClazz, "log"));
            try {
                setStaticField(userControllerClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(userServiceMock.getUsers())).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.controller.UserController.getUsers] produces [java.lang.NullPointerException] */
                userController.getUsers();
            } finally {
                setStaticField(UserController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region Errors report for getUsers

    public void testGetUsers_errors() {
        // Couldn't generate some tests. List of errors:
        // 
        // 1 occurrences of:
        // org.mockito.codegen.List$MockitoMock$2uvYCG8Z

    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.controller.UserController.deleteUser

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method deleteUser(long)

    /**
     * @utbot.classUnderTest {@link UserController}
     * @utbot.methodUnderTest {@link UserController#deleteUser(long)}
     * @utbot.throwsException {@link NullPointerException} in: UserDto deletedUser = userService.deleteUser(userId);
     */
    @Test
    @DisplayName("deleteUser: deletedUser = userService.deleteUser(userId) : True -> ThrowNullPointerException")
    public void testDeleteUser_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(userController, "com.stayhere.app.controller.UserController", "userService", null);
        
        /* This test fails because method [com.stayhere.app.controller.UserController.deleteUser] produces [java.lang.NullPointerException]
            com.stayhere.app.controller.UserController.deleteUser(UserController.java:66) */
        userController.deleteUser(-255L);
    }

    /**
     * @utbot.classUnderTest {@link UserController}
     * @utbot.methodUnderTest {@link UserController#deleteUser(long)}
     * @utbot.throwsException {@link NullPointerException} in: log.info("User deleted successfully with id: {}", userId);
     */
    @Test
    @DisplayName("deleteUser: log.info(\"User deleted successfully with id: {}\", userId) : True -> ThrowNullPointerException")
    public void testDeleteUser_ThrowNullPointerException_1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class userControllerClazz = Class.forName("com.stayhere.app.controller.UserController");
            Logger prevLog = ((Logger) getStaticFieldValue(userControllerClazz, "log"));
            try {
                setStaticField(userControllerClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(userServiceMock.deleteUser(anyLong()))).thenReturn(((UserDto) null));

                /* This test fails because method [com.stayhere.app.controller.UserController.deleteUser] produces [java.lang.NullPointerException] */
                userController.deleteUser(-255L);
            } finally {
                setStaticField(UserController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: SECURITY for method deleteUser(long)

    /**
     * @utbot.classUnderTest {@link UserController}
     * @utbot.methodUnderTest {@link UserController#deleteUser(long)}
     */
    @Test
    @DisplayName("deleteUser: userId = -9 (mutated from -1)")
    @Disabled(value = "Disabled due to sandbox")
    public void testDeleteUser() {
        UserDto userDtoMock = mock(UserDto.class);
        (when(userServiceMock.deleteUser(anyLong()))).thenReturn(userDtoMock);

        assertThrows(ExceptionInInitializerError.class, () -> userController.deleteUser(-9L));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.controller.UserController.updateUser

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method updateUser(long, com.stayhere.app.model.UserDto)

    /**
     * @utbot.classUnderTest {@link UserController}
     * @utbot.methodUnderTest {@link UserController#updateUser(long, UserDto)}
     * @utbot.throwsException {@link NullPointerException} in: UserDto updatedUser = userService.updateUser(userId, updateuser);
     */
    @Test
    @DisplayName("updateUser: updatedUser = userService.updateUser(userId, updateuser) : True -> ThrowNullPointerException")
    public void testUpdateUser_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(userController, "com.stayhere.app.controller.UserController", "userService", null);
        
        /* This test fails because method [com.stayhere.app.controller.UserController.updateUser] produces [java.lang.NullPointerException]
            com.stayhere.app.controller.UserController.updateUser(UserController.java:73) */
        userController.updateUser(-255L, null);
    }

    /**
     * @utbot.classUnderTest {@link UserController}
     * @utbot.methodUnderTest {@link UserController#updateUser(long, UserDto)}
     * @utbot.invokes {@link Logger#info(String)}
     * @utbot.throwsException {@link NullPointerException} in: log.info("User details are updated successfully");
     */
    @Test
    @DisplayName("updateUser: log.info(\"User details are updated successfully\") : True -> ThrowNullPointerException")
    public void testUpdateUser_ThrowNullPointerException_1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class userControllerClazz = Class.forName("com.stayhere.app.controller.UserController");
            Logger prevLog = ((Logger) getStaticFieldValue(userControllerClazz, "log"));
            try {
                setStaticField(userControllerClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(userServiceMock.updateUser(anyLong(), any()))).thenReturn(((UserDto) null));

                /* This test fails because method [com.stayhere.app.controller.UserController.updateUser] produces [java.lang.NullPointerException] */
                userController.updateUser(-255L, null);
            } finally {
                setStaticField(UserController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method updateUser(long, com.stayhere.app.model.UserDto)

    /**
     * @utbot.classUnderTest {@link UserController}
     * @utbot.methodUnderTest {@link UserController#updateUser(long, UserDto)}
     */
    @Test
    @DisplayName("updateUser: userId = max (mutated from -1), updateuser = mock()")
    public void testUpdateUserWithCornerCase() throws Exception {
        UserDto userDtoMock = mock(UserDto.class);
        (when(userServiceMock.updateUser(anyLong(), any()))).thenReturn(userDtoMock);
        UserDto updateuserMock = mock(UserDto.class);

        ResponseEntity actual = userController.updateUser(Long.MAX_VALUE, updateuserMock);

        ResponseEntity expected = ((ResponseEntity) createInstance("org.springframework.http.ResponseEntity"));
        HttpStatus status = HttpStatus.ACCEPTED;
        setField(expected, "org.springframework.http.ResponseEntity", "status", status);
        Object headers = createInstance("org.springframework.http.ReadOnlyHttpHeaders");
        MultiValueMapAdapter headers1 = ((MultiValueMapAdapter) createInstance("org.springframework.util.MultiValueMapAdapter"));
        Map targetMap = new LinkedHashMap();
        setField(headers1, "org.springframework.util.MultiValueMapAdapter", "targetMap", targetMap);
        setField(headers, "org.springframework.http.HttpHeaders", "headers", headers1);
        setField(expected, "org.springframework.http.HttpEntity", "headers", headers);
        UserDto body = ((UserDto) createInstance("com.stayhere.app.model.UserDto"));
        body.setUserid(0L);
        setField(expected, "org.springframework.http.HttpEntity", "body", body);

        HttpStatusCode expectedStatus = ((HttpStatusCode) getFieldValue(expected, "org.springframework.http.ResponseEntity", "status"));
        HttpStatusCode actualStatus = ((HttpStatusCode) getFieldValue(actual, "org.springframework.http.ResponseEntity", "status"));
        assertEquals(expectedStatus, actualStatus);

        HttpHeaders expectedHeaders = expected.getHeaders();
        HttpHeaders actualHeaders = actual.getHeaders();
        // org.springframework.http.HttpHeaders is iterable or Map, use outer deep equals to iterate over
        assertTrue(deepEquals(expectedHeaders, actualHeaders));

        Object expectedBody = expected.getBody();
        Object actualBody = actual.getBody();
        long expectedBodyUserid = (((UserDto) expectedBody)).getUserid();
        long actualBodyUserid = (((UserDto) actualBody)).getUserid();
        assertEquals(expectedBodyUserid, actualBodyUserid);

        String actualBodyUsername = (((UserDto) actualBody)).getUsername();
        assertNull(actualBodyUsername);

        String actualBodyFirstname = (((UserDto) actualBody)).getFirstname();
        assertNull(actualBodyFirstname);

        String actualBodyLastname = (((UserDto) actualBody)).getLastname();
        assertNull(actualBodyLastname);

        String actualBodyEmail = (((UserDto) actualBody)).getEmail();
        assertNull(actualBodyEmail);

        String actualBodyPhonenumber = (((UserDto) actualBody)).getPhonenumber();
        assertNull(actualBodyPhonenumber);

        String actualBodyPassword = (((UserDto) actualBody)).getPassword();
        assertNull(actualBodyPassword);

        Role actualBodyRole = (((UserDto) actualBody)).getRole();
        assertNull(actualBodyRole);

    }
    ///endregion

    ///region FUZZER: TIMEOUTS for method updateUser(long, com.stayhere.app.model.UserDto)

    /**
     * @utbot.classUnderTest {@link UserController}
     * @utbot.methodUnderTest {@link UserController#updateUser(long, UserDto)}
     */
    @Test
    @DisplayName("updateUser: userId = -1, updateuser = mock()")
    @Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
    public void testUpdateUser() {
        UserDto updateuserMock = mock(UserDto.class);
        
        /* This execution may take longer than the 1000 ms timeout
         and therefore fail due to exceeding the timeout. */
        assertTimeoutPreemptively(Duration.ofMillis(1000L), () -> userController.updateUser(-1L, updateuserMock));
    }
    ///endregion

    ///endregion


    @BeforeEach
    public void setUp() {
        mockitoCloseable = openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        mockitoCloseable.close();
    }

}
