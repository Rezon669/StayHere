package com.stayhere.app.controller;

import com.stayhere.app.model.PropertyDto;
import com.stayhere.app.service.PropertyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.utbot.runtime.utils.java.UtUtils.*;

public final class PropertyControllerTest {
    @InjectMocks
    private PropertyController propertyController;

    @Mock
    private PropertyService propertyServiceMock;

    private AutoCloseable mockitoCloseable;

    ///region Test suites for executable com.stayhere.app.controller.PropertyController.addProperty

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method addProperty(com.stayhere.app.model.PropertyDto)

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#addProperty(PropertyDto)}
     * @utbot.throwsException {@link NullPointerException} in: PropertyDto addProperty = propertyService.addProperty(property);
     */
    @Test
    @DisplayName("addProperty: addProperty = propertyService.addProperty(property) : True -> ThrowNullPointerException")
    public void testAddProperty_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(propertyController, "com.stayhere.app.controller.PropertyController", "propertyService", null);

        /* This test fails because method [com.stayhere.app.controller.PropertyController.addProperty] produces [java.lang.NullPointerException] */
        propertyController.addProperty(null);
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#addProperty(PropertyDto)}
     * @utbot.throwsException {@link NullPointerException} in: addProperty.setUser(null);
     */
    @Test
    @DisplayName("addProperty: addProperty.setUser(null) : True -> ThrowNullPointerException")
    public void testAddProperty_ThrowNullPointerException_1() {
        (when(propertyServiceMock.addProperty(any()))).thenReturn(((PropertyDto) null));

        /* This test fails because method [com.stayhere.app.controller.PropertyController.addProperty] produces [java.lang.NullPointerException] */
        propertyController.addProperty(null);
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#addProperty(PropertyDto)}
     * @utbot.invokes {@link Logger#info(String)}
     * @utbot.throwsException {@link NullPointerException} in: log.info("Property details are added successfully");
     */
    @Test
    @DisplayName("addProperty: log.info(\"Property details are added successfully\") : True -> ThrowNullPointerException")
    public void testAddProperty_ThrowNullPointerException_2() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyControllerClazz = Class.forName("com.stayhere.app.controller.PropertyController");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyControllerClazz, "log"));
            try {
                setStaticField(propertyControllerClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                PropertyDto propertyDtoMock = mock(PropertyDto.class);
                (((PropertyDto) (doNothing()).when(propertyDtoMock))).setUser(any());
                (when(propertyServiceMock.addProperty(any()))).thenReturn(propertyDtoMock);

                /* This test fails because method [com.stayhere.app.controller.PropertyController.addProperty] produces [java.lang.NullPointerException] */
                propertyController.addProperty(null);
            } finally {
                setStaticField(PropertyController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.controller.PropertyController.getProperties

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method getProperties()

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#getProperties()}
     * @utbot.throwsException {@link NullPointerException} in: List<PropertyDto> properties = propertyService.getProperties();
     */
    @Test
    @DisplayName("getProperties: properties = propertyService.getProperties() : True -> ThrowNullPointerException")
    public void testGetProperties_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(propertyController, "com.stayhere.app.controller.PropertyController", "propertyService", null);

        /* This test fails because method [com.stayhere.app.controller.PropertyController.getProperties] produces [java.lang.NullPointerException] */
        propertyController.getProperties();
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#getProperties()}
     * @utbot.throwsException {@link NullPointerException} in: properties.forEach(property -> property.setUser(null));
     */
    @Test
    @DisplayName("getProperties: properties.forEach(property -> property.setUser(null)) : True -> ThrowNullPointerException")
    public void testGetProperties_ThrowNullPointerException_2() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyControllerClazz = Class.forName("com.stayhere.app.controller.PropertyController");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyControllerClazz, "log"));
            try {
                Logger logMock = mock(Logger.class);
                (((Logger) (doNothing()).when(logMock))).info(((String) any(String.class)));
                setStaticField(propertyControllerClazz, "log", logMock);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(logMock);
                (when(propertyServiceMock.getProperties())).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.controller.PropertyController.getProperties] produces [java.lang.NullPointerException] */
                propertyController.getProperties();
            } finally {
                setStaticField(PropertyController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#getProperties()}
     * @utbot.throwsException {@link NullPointerException} in: log.info("Properties information fetched successfully");
     */
    @Test
    @DisplayName("getProperties: log.info(\"Properties information fetched successfully\") : True -> ThrowNullPointerException")
    public void testGetProperties_ThrowNullPointerException_1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyControllerClazz = Class.forName("com.stayhere.app.controller.PropertyController");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyControllerClazz, "log"));
            try {
                setStaticField(propertyControllerClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(propertyServiceMock.getProperties())).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.controller.PropertyController.getProperties] produces [java.lang.NullPointerException] */
                propertyController.getProperties();
            } finally {
                setStaticField(PropertyController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.controller.PropertyController.deleteProperty

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method deleteProperty(long)

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#deleteProperty(long)}
     * @utbot.throwsException {@link NullPointerException} in: PropertyDto deletedProperty = propertyService.deleteProperty(propertyId);
     */
    @Test
    @DisplayName("deleteProperty: deletedProperty = propertyService.deleteProperty(propertyId) : True -> ThrowNullPointerException")
    public void testDeleteProperty_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(propertyController, "com.stayhere.app.controller.PropertyController", "propertyService", null);

        /* This test fails because method [com.stayhere.app.controller.PropertyController.deleteProperty] produces [java.lang.NullPointerException] */
        propertyController.deleteProperty(-255L);
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#deleteProperty(long)}
     * @utbot.invokes {@link PropertyDto#setUser(com.stayhere.app.model.UserDto)}
     * @utbot.throwsException {@link NullPointerException} in: deletedProperty.setUser(null);
     */
    @Test
    @DisplayName("deleteProperty: deletedProperty.setUser(null) : True -> ThrowNullPointerException")
    public void testDeleteProperty_ThrowNullPointerException_2() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyControllerClazz = Class.forName("com.stayhere.app.controller.PropertyController");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyControllerClazz, "log"));
            try {
                Logger logMock = mock(Logger.class);
                (((Logger) (doNothing()).when(logMock))).info(((String) any(String.class)), any(Object.class));
                setStaticField(propertyControllerClazz, "log", logMock);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(logMock);
                (when(propertyServiceMock.deleteProperty(anyLong()))).thenReturn(((PropertyDto) null));

                /* This test fails because method [com.stayhere.app.controller.PropertyController.deleteProperty] produces [java.lang.NullPointerException] */
                propertyController.deleteProperty(-255L);
            } finally {
                setStaticField(PropertyController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#deleteProperty(long)}
     * @utbot.throwsException {@link NullPointerException} in: log.info("Property deleted successfully with id: {}", propertyId);
     */
    @Test
    @DisplayName("deleteProperty: log.info(\"Property deleted successfully with id: {}\", propertyId) : True -> ThrowNullPointerException")
    public void testDeleteProperty_ThrowNullPointerException_1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyControllerClazz = Class.forName("com.stayhere.app.controller.PropertyController");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyControllerClazz, "log"));
            try {
                setStaticField(propertyControllerClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(propertyServiceMock.deleteProperty(anyLong()))).thenReturn(((PropertyDto) null));

                /* This test fails because method [com.stayhere.app.controller.PropertyController.deleteProperty] produces [java.lang.NullPointerException] */
                propertyController.deleteProperty(-255L);
            } finally {
                setStaticField(PropertyController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.controller.PropertyController.updateProperty

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method updateProperty(long, com.stayhere.app.model.PropertyDto)

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#updateProperty(long, PropertyDto)}
     * @utbot.throwsException {@link NullPointerException} in: PropertyDto updatedProperty = propertyService.updateProperty(propertyId, updateproperty);
     */
    @Test
    @DisplayName("updateProperty: updatedProperty = propertyService.updateProperty(propertyId, updateproperty) : True -> ThrowNullPointerException")
    public void testUpdateProperty_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(propertyController, "com.stayhere.app.controller.PropertyController", "propertyService", null);

        /* This test fails because method [com.stayhere.app.controller.PropertyController.updateProperty] produces [java.lang.NullPointerException] */
        propertyController.updateProperty(-255L, null);
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#updateProperty(long, PropertyDto)}
     * @utbot.invokes {@link PropertyDto#setUser(com.stayhere.app.model.UserDto)}
     * @utbot.throwsException {@link NullPointerException} in: updatedProperty.setUser(null);
     */
    @Test
    @DisplayName("updateProperty: updatedProperty.setUser(null) : True -> ThrowNullPointerException")
    public void testUpdateProperty_ThrowNullPointerException_2() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyControllerClazz = Class.forName("com.stayhere.app.controller.PropertyController");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyControllerClazz, "log"));
            try {
                Logger logMock = mock(Logger.class);
                (((Logger) (doNothing()).when(logMock))).info(((String) any(String.class)));
                setStaticField(propertyControllerClazz, "log", logMock);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(logMock);
                (when(propertyServiceMock.updateProperty(anyLong(), any()))).thenReturn(((PropertyDto) null));

                /* This test fails because method [com.stayhere.app.controller.PropertyController.updateProperty] produces [java.lang.NullPointerException] */
                propertyController.updateProperty(-255L, null);
            } finally {
                setStaticField(PropertyController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#updateProperty(long, PropertyDto)}
     * @utbot.throwsException {@link NullPointerException} in: log.info("Property details are updated successfully");
     */
    @Test
    @DisplayName("updateProperty: log.info(\"Property details are updated successfully\") : True -> ThrowNullPointerException")
    public void testUpdateProperty_ThrowNullPointerException_1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyControllerClazz = Class.forName("com.stayhere.app.controller.PropertyController");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyControllerClazz, "log"));
            try {
                setStaticField(propertyControllerClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(propertyServiceMock.updateProperty(anyLong(), any()))).thenReturn(((PropertyDto) null));

                /* This test fails because method [com.stayhere.app.controller.PropertyController.updateProperty] produces [java.lang.NullPointerException] */
                propertyController.updateProperty(-255L, null);
            } finally {
                setStaticField(PropertyController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.controller.PropertyController.getPropertiesById

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method getPropertiesById(long)

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#getPropertiesById(long)}
     * @utbot.throwsException {@link NullPointerException} in: List<PropertyDto> properties = propertyService.getPropertiesById(userId);
     */
    @Test
    @DisplayName("getPropertiesById: properties = propertyService.getPropertiesById(userId) : True -> ThrowNullPointerException")
    public void testGetPropertiesById_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(propertyController, "com.stayhere.app.controller.PropertyController", "propertyService", null);

        /* This test fails because method [com.stayhere.app.controller.PropertyController.getPropertiesById] produces [java.lang.NullPointerException] */
        propertyController.getPropertiesById(-255L);
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#getPropertiesById(long)}
     * @utbot.throwsException {@link NullPointerException} in: properties.forEach(property -> property.setUser(null));
     */
    @Test
    @DisplayName("getPropertiesById: properties.forEach(property -> property.setUser(null)) : True -> ThrowNullPointerException")
    public void testGetPropertiesById_ThrowNullPointerException_2() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyControllerClazz = Class.forName("com.stayhere.app.controller.PropertyController");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyControllerClazz, "log"));
            try {
                Logger logMock = mock(Logger.class);
                (((Logger) (doNothing()).when(logMock))).info(((String) any(String.class)));
                setStaticField(propertyControllerClazz, "log", logMock);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(logMock);
                (when(propertyServiceMock.getPropertiesById(anyLong()))).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.controller.PropertyController.getPropertiesById] produces [java.lang.NullPointerException] */
                propertyController.getPropertiesById(-255L);
            } finally {
                setStaticField(PropertyController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#getPropertiesById(long)}
     * @utbot.throwsException {@link NullPointerException} in: log.info("Properties information fetched successfully");
     */
    @Test
    @DisplayName("getPropertiesById: log.info(\"Properties information fetched successfully\") : True -> ThrowNullPointerException")
    public void testGetPropertiesById_ThrowNullPointerException_1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyControllerClazz = Class.forName("com.stayhere.app.controller.PropertyController");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyControllerClazz, "log"));
            try {
                setStaticField(propertyControllerClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(propertyServiceMock.getPropertiesById(anyLong()))).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.controller.PropertyController.getPropertiesById] produces [java.lang.NullPointerException] */
                propertyController.getPropertiesById(-255L);
            } finally {
                setStaticField(PropertyController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.controller.PropertyController.getPropertiesForSale

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method getPropertiesForSale()

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#getPropertiesForSale()}
     * @utbot.throwsException {@link NullPointerException} in: List<PropertyDto> properties = propertyService.getPropertiesForSale();
     */
    @Test
    @DisplayName("getPropertiesForSale: properties = propertyService.getPropertiesForSale() : True -> ThrowNullPointerException")
    public void testGetPropertiesForSale_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(propertyController, "com.stayhere.app.controller.PropertyController", "propertyService", null);

        /* This test fails because method [com.stayhere.app.controller.PropertyController.getPropertiesForSale] produces [java.lang.NullPointerException] */
        propertyController.getPropertiesForSale();
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#getPropertiesForSale()}
     * @utbot.throwsException {@link NullPointerException} in: properties.forEach(property -> property.setUser(null));
     */
    @Test
    @DisplayName("getPropertiesForSale: properties.forEach(property -> property.setUser(null)) : True -> ThrowNullPointerException")
    public void testGetPropertiesForSale_ThrowNullPointerException_2() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyControllerClazz = Class.forName("com.stayhere.app.controller.PropertyController");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyControllerClazz, "log"));
            try {
                Logger logMock = mock(Logger.class);
                (((Logger) (doNothing()).when(logMock))).info(((String) any(String.class)));
                setStaticField(propertyControllerClazz, "log", logMock);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(logMock);
                (when(propertyServiceMock.getPropertiesForSale())).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.controller.PropertyController.getPropertiesForSale] produces [java.lang.NullPointerException] */
                propertyController.getPropertiesForSale();
            } finally {
                setStaticField(PropertyController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#getPropertiesForSale()}
     * @utbot.throwsException {@link NullPointerException} in: log.info("Properties information fetched successfully");
     */
    @Test
    @DisplayName("getPropertiesForSale: log.info(\"Properties information fetched successfully\") : True -> ThrowNullPointerException")
    public void testGetPropertiesForSale_ThrowNullPointerException_1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyControllerClazz = Class.forName("com.stayhere.app.controller.PropertyController");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyControllerClazz, "log"));
            try {
                setStaticField(propertyControllerClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(propertyServiceMock.getPropertiesForSale())).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.controller.PropertyController.getPropertiesForSale] produces [java.lang.NullPointerException] */
                propertyController.getPropertiesForSale();
            } finally {
                setStaticField(PropertyController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.controller.PropertyController.getPropertiesForRentOrLease

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method getPropertiesForRentOrLease()

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#getPropertiesForRentOrLease()}
     * @utbot.throwsException {@link NullPointerException} in: List<PropertyDto> properties = propertyService.getPropertiesForRentOrLease();
     */
    @Test
    @DisplayName("getPropertiesForRentOrLease: properties = propertyService.getPropertiesForRentOrLease() : True -> ThrowNullPointerException")
    public void testGetPropertiesForRentOrLease_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        setField(propertyController, "com.stayhere.app.controller.PropertyController", "propertyService", null);

        /* This test fails because method [com.stayhere.app.controller.PropertyController.getPropertiesForRentOrLease] produces [java.lang.NullPointerException] */
        propertyController.getPropertiesForRentOrLease();
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#getPropertiesForRentOrLease()}
     * @utbot.throwsException {@link NullPointerException} in: properties.forEach(property -> property.setUser(null));
     */
    @Test
    @DisplayName("getPropertiesForRentOrLease: properties.forEach(property -> property.setUser(null)) : True -> ThrowNullPointerException")
    public void testGetPropertiesForRentOrLease_ThrowNullPointerException_2() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyControllerClazz = Class.forName("com.stayhere.app.controller.PropertyController");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyControllerClazz, "log"));
            try {
                Logger logMock = mock(Logger.class);
                (((Logger) (doNothing()).when(logMock))).info(((String) any(String.class)));
                setStaticField(propertyControllerClazz, "log", logMock);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(logMock);
                (when(propertyServiceMock.getPropertiesForRentOrLease())).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.controller.PropertyController.getPropertiesForRentOrLease] produces [java.lang.NullPointerException] */
                propertyController.getPropertiesForRentOrLease();
            } finally {
                setStaticField(PropertyController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#getPropertiesForRentOrLease()}
     * @utbot.throwsException {@link NullPointerException} in: log.info("Properties information fetched successfully");
     */
    @Test
    @DisplayName("getPropertiesForRentOrLease: log.info(\"Properties information fetched successfully\") : True -> ThrowNullPointerException")
    public void testGetPropertiesForRentOrLease_ThrowNullPointerException_1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyControllerClazz = Class.forName("com.stayhere.app.controller.PropertyController");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyControllerClazz, "log"));
            try {
                setStaticField(propertyControllerClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(propertyServiceMock.getPropertiesForRentOrLease())).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.controller.PropertyController.getPropertiesForRentOrLease] produces [java.lang.NullPointerException] */
                propertyController.getPropertiesForRentOrLease();
            } finally {
                setStaticField(PropertyController.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region FUZZER: TIMEOUTS for method getPropertiesForRentOrLease()

    /**
     * @utbot.classUnderTest {@link PropertyController}
     * @utbot.methodUnderTest {@link PropertyController#getPropertiesForRentOrLease()}
     */
    @Test
    @DisplayName("getPropertiesForRentOrLease: ")
    @Timeout(value = 1000L, unit = TimeUnit.MILLISECONDS)
    public void testGetPropertiesForRentOrLease() {
        /* This execution may take longer than the 1000 ms timeout
         and therefore fail due to exceeding the timeout. */
        assertTimeoutPreemptively(Duration.ofMillis(1000L), () -> propertyController.getPropertiesForRentOrLease());
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
