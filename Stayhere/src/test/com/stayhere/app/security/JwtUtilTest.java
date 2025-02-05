package com.stayhere.app.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.stayhere.app.model.UserDto.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.utbot.runtime.utils.java.UtUtils.createInstance;
import static org.utbot.runtime.utils.java.UtUtils.setField;

public final class JwtUtilTest {
    ///region Test suites for executable com.stayhere.app.security.JwtUtil.generateToken

    ///region OTHER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method generateToken(java.lang.String, com.stayhere.app.model.UserDto$Role, java.lang.String)

    @Test
    public void testGenerateToken1() throws Exception {
        JwtUtil jwtUtil = ((JwtUtil) createInstance("com.stayhere.app.security.JwtUtil"));
        String expirationTime = "\u0000\u0000\u0000";
        setField(jwtUtil, "com.stayhere.app.security.JwtUtil", "expirationTime", expirationTime);
        String string = "";
        Role role = Role.TENANT;

        assertThrows(RuntimeException.class, () -> jwtUtil.generateToken(string, role, null));
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.security.JwtUtil.validateToken

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method validateToken(java.lang.String)

    /**
     * @utbot.classUnderTest {@link JwtUtil}
     * @utbot.methodUnderTest {@link JwtUtil#validateToken(String)}
     * @utbot.throwsException {@link NullPointerException} in: withIssuer
     */
    @Test
    @DisplayName("validateToken: withIssuer -> ThrowNullPointerException")
    public void testValidateToken_ThrowNullPointerException() throws Exception {
        MockedStatic mockedStatic = null;
        MockedStatic mockedStatic1 = null;
        try {
            mockedStatic = mockStatic(Algorithm.class);
            (mockedStatic.when(() -> Algorithm.HMAC256(any(String.class)))).thenReturn(((Algorithm) null));
            mockedStatic1 = mockStatic(JWT.class);
            (mockedStatic1.when(() -> JWT.require(any()))).thenReturn(((Verification) null));
            JwtUtil jwtUtil = ((JwtUtil) createInstance("com.stayhere.app.security.JwtUtil"));
            String secret = "";
            setField(jwtUtil, "com.stayhere.app.security.JwtUtil", "secret", secret);

            /* This test fails because method [com.stayhere.app.security.JwtUtil.validateToken] produces [java.lang.NullPointerException] */
            jwtUtil.validateToken(null);
        } finally {
            mockedStatic.close();
            mockedStatic1.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link JwtUtil}
     * @utbot.methodUnderTest {@link JwtUtil#validateToken(String)}
     * @utbot.throwsException {@link NullPointerException} in: build
     */
    @Test
    @DisplayName("validateToken: build -> ThrowNullPointerException")
    public void testValidateToken_ThrowNullPointerException_1() throws Exception {
        MockedStatic mockedStatic = null;
        MockedStatic mockedStatic1 = null;
        try {
            mockedStatic = mockStatic(Algorithm.class);
            (mockedStatic.when(() -> Algorithm.HMAC256(any(String.class)))).thenReturn(((Algorithm) null));
            mockedStatic1 = mockStatic(JWT.class);
            Verification verificationMock = mock(Verification.class);
            (when(verificationMock.withIssuer(any(String.class)))).thenReturn(((Verification) null));
            (mockedStatic1.when(() -> JWT.require(any()))).thenReturn(verificationMock);
            JwtUtil jwtUtil = ((JwtUtil) createInstance("com.stayhere.app.security.JwtUtil"));
            String secret = "";
            setField(jwtUtil, "com.stayhere.app.security.JwtUtil", "secret", secret);

            /* This test fails because method [com.stayhere.app.security.JwtUtil.validateToken] produces [java.lang.NullPointerException] */
            jwtUtil.validateToken(null);
        } finally {
            mockedStatic.close();
            mockedStatic1.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link JwtUtil}
     * @utbot.methodUnderTest {@link JwtUtil#validateToken(String)}
     * @utbot.throwsException {@link NullPointerException} in: DecodedJWT jwt = verifier.verify(token);
     */
    @Test
    @DisplayName("validateToken: jwt = verifier.verify(token) : True -> ThrowNullPointerException")
    public void testValidateToken_ThrowNullPointerException_2() throws Exception {
        MockedStatic mockedStatic = null;
        MockedStatic mockedStatic1 = null;
        try {
            mockedStatic = mockStatic(Algorithm.class);
            (mockedStatic.when(() -> Algorithm.HMAC256(any(String.class)))).thenReturn(((Algorithm) null));
            mockedStatic1 = mockStatic(JWT.class);
            Verification verificationMock = mock(Verification.class);
            (when(verificationMock.withIssuer(any(String.class)))).thenReturn(verificationMock);
            (when(verificationMock.build())).thenReturn(((JWTVerifier) null));
            (mockedStatic1.when(() -> JWT.require(any()))).thenReturn(verificationMock);
            JwtUtil jwtUtil = ((JwtUtil) createInstance("com.stayhere.app.security.JwtUtil"));
            String secret = "";
            setField(jwtUtil, "com.stayhere.app.security.JwtUtil", "secret", secret);

            /* This test fails because method [com.stayhere.app.security.JwtUtil.validateToken] produces [java.lang.NullPointerException] */
            jwtUtil.validateToken(null);
        } finally {
            mockedStatic.close();
            mockedStatic1.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link JwtUtil}
     * @utbot.methodUnderTest {@link JwtUtil#validateToken(String)}
     * @utbot.throwsException {@link NullPointerException} in: String username = jwt.getClaim("username").asString();
     */
    @Test
    @DisplayName("validateToken: username = jwt.getClaim(\"username\").asString() : True -> ThrowNullPointerException")
    public void testValidateToken_ThrowNullPointerException_3() throws Exception {
        MockedStatic mockedStatic = null;
        MockedStatic mockedStatic1 = null;
        try {
            mockedStatic = mockStatic(Algorithm.class);
            (mockedStatic.when(() -> Algorithm.HMAC256(any(String.class)))).thenReturn(((Algorithm) null));
            mockedStatic1 = mockStatic(JWT.class);
            Verification verificationMock = mock(Verification.class);
            (when(verificationMock.withIssuer(any(String.class)))).thenReturn(verificationMock);
            JWTVerifier jWTVerifierMock = mock(JWTVerifier.class);
            (when(jWTVerifierMock.verify(any(String.class)))).thenReturn(((DecodedJWT) null));
            (when(verificationMock.build())).thenReturn(jWTVerifierMock);
            (mockedStatic1.when(() -> JWT.require(any()))).thenReturn(verificationMock);
            JwtUtil jwtUtil = ((JwtUtil) createInstance("com.stayhere.app.security.JwtUtil"));
            String secret = "";
            setField(jwtUtil, "com.stayhere.app.security.JwtUtil", "secret", secret);

            /* This test fails because method [com.stayhere.app.security.JwtUtil.validateToken] produces [java.lang.NullPointerException] */
            jwtUtil.validateToken(null);
        } finally {
            mockedStatic.close();
            mockedStatic1.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link JwtUtil}
     * @utbot.methodUnderTest {@link JwtUtil#validateToken(String)}
     * @utbot.invokes {@link Claim#asString()}
     * @utbot.throwsException {@link NullPointerException} in: String username = jwt.getClaim("username").asString();
     */
    @Test
    @DisplayName("validateToken: username = jwt.getClaim(\"username\").asString() : True -> ThrowNullPointerException")
    public void testValidateToken_ThrowNullPointerException_4() throws Exception {
        MockedStatic mockedStatic = null;
        MockedStatic mockedStatic1 = null;
        try {
            mockedStatic = mockStatic(Algorithm.class);
            (mockedStatic.when(() -> Algorithm.HMAC256(any(String.class)))).thenReturn(((Algorithm) null));
            mockedStatic1 = mockStatic(JWT.class);
            Verification verificationMock = mock(Verification.class);
            (when(verificationMock.withIssuer(any(String.class)))).thenReturn(verificationMock);
            JWTVerifier jWTVerifierMock = mock(JWTVerifier.class);
            DecodedJWT decodedJWTMock = mock(DecodedJWT.class);
            (when(decodedJWTMock.getClaim(any()))).thenReturn(((Claim) null));
            (when(jWTVerifierMock.verify(any(String.class)))).thenReturn(decodedJWTMock);
            (when(verificationMock.build())).thenReturn(jWTVerifierMock);
            (mockedStatic1.when(() -> JWT.require(any()))).thenReturn(verificationMock);
            JwtUtil jwtUtil = ((JwtUtil) createInstance("com.stayhere.app.security.JwtUtil"));
            String secret = "";
            setField(jwtUtil, "com.stayhere.app.security.JwtUtil", "secret", secret);

            /* This test fails because method [com.stayhere.app.security.JwtUtil.validateToken] produces [java.lang.NullPointerException] */
            jwtUtil.validateToken(null);
        } finally {
            mockedStatic.close();
            mockedStatic1.close();
        }
    }
    ///endregion

    ///region FUZZER: EXPLICITLY THROWN UNCHECKED EXCEPTIONS for method validateToken(java.lang.String)

    /**
     * @utbot.classUnderTest {@link JwtUtil}
     * @utbot.methodUnderTest {@link JwtUtil#validateToken(String)}
     */
    @Test
    @DisplayName("validateToken: token = 'StayHere' -> throw JWTDecodeException")
    public void testValidateTokenThrowsJWTDEWithNonEmptyString() throws Exception {
        JwtUtil jwtUtil = ((JwtUtil) createInstance("com.stayhere.app.security.JwtUtil"));
        setField(jwtUtil, "com.stayhere.app.security.JwtUtil", "expirationTime", "\n\t\r");
        setField(jwtUtil, "com.stayhere.app.security.JwtUtil", "secret", "\n\t\r");

        assertThrows(com.auth0.jwt.exceptions.JWTDecodeException.class, () -> jwtUtil.validateToken("StayHere"));
    }
    ///endregion

    ///endregion
}
