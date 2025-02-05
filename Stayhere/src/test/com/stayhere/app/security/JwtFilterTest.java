package com.stayhere.app.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.mockito.MockedConstruction.Context;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.utbot.runtime.utils.java.UtUtils.createInstance;
import static org.utbot.runtime.utils.java.UtUtils.setField;

public final class JwtFilterTest {
    @InjectMocks
    private JwtFilter jwtFilter;

    @Mock
    private UserDetailsService userDetailsServiceMock;

    @Mock
    private Log logMock;

    @Spy
    private HashSet hashSetSpy;

    private AutoCloseable mockitoCloseable;

    ///region Test suites for executable com.stayhere.app.security.JwtFilter.doFilterInternal

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method doFilterInternal(jakarta.servlet.http.HttpServletRequest, jakarta.servlet.http.HttpServletResponse, jakarta.servlet.FilterChain)

    /**
     * @utbot.classUnderTest {@link JwtFilter}
     * @utbot.methodUnderTest {@link JwtFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     * @utbot.executesCondition {@code (authorizationHeader != null): False}
     */
    @Test
    @DisplayName("doFilterInternal: -> authorizationHeader != null : False")
    public void testDoFilterInternal_AuthorizationHeaderEqualsNull() throws IOException, ServletException {
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        (when(requestMock.getHeader(any()))).thenReturn(((String) null));
        FilterChain chainMock = mock(FilterChain.class);
        (((FilterChain) (doNothing()).when(chainMock))).doFilter(any(), any());

        jwtFilter.doFilterInternal(requestMock, null, chainMock);
    }

    /**
     * @utbot.classUnderTest {@link JwtFilter}
     * @utbot.methodUnderTest {@link JwtFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     * @utbot.executesCondition {@code (authorizationHeader != null): True}
     * @utbot.executesCondition {@code (authorizationHeader.startsWith("Bearer ")): False}
     */
    @Test
    @DisplayName("doFilterInternal: authorizationHeader != null : True -> authorizationHeader.startsWith(\"Bearer \") : False")
    public void testDoFilterInternal_NotAuthorizationHeaderStartsWith() throws IOException, ServletException {
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        String string = "";
        (when(requestMock.getHeader(any()))).thenReturn(string);
        FilterChain chainMock = mock(FilterChain.class);
        (((FilterChain) (doNothing()).when(chainMock))).doFilter(any(), any());

        jwtFilter.doFilterInternal(requestMock, null, chainMock);
    }

