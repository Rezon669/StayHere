package com.stayhere.app.service;

import com.stayhere.app.model.UserDto;
import com.stayhere.app.model.UserDto.Role;
import com.stayhere.app.repo.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.utbot.runtime.utils.java.UtUtils.createInstance;
import static org.utbot.runtime.utils.java.UtUtils.setField;

public final class UserDetailsServiceImplTest {
    @InjectMocks
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Mock
    private UserRepository userRepositoryMock;

    private AutoCloseable mockitoCloseable;

    ///region Test suites for executable com.stayhere.app.service.UserDetailsServiceImpl.loadUserByUsername

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method loadUserByUsername(java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserDetailsServiceImpl}
     * @utbot.methodUnderTest {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     * @utbot.invokes {@link UserRepository#findByUsername(String)}
     * @utbot.throwsException {@link NullPointerException} in: orElseThrow
     */
    @Test
    @DisplayName("loadUserByUsername: orElseThrow -> ThrowNullPointerException")
    public void testLoadUserByUsername_ThrowNullPointerException() {
        (when(userRepositoryMock.findByUsername(any()))).thenReturn(((Optional) null));
        
        /* This test fails because method [com.stayhere.app.service.UserDetailsServiceImpl.loadUserByUsername] produces [java.lang.NullPointerException]
            com.stayhere.app.service.UserDetailsServiceImpl.loadUserByUsername(UserDetailsServiceImpl.java:27) */
        userDetailsServiceImpl.loadUserByUsername(null);
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method loadUserByUsername(java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserDetailsServiceImpl}
     * @utbot.methodUnderTest {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    @DisplayName("loadUserByUsername: username = '1'")
    public void testLoadUserByUsernameWithNonEmptyString() throws Throwable {
        Optional optionalMock = mock(Optional.class);
        UserDto userDtoMock = mock(UserDto.class);
        Role role = Role.SELLER;
        (when(userDtoMock.getRole())).thenReturn(role);
        (when(userDtoMock.getEmail())).thenReturn("abc");
        (when(userDtoMock.getPassword())).thenReturn("10");
        (when(optionalMock.orElseThrow(any()))).thenReturn(userDtoMock);
        (when(userRepositoryMock.findByUsername(any()))).thenReturn(optionalMock);

        User actual = ((User) userDetailsServiceImpl.loadUserByUsername("1"));

        User expected = ((User) createInstance("org.springframework.security.core.userdetails.User"));
        String password = "10";
        setField(expected, "org.springframework.security.core.userdetails.User", "password", password);
        String username = "abc";
        setField(expected, "org.springframework.security.core.userdetails.User", "username", username);
        Set authorities = new LinkedHashSet();
        SimpleGrantedAuthority simpleGrantedAuthority = ((SimpleGrantedAuthority) createInstance("org.springframework.security.core.authority.SimpleGrantedAuthority"));
        String role1 = "ROLE_SELLER";
        setField(simpleGrantedAuthority, "org.springframework.security.core.authority.SimpleGrantedAuthority", "role", role1);
        authorities.add(simpleGrantedAuthority);
        setField(expected, "org.springframework.security.core.userdetails.User", "authorities", authorities);
        setField(expected, "org.springframework.security.core.userdetails.User", "accountNonExpired", true);
        setField(expected, "org.springframework.security.core.userdetails.User", "accountNonLocked", true);
        setField(expected, "org.springframework.security.core.userdetails.User", "credentialsNonExpired", true);
        setField(expected, "org.springframework.security.core.userdetails.User", "enabled", true);

        // org.springframework.security.core.userdetails.User has overridden equals method
        assertEquals(expected, actual);
    }
    ///endregion

    ///region FUZZER: ERROR SUITE for method loadUserByUsername(java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserDetailsServiceImpl}
     * @utbot.methodUnderTest {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    @DisplayName("loadUserByUsername: username = '\u000E' (mutated from '') -> throw NullPointerException")
    public void testLoadUserByUsernameThrowsNPEWithNonEmptyString() throws Throwable {
        Optional optionalMock = mock(Optional.class);
        (when(optionalMock.orElseThrow(any()))).thenReturn(null);
        (when(userRepositoryMock.findByUsername(any()))).thenReturn(optionalMock);
        
        /* This test fails because method [com.stayhere.app.service.UserDetailsServiceImpl.loadUserByUsername] produces [java.lang.NullPointerException]
            com.stayhere.app.service.UserDetailsServiceImpl.loadUserByUsername(UserDetailsServiceImpl.java:30) */
        userDetailsServiceImpl.loadUserByUsername("\u000E");
    }
    ///endregion

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method loadUserByUsername(java.lang.String)

    /**
     * @utbot.classUnderTest {@link UserDetailsServiceImpl}
     * @utbot.methodUnderTest {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    @DisplayName("loadUserByUsername: username = '\u000F10' (mutated from '10') -> throw IllegalArgumentException")
    public void testLoadUserByUsernameThrowsIAEWithNonEmptyString() throws Throwable {
        Optional optionalMock = mock(Optional.class);
        UserDto userDtoMock = mock(UserDto.class);
        Role roleMock = mock(Role.class);
        (when(roleMock.toString())).thenReturn(((String) null));
        (when(userDtoMock.getRole())).thenReturn(roleMock);
        (when(userDtoMock.getEmail())).thenReturn(((String) null));
        (when(userDtoMock.getPassword())).thenReturn(((String) null));
        (when(optionalMock.orElseThrow(any()))).thenReturn(userDtoMock);
        (when(userRepositoryMock.findByUsername(any()))).thenReturn(optionalMock);

        assertThrows(IllegalArgumentException.class, () -> userDetailsServiceImpl.loadUserByUsername("\u000F10"));
    }

    /**
     * @utbot.classUnderTest {@link UserDetailsServiceImpl}
     * @utbot.methodUnderTest {@link UserDetailsServiceImpl#loadUserByUsername(String)}
     */
    @Test
    @DisplayName("loadUserByUsername: username = '10\u000F' -> throw IllegalArgumentException")
    public void testLoadUserByUsernameThrowsIAEWithNonEmptyString1() throws Throwable {
        Optional optionalMock = mock(Optional.class);
        UserDto userDtoMock = mock(UserDto.class);
        Role roleMock = mock(Role.class);
        (when(roleMock.toString())).thenReturn(((String) null));
        (when(userDtoMock.getRole())).thenReturn(roleMock);
        (when(userDtoMock.getEmail())).thenReturn(((String) null));
        (when(userDtoMock.getPassword())).thenReturn(((String) null));
        (when(optionalMock.orElseThrow(any()))).thenReturn(userDtoMock);
        (when(userRepositoryMock.findByUsername(any()))).thenReturn(optionalMock);

        assertThrows(IllegalArgumentException.class, () -> userDetailsServiceImpl.loadUserByUsername("10\u000F"));
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