    /**
     * @utbot.classUnderTest {@link JwtFilter}
     * @utbot.methodUnderTest {@link JwtFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     * @utbot.executesCondition {@code (authorizationHeader != null): True}
     * @utbot.executesCondition {@code (authorizationHeader.startsWith("Bearer ")): True}
     * @utbot.invokes {@link String#substring(int)}
     * @utbot.invokes {@link JwtUtil#validateToken(String)}
     * @utbot.invokes {@link UserDetailsService#loadUserByUsername(String)}
     * @utbot.invokes {@link UserDetails#getAuthorities()}
     * @utbot.invokes {@link SecurityContextHolder#getContext()}
     * @utbot.invokes {@link SecurityContext#setAuthentication(org.springframework.security.core.Authentication)}
     */
    @Test
    @DisplayName("doFilterInternal: authorizationHeader.startsWith(\"Bearer \") : True -> SecurityContextSetAuthentication")
    public void testDoFilterInternal_AuthorizationHeaderStartsWith() throws Exception {
        MockedConstruction mockedConstruction = null;
        MockedStatic mockedStatic = null;
        MockedStatic mockedStatic1 = null;
        MockedStatic mockedStatic2 = null;
        try {
            mockedConstruction = mockConstruction(UsernamePasswordAuthenticationToken.class, (UsernamePasswordAuthenticationToken usernamePasswordAuthenticationTokenMock, Context context) -> {
            });
            mockedStatic = mockStatic(Algorithm.class);
            (mockedStatic.when(() -> Algorithm.HMAC256(any(String.class)))).thenReturn(((Algorithm) null));
            mockedStatic1 = mockStatic(JWT.class);
            Verification verificationMock = mock(Verification.class);
            (when(verificationMock.withIssuer(any(String.class)))).thenReturn(verificationMock);
            JWTVerifier jWTVerifierMock = mock(JWTVerifier.class);
            DecodedJWT decodedJWTMock = mock(DecodedJWT.class);
            Claim claimMock = mock(Claim.class);
            String string = "Bearer \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000";
            (when(claimMock.asString())).thenReturn(string);
            (when(decodedJWTMock.getClaim(any()))).thenReturn(claimMock);
            (when(jWTVerifierMock.verify(any(String.class)))).thenReturn(decodedJWTMock);
            (when(verificationMock.build())).thenReturn(jWTVerifierMock);
            (mockedStatic1.when(() -> JWT.require(any()))).thenReturn(verificationMock);
            mockedStatic2 = mockStatic(SecurityContextHolder.class);
            SecurityContext securityContextMock = mock(SecurityContext.class);
            (((SecurityContext) (doNothing()).when(securityContextMock))).setAuthentication(any());
            (mockedStatic2.when(SecurityContextHolder::getContext)).thenReturn(securityContextMock);
            JwtUtil jwtUtil = ((JwtUtil) createInstance("com.stayhere.app.security.JwtUtil"));
            String secret = "";
            setField(jwtUtil, "com.stayhere.app.security.JwtUtil", "secret", secret);
            setField(jwtFilter, "com.stayhere.app.security.JwtFilter", "jwtUtil", jwtUtil);
            UserDetails userDetailsMock = mock(UserDetails.class);
            (when(userDetailsMock.getAuthorities())).thenReturn(((Collection) null));
            (when(userDetailsServiceMock.loadUserByUsername(any()))).thenReturn(userDetailsMock);
            HttpServletRequest requestMock = mock(HttpServletRequest.class);
            (when(requestMock.getHeader(any()))).thenReturn(string);
            FilterChain chainMock = mock(FilterChain.class);
            (((FilterChain) (doNothing()).when(chainMock))).doFilter(any(), any());

            jwtFilter.doFilterInternal(requestMock, null, chainMock);
        } finally {
            mockedConstruction.close();
            mockedStatic.close();
            mockedStatic1.close();
            mockedStatic2.close();
        }
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method doFilterInternal(jakarta.servlet.http.HttpServletRequest, jakarta.servlet.http.HttpServletResponse, jakarta.servlet.FilterChain)

    /**
     * @utbot.classUnderTest {@link JwtFilter}
     * @utbot.methodUnderTest {@link JwtFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     * @utbot.throwsException {@link NullPointerException} in: String authorizationHeader = request.getHeader("Authorization");
     */
    @Test
    @DisplayName("doFilterInternal: authorizationHeader = request.getHeader(\"Authorization\") : True -> ThrowNullPointerException")
    public void testDoFilterInternal_ThrowNullPointerException() throws ServletException, IOException {
        /* This test fails because method [com.stayhere.app.security.JwtFilter.doFilterInternal] produces [java.lang.NullPointerException]
            com.stayhere.app.security.JwtFilter.doFilterInternal(JwtFilter.java:32) */
        jwtFilter.doFilterInternal(null, null, null);
    }

    /**
     * @utbot.classUnderTest {@link JwtFilter}
     * @utbot.methodUnderTest {@link JwtFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     * @utbot.executesCondition {@code (authorizationHeader != null): False}
     * @utbot.throwsException {@link NullPointerException} in: chain.doFilter(request, response);
     */
    @Test
    @DisplayName("doFilterInternal: chain.doFilter(request, response) : True -> ThrowNullPointerException")
    public void testDoFilterInternal_ThrowNullPointerException_1() throws ServletException, IOException {
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        (when(requestMock.getHeader(any()))).thenReturn(((String) null));
        
        /* This test fails because method [com.stayhere.app.security.JwtFilter.doFilterInternal] produces [java.lang.NullPointerException]
            com.stayhere.app.security.JwtFilter.doFilterInternal(JwtFilter.java:58) */
        jwtFilter.doFilterInternal(requestMock, null, null);
    }

    /**
     * @utbot.classUnderTest {@link JwtFilter}
     * @utbot.methodUnderTest {@link JwtFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     * @utbot.executesCondition {@code (authorizationHeader != null): True}
     * @utbot.executesCondition {@code (authorizationHeader.startsWith("Bearer ")): False}
     * @utbot.throwsException {@link NullPointerException} in: chain.doFilter(request, response);
     */
    @Test
    @DisplayName("doFilterInternal: chain.doFilter(request, response) : True -> ThrowNullPointerException")
    public void testDoFilterInternal_ThrowNullPointerException_2() throws ServletException, IOException {
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        String string = "\u0000\u0000\u0000\u0000\u0000\u0000\u0000";
        (when(requestMock.getHeader(any()))).thenReturn(string);
        
        /* This test fails because method [com.stayhere.app.security.JwtFilter.doFilterInternal] produces [java.lang.NullPointerException]
            com.stayhere.app.security.JwtFilter.doFilterInternal(JwtFilter.java:58) */
        jwtFilter.doFilterInternal(requestMock, null, null);
    }

    /**
     * @utbot.classUnderTest {@link JwtFilter}
     * @utbot.methodUnderTest {@link JwtFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     * @utbot.executesCondition {@code (authorizationHeader != null): True}
     * @utbot.executesCondition {@code (authorizationHeader.startsWith("Bearer ")): True}
     * @utbot.caughtException {@code Exception e}
     * @utbot.throwsException {@link NullPointerException} in: response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
     */
    @Test
    @DisplayName("doFilterInternal: response.setStatus(HttpServletResponse.SC_UNAUTHORIZED) : True -> ThrowNullPointerException")
    public void testDoFilterInternal_ThrowNullPointerException_3() throws Exception {
        MockedConstruction mockedConstruction = null;
        MockedStatic mockedStatic = null;
        MockedStatic mockedStatic1 = null;
        try {
            mockedConstruction = mockConstruction(JWTVerificationException.class, (JWTVerificationException jWTVerificationExceptionMock, Context context) -> {
            });
            mockedStatic = mockStatic(Algorithm.class);
            (mockedStatic.when(() -> Algorithm.HMAC256(any(String.class)))).thenReturn(((Algorithm) null));
            mockedStatic1 = mockStatic(JWT.class);
            Verification verificationMock = mock(Verification.class);
            (when(verificationMock.withIssuer(any(String.class)))).thenReturn(verificationMock);
            JWTVerifier jWTVerifierMock = mock(JWTVerifier.class);
            DecodedJWT decodedJWTMock = mock(DecodedJWT.class);
            Claim claimMock = mock(Claim.class);
            (when(claimMock.asString())).thenReturn(((String) null));
            (when(decodedJWTMock.getClaim(any()))).thenReturn(claimMock);
            (when(jWTVerifierMock.verify(any(String.class)))).thenReturn(decodedJWTMock);
            (when(verificationMock.build())).thenReturn(jWTVerifierMock);
            (mockedStatic1.when(() -> JWT.require(any()))).thenReturn(verificationMock);
            JwtUtil jwtUtil = ((JwtUtil) createInstance("com.stayhere.app.security.JwtUtil"));
            String secret = "";
            setField(jwtUtil, "com.stayhere.app.security.JwtUtil", "secret", secret);
            setField(jwtFilter, "com.stayhere.app.security.JwtFilter", "jwtUtil", jwtUtil);
            HttpServletRequest requestMock = mock(HttpServletRequest.class);
            String string = "Bearer \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000";
            (when(requestMock.getHeader(any()))).thenReturn(string);

            /* This test fails because method [com.stayhere.app.security.JwtFilter.doFilterInternal] produces [java.lang.NullPointerException] */
            jwtFilter.doFilterInternal(requestMock, null, null);
        } finally {
            mockedConstruction.close();
            mockedStatic.close();
            mockedStatic1.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link JwtFilter}
     * @utbot.methodUnderTest {@link JwtFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     * @utbot.executesCondition {@code (authorizationHeader != null): True}
     * @utbot.executesCondition {@code (authorizationHeader.startsWith("Bearer ")): True}
     * @utbot.invokes {@link UserDetailsService#loadUserByUsername(String)}
     * @utbot.invokes {@link UserDetails#getAuthorities()}
     * @utbot.caughtException {@code Exception e}
     * @utbot.throwsException {@link NullPointerException} in: response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
     */
    @Test
    @DisplayName("doFilterInternal: response.setStatus(HttpServletResponse.SC_UNAUTHORIZED) : True -> ThrowNullPointerException")
    public void testDoFilterInternal_ThrowNullPointerException_4() throws Exception {
        MockedConstruction mockedConstruction = null;
        MockedStatic mockedStatic = null;
        MockedStatic mockedStatic1 = null;
        try {
            mockedConstruction = mockConstruction(UsernamePasswordAuthenticationToken.class, (UsernamePasswordAuthenticationToken usernamePasswordAuthenticationTokenMock, Context context) -> {
            });
            mockedStatic = mockStatic(Algorithm.class);
            (mockedStatic.when(() -> Algorithm.HMAC256(any(String.class)))).thenReturn(((Algorithm) null));
            mockedStatic1 = mockStatic(JWT.class);
            Verification verificationMock = mock(Verification.class);
            (when(verificationMock.withIssuer(any(String.class)))).thenReturn(verificationMock);
            JWTVerifier jWTVerifierMock = mock(JWTVerifier.class);
            DecodedJWT decodedJWTMock = mock(DecodedJWT.class);
            Claim claimMock = mock(Claim.class);
            String string = "Bearer \u0000\u0000\u0000\u0000";
            (when(claimMock.asString())).thenReturn(string);
            (when(decodedJWTMock.getClaim(any()))).thenReturn(claimMock);
            (when(jWTVerifierMock.verify(any(String.class)))).thenReturn(decodedJWTMock);
            (when(verificationMock.build())).thenReturn(jWTVerifierMock);
            (mockedStatic1.when(() -> JWT.require(any()))).thenReturn(verificationMock);
            JwtUtil jwtUtil = ((JwtUtil) createInstance("com.stayhere.app.security.JwtUtil"));
            String secret = "";
            setField(jwtUtil, "com.stayhere.app.security.JwtUtil", "secret", secret);
            setField(jwtFilter, "com.stayhere.app.security.JwtFilter", "jwtUtil", jwtUtil);
            (when(userDetailsServiceMock.loadUserByUsername(any()))).thenReturn(((UserDetails) null));
            HttpServletRequest requestMock = mock(HttpServletRequest.class);
            (when(requestMock.getHeader(any()))).thenReturn(string);

            /* This test fails because method [com.stayhere.app.security.JwtFilter.doFilterInternal] produces [java.lang.NullPointerException] */
            jwtFilter.doFilterInternal(requestMock, null, null);
        } finally {
            mockedConstruction.close();
            mockedStatic.close();
            mockedStatic1.close();
        }
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method doFilterInternal(jakarta.servlet.http.HttpServletRequest, jakarta.servlet.http.HttpServletResponse, jakarta.servlet.FilterChain)

    /**
     * @utbot.classUnderTest {@link JwtFilter}
     * @utbot.methodUnderTest {@link JwtFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    @DisplayName("doFilterInternal: request = mock(), response = mock(), chain = mock()")
    public void testDoFilterInternal() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, ServletException {
        JwtUtil jwtUtil = new JwtUtil();
        setField(jwtFilter, "com.stayhere.app.security.JwtFilter", "jwtUtil", jwtUtil);
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        (when(requestMock.getHeader(any()))).thenReturn("Bearer ");
        HttpServletResponse responseMock = mock(HttpServletResponse.class);
        (((HttpServletResponse) (doNothing()).when(responseMock))).setStatus(anyInt());
        PrintWriter printWriterMock = mock(PrintWriter.class);
        (((PrintWriter) (doNothing()).when(printWriterMock))).write(any(String.class));
        (when(responseMock.getWriter())).thenReturn(printWriterMock);
        FilterChain chainMock = mock(FilterChain.class);

        jwtFilter.doFilterInternal(requestMock, responseMock, chainMock);
    }
    ///endregion

    ///region FUZZER: TIMEOUTS for method doFilterInternal(jakarta.servlet.http.HttpServletRequest, jakarta.servlet.http.HttpServletResponse, jakarta.servlet.FilterChain)

    /**
     * @utbot.classUnderTest {@link JwtFilter}
     * @utbot.methodUnderTest {@link JwtFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    @Test
    @DisplayName("doFilterInternal: request = mock(), response = mock(), chain = mock()")
    @Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
    public void testDoFilterInternal1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, ServletException {
        JwtUtil jwtUtil = new JwtUtil();
        setField(jwtFilter, "com.stayhere.app.security.JwtFilter", "jwtUtil", jwtUtil);
        hashSetSpy.add("earer ");
        hashSetSpy.add("-3");
        hashSetSpy.add("\n\t\r");
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        (when(requestMock.getHeader(any()))).thenReturn("Bearer ");
        HttpServletResponse responseMock = mock(HttpServletResponse.class);
        (((HttpServletResponse) (doNothing()).when(responseMock))).setStatus(anyInt());
        PrintWriter printWriterMock = mock(PrintWriter.class);
        (((PrintWriter) (doNothing()).when(printWriterMock))).write(any(String.class));
        (when(responseMock.getWriter())).thenReturn(printWriterMock);
        FilterChain chainMock = mock(FilterChain.class);
        
        /* This execution may take longer than the 1000 ms timeout
         and therefore fail due to exceeding the timeout. */
        assertTimeoutPreemptively(Duration.ofMillis(1000L), () -> jwtFilter.doFilterInternal(requestMock, responseMock, chainMock));
    }
    ///endregion

    ///endregion


    @BeforeEach
    public void setUp() {
        mockitoCloseable = openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        hashSetSpy.clear();
        mockitoCloseable.close();
    }

}
