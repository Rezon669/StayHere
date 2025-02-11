package com.stayhere.app.service;

import com.stayhere.app.model.PropertyDto;
import com.stayhere.app.model.UserDto;
import com.stayhere.app.repo.PropertyRepository;
import com.stayhere.app.repo.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;


public final class PropertyServiceTest {
    @InjectMocks
    private PropertyService propertyService;

    @Mock
    private UserRepository userRepositoryMock;

    @Mock
    private PropertyRepository propertyRepositoryMock;

    private AutoCloseable mockitoCloseable;

    ///region Test suites for executable com.stayhere.app.service.PropertyService.addProperty

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method addProperty(com.stayhere.app.model.PropertyDto)


    @Test
    @DisplayName("addProperty: return userRepo.findById(property.getUser().getUserid()).map(user -> { property.setUser(user) PropertyDto savedProperty = propertyRepo.save(property) log.info(\"Property added successfully for User ID: {}\", user.getUserid()) return savedProperty }).orElseThrow(() -> new CustomException(\"Error when adding property details\", \"No user found with the given ID to map the property\")) : True -> ThrowNullPointerException")
    public void testAddProperty_ThrowNullPointerException() {
        /* This test fails because method [com.stayhere.app.service.PropertyService.addProperty] produces [java.lang.NullPointerException]
            com.stayhere.app.service.PropertyService.addProperty(PropertyService.java:36) */
        propertyService.addProperty(null);
    }

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#addProperty(PropertyDto)}
     * @utbot.throwsException {@link NullPointerException} in: return userRepo.findById(property.getUser().getUserid()).map(user -> {
     * property.setUser(user);
     * PropertyDto savedProperty = propertyRepo.save(property);
     * log.info("Property added successfully for User ID: {}", user.getUserid());
     * return savedProperty;
     * }).orElseThrow(() -> new CustomException("Error when adding property details", "No user found with the given ID to map the property"));
     */
    @Test
    @DisplayName("addProperty: return userRepo.findById(property.getUser().getUserid()).map(user -> { property.setUser(user) PropertyDto savedProperty = propertyRepo.save(property) log.info(\"Property added successfully for User ID: {}\", user.getUserid()) return savedProperty }).orElseThrow(() -> new CustomException(\"Error when adding property details\", \"No user found with the given ID to map the property\")) : True -> ThrowNullPointerException")
    public void testAddProperty_ThrowNullPointerException_1() {
        PropertyDto propertyMock = mock(PropertyDto.class);
        (when(propertyMock.getUser())).thenReturn(((UserDto) null));
        
        /* This test fails because method [com.stayhere.app.service.PropertyService.addProperty] produces [java.lang.NullPointerException]
            com.stayhere.app.service.PropertyService.addProperty(PropertyService.java:36) */
        propertyService.addProperty(propertyMock);
    }

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#addProperty(PropertyDto)}
     * @utbot.throwsException {@link NullPointerException} in: return userRepo.findById(property.getUser().getUserid()).map(user -> {
     * property.setUser(user);
     * PropertyDto savedProperty = propertyRepo.save(property);
     * log.info("Property added successfully for User ID: {}", user.getUserid());
     * return savedProperty;
     * }).orElseThrow(() -> new CustomException("Error when adding property details", "No user found with the given ID to map the property"));
     */
    @Test
    @DisplayName("addProperty: return userRepo.findById(property.getUser().getUserid()).map(user -> { property.setUser(user) PropertyDto savedProperty = propertyRepo.save(property) log.info(\"Property added successfully for User ID: {}\", user.getUserid()) return savedProperty }).orElseThrow(() -> new CustomException(\"Error when adding property details\", \"No user found with the given ID to map the property\")) : True -> ThrowNullPointerException")
    public void testAddProperty_ThrowNullPointerException_2() {
        (when(userRepositoryMock.findById(any()))).thenReturn(((Optional) null));
        PropertyDto propertyMock = mock(PropertyDto.class);
        UserDto userDtoMock = mock(UserDto.class);
        (when(userDtoMock.getUserid())).thenReturn(0L);
        (when(propertyMock.getUser())).thenReturn(userDtoMock);
        
        /* This test fails because method [com.stayhere.app.service.PropertyService.addProperty] produces [java.lang.NullPointerException]
            com.stayhere.app.service.PropertyService.addProperty(PropertyService.java:36) */
        propertyService.addProperty(propertyMock);
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method addProperty(com.stayhere.app.model.PropertyDto)

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#addProperty(PropertyDto)}
     */
    @Test
    @DisplayName("addProperty: property = mock() -> return null")
    public void testAddProperty() throws Throwable {
        Optional optionalMock = mock(Optional.class);
        Optional optionalMock1 = mock(Optional.class);
        (when(optionalMock1.orElseThrow(any()))).thenReturn(null);
        (when(optionalMock.map(any()))).thenReturn(optionalMock1);
        (when(userRepositoryMock.findById(any()))).thenReturn(optionalMock);
        PropertyDto propertyMock = mock(PropertyDto.class);
        UserDto userDtoMock = mock(UserDto.class);
        (when(userDtoMock.getUserid())).thenReturn(0L);
        (when(propertyMock.getUser())).thenReturn(userDtoMock);

        PropertyDto actual = propertyService.addProperty(propertyMock);

        assertNull(actual);
    }
    ///endregion

    ///region OTHER: ERROR SUITE for method addProperty(com.stayhere.app.model.PropertyDto)

    @Test
    public void testAddProperty1() {
        Optional optional = empty();
        (when(userRepositoryMock.findById(any()))).thenReturn(optional);
        PropertyDto propertyMock = mock(PropertyDto.class);
        UserDto userDtoMock = mock(UserDto.class);
        (when(userDtoMock.getUserid())).thenReturn(0L);
        (when(propertyMock.getUser())).thenReturn(userDtoMock);
        
        /* This test fails because method [com.stayhere.app.service.PropertyService.addProperty] produces [com.stayhere.app.exceptions.CustomException: Error when adding property details]
            com.stayhere.app.service.PropertyService.lambda$addProperty$1(PropertyService.java:41)
            java.base/java.util.Optional.orElseThrow(Optional.java:403)
            com.stayhere.app.service.PropertyService.addProperty(PropertyService.java:41) */
        propertyService.addProperty(propertyMock);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.service.PropertyService.getProperties

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getProperties()

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#getProperties()}
     * @utbot.invokes {@link PropertyRepository#findAll()}
     * @utbot.invokes {@link Logger#info(String)}
     * @utbot.returnsFrom {@code return properties;}
     */
    @Test
    @DisplayName("getProperties: -> PropertyRepositoryFindAll")
    public void testGetProperties_PropertyRepositoryFindAll() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyServiceClazz = Class.forName("com.stayhere.app.service.PropertyService");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyServiceClazz, "log"));
            try {
                Logger logMock = mock(Logger.class);
                (((Logger) (doNothing()).when(logMock))).info(((String) any(String.class)));
                setStaticField(propertyServiceClazz, "log", logMock);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(logMock);
                (when(propertyRepositoryMock.findAll())).thenReturn(((List) null));

                ArrayList actual = ((ArrayList) propertyService.getProperties());

                assertNull(actual);
            } finally {
                setStaticField(PropertyService.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method getProperties()

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#getProperties()}
     * @utbot.invokes {@link PropertyRepository#findAll()}
     * @utbot.invokes {@link Logger#info(String)}
     * @utbot.throwsException {@link NullPointerException} in: log.info("Fetched all property details successfully.");
     */
    @Test
    @DisplayName("getProperties: log.info(\"Fetched all property details successfully.\") : True -> ThrowNullPointerException")
    public void testGetProperties_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyServiceClazz = Class.forName("com.stayhere.app.service.PropertyService");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyServiceClazz, "log"));
            try {
                setStaticField(propertyServiceClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(propertyRepositoryMock.findAll())).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.service.PropertyService.getProperties] produces [java.lang.NullPointerException] */
                propertyService.getProperties();
            } finally {
                setStaticField(PropertyService.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region Errors report for getProperties

    public void testGetProperties_errors() {
        // Couldn't generate some tests. List of errors:
        // 
        // 1 occurrences of:
        // org.mockito.codegen.List$MockitoMock$LRlCHFZV

    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.service.PropertyService.deleteProperty

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method deleteProperty(long)

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#deleteProperty(long)}
     * @utbot.throwsException {@link NullPointerException} in: return propertyRepo.findById(id).map(property -> {
     * propertyRepo.deleteById(id);
     * log.info("Property details deleted successfully with ID: {}", id);
     * return property;
     * }).orElseThrow(() -> new CustomException("Property details are not found", "No Properties details are exists with the given ID: " + id));
     */
    @Test
    @DisplayName("deleteProperty: return propertyRepo.findById(id).map(property -> { propertyRepo.deleteById(id) log.info(\"Property details deleted successfully with ID: {}\", id) return property }).orElseThrow(() -> new CustomException(\"Property details are not found\", \"No Properties details are exists with the given ID: \" + id)) : True -> ThrowNullPointerException")
    public void testDeleteProperty_ThrowNullPointerException() {
        (when(propertyRepositoryMock.findById(any()))).thenReturn(((Optional) null));
        
        /* This test fails because method [com.stayhere.app.service.PropertyService.deleteProperty] produces [java.lang.NullPointerException]
            com.stayhere.app.service.PropertyService.deleteProperty(PropertyService.java:52) */
        propertyService.deleteProperty(-255L);
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method deleteProperty(long)

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#deleteProperty(long)}
     */
    @Test
    @DisplayName("deleteProperty: id = -4194305 (mutated from -1) -> return null")
    public void testDeleteProperty() throws Throwable {
        Optional optionalMock = mock(Optional.class);
        Optional optionalMock1 = mock(Optional.class);
        (when(optionalMock1.orElseThrow(any()))).thenReturn(null);
        (when(optionalMock.map(any()))).thenReturn(optionalMock1);
        (when(propertyRepositoryMock.findById(any()))).thenReturn(optionalMock);

        PropertyDto actual = propertyService.deleteProperty(-4194305L);

        assertNull(actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.service.PropertyService.updateProperty

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method updateProperty(long, com.stayhere.app.model.PropertyDto)

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#updateProperty(long, PropertyDto)}
     * @utbot.throwsException {@link NullPointerException} in: return propertyRepo.findById(id).map(existingProperty -> {
     * existingProperty.setBhk(updateproperty.getBhk());
     * existingProperty.setArea(updateproperty.getArea());
     * existingProperty.setCity(updateproperty.getCity());
     * existingProperty.setCountry(updateproperty.getCountry());
     * existingProperty.setDoorNo(updateproperty.getDoorNo());
     * existingProperty.setDrinkingWater(updateproperty.getDrinkingWater());
     * existingProperty.setElectricity(updateproperty.getElectricity());
     * existingProperty.setMaintenanceCharges(updateproperty.getMaintenanceCharges());
     * existingProperty.setNormalWater(updateproperty.getNormalWater());
     * existingProperty.setParking(updateproperty.getParking());
     * existingProperty.setPincode(updateproperty.getPincode());
     * existingProperty.setPropertyIsFor(updateproperty.getPropertyIsFor());
     * existingProperty.setPropertyType(updateproperty.getPropertyType());
     * existingProperty.setRentAmount(updateproperty.getRentAmount());
     * existingProperty.setState(updateproperty.getState());
     * PropertyDto updatedProperty = propertyRepo.save(existingProperty);
     * log.info("Property details updated successfully for ID: {}", id);
     * return updatedProperty;
     * }).orElseThrow(() -> {
     * log.error("Property not found with ID: {}", id);
     * return new CustomException("Property not found", "No properties are exists with the given ID: " + id);
     * });
     */
    @Test
    @DisplayName("updateProperty: return propertyRepo.findById(id).map(existingProperty -> { existingProperty.setBhk(updateproperty.getBhk()) existingProperty.setArea(updateproperty.getArea()) existingProperty.setCity(updateproperty.getCity()) existingProperty.setCountry(updateproperty.getCountry()) existingProperty.setDoorNo(updateproperty.getDoorNo()) existingProperty.setDrinkingWater(updateproperty.getDrinkingWater()) existingProperty.setElectricity(updateproperty.getElectricity()) existingProperty.setMaintenanceCharges(updateproperty.getMaintenanceCharges()) existingProperty.setNormalWater(updateproperty.getNormalWater()) existingProperty.setParking(updateproperty.getParking()) existingProperty.setPincode(updateproperty.getPincode()) existingProperty.setPropertyIsFor(updateproperty.getPropertyIsFor()) existingProperty.setPropertyType(updateproperty.getPropertyType()) existingProperty.setRentAmount(updateproperty.getRentAmount()) existingProperty.setState(updateproperty.getState()) PropertyDto updatedProperty = propertyRepo.save(existingProperty) log.info(\"Property details updated successfully for ID: {}\", id) return updatedProperty }).orElseThrow(() -> { log.error(\"Property not found with ID: {}\", id) return new CustomException(\"Property not found\", \"No properties are exists with the given ID: \" + id) }) : True -> ThrowNullPointerException")
    public void testUpdateProperty_ThrowNullPointerException() {
        (when(propertyRepositoryMock.findById(any()))).thenReturn(((Optional) null));
        
        /* This test fails because method [com.stayhere.app.service.PropertyService.updateProperty] produces [java.lang.NullPointerException]
            com.stayhere.app.service.PropertyService.updateProperty(PropertyService.java:61) */
        propertyService.updateProperty(-255L, null);
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method updateProperty(long, com.stayhere.app.model.PropertyDto)

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#updateProperty(long, PropertyDto)}
     */
    @Test
    @DisplayName("updateProperty: id = -8193 (mutated from -1), updateproperty = mock() -> return null")
    public void testUpdateProperty() throws Throwable {
        Optional optionalMock = mock(Optional.class);
        Optional optionalMock1 = mock(Optional.class);
        (when(optionalMock1.orElseThrow(any()))).thenReturn(null);
        (when(optionalMock.map(any()))).thenReturn(optionalMock1);
        (when(propertyRepositoryMock.findById(any()))).thenReturn(optionalMock);
        PropertyDto updatepropertyMock = mock(PropertyDto.class);

        PropertyDto actual = propertyService.updateProperty(-8193L, updatepropertyMock);

        assertNull(actual);
    }
    ///endregion

    ///region OTHER: ERROR SUITE for method updateProperty(long, com.stayhere.app.model.PropertyDto)

    @Test
    public void testUpdateProperty1() throws Exception {
        Object object = createInstance("java.lang.Object");
        Optional optional = of(object);
        (when(propertyRepositoryMock.findById(any()))).thenReturn(optional);
        
        /* This test fails because method [com.stayhere.app.service.PropertyService.updateProperty] produces [java.lang.ClassCastException: class java.lang.Object cannot be cast to class com.stayhere.app.model.PropertyDto (java.lang.Object is in module java.base of loader 'bootstrap'; com.stayhere.app.model.PropertyDto is in unnamed module of loader org.utbot.instrumentation.process.HandlerClassesLoader @467d16d9)]
            java.base/java.util.Optional.map(Optional.java:260)
            com.stayhere.app.service.PropertyService.updateProperty(PropertyService.java:61) */
        propertyService.updateProperty(0L, null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.service.PropertyService.getPropertiesById

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method getPropertiesById(long)

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#getPropertiesById(long)}
     * @utbot.throwsException {@link NullPointerException} in: return userRepo.findById(id).map(user -> {
     * List<PropertyDto> properties = propertyRepo.findByUserUserid(id);
     * log.info("Fetched all property details successfully.");
     * return properties;
     * }).orElseThrow(() -> new CustomException("No Properties Found", "No properties found for the given User ID or the User ID is invalid"));
     */
    @Test
    @DisplayName("getPropertiesById: return userRepo.findById(id).map(user -> { List<PropertyDto> properties = propertyRepo.findByUserUserid(id) log.info(\"Fetched all property details successfully.\") return properties }).orElseThrow(() -> new CustomException(\"No Properties Found\", \"No properties found for the given User ID or the User ID is invalid\")) : True -> ThrowNullPointerException")
    public void testGetPropertiesById_ThrowNullPointerException() {
        (when(userRepositoryMock.findById(any()))).thenReturn(((Optional) null));
        
        /* This test fails because method [com.stayhere.app.service.PropertyService.getPropertiesById] produces [java.lang.NullPointerException]
            com.stayhere.app.service.PropertyService.getPropertiesById(PropertyService.java:89) */
        propertyService.getPropertiesById(-255L);
    }
    ///endregion

    ///region FUZZER: SUCCESSFUL EXECUTIONS for method getPropertiesById(long)

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#getPropertiesById(long)}
     */
    @Test
    @DisplayName("getPropertiesById: id = -4194305 (mutated from -1) -> return null")
    public void testGetPropertiesById() throws Throwable {
        Optional optionalMock = mock(Optional.class);
        Optional optionalMock1 = mock(Optional.class);
        (when(optionalMock1.orElseThrow(any()))).thenReturn(null);
        (when(optionalMock.map(any()))).thenReturn(optionalMock1);
        (when(userRepositoryMock.findById(any()))).thenReturn(optionalMock);

        List actual = propertyService.getPropertiesById(-4194305L);

        assertNull(actual);
    }
    ///endregion

    ///region OTHER: ERROR SUITE for method getPropertiesById(long)

    @Test
    public void testGetPropertiesById1() throws Exception {
        Object object = createInstance("java.lang.Object");
        Optional optional = of(object);
        (when(userRepositoryMock.findById(any()))).thenReturn(optional);
        
        /* This test fails because method [com.stayhere.app.service.PropertyService.getPropertiesById] produces [java.lang.ClassCastException: class java.lang.Object cannot be cast to class com.stayhere.app.model.UserDto (java.lang.Object is in module java.base of loader 'bootstrap'; com.stayhere.app.model.UserDto is in unnamed module of loader org.utbot.instrumentation.process.HandlerClassesLoader @467d16d9)]
            java.base/java.util.Optional.map(Optional.java:260)
            com.stayhere.app.service.PropertyService.getPropertiesById(PropertyService.java:89) */
        propertyService.getPropertiesById(0L);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.service.PropertyService.getPropertiesForSale

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method getPropertiesForSale()

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#getPropertiesForSale()}
     * @utbot.invokes {@link List#isEmpty()}
     * @utbot.throwsException {@link NullPointerException} when: properties.isEmpty()
     */
    @Test
    @DisplayName("getPropertiesForSale: properties.isEmpty() -> ThrowNullPointerException")
    public void testGetPropertiesForSale_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyServiceClazz = Class.forName("com.stayhere.app.service.PropertyService");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyServiceClazz, "log"));
            try {
                Logger logMock = mock(Logger.class);
                (((Logger) (doNothing()).when(logMock))).info(((String) any(String.class)));
                setStaticField(propertyServiceClazz, "log", logMock);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(logMock);
                (when(propertyRepositoryMock.getPropertiesByPropertyIsFor(any()))).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.service.PropertyService.getPropertiesForSale] produces [java.lang.NullPointerException] */
                propertyService.getPropertiesForSale();
            } finally {
                setStaticField(PropertyService.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#getPropertiesForSale()}
     * @utbot.throwsException {@link NullPointerException} in: log.info("Fetched all property details successfully.");
     */
    @Test
    @DisplayName("getPropertiesForSale: log.info(\"Fetched all property details successfully.\") : True -> ThrowNullPointerException")
    public void testGetPropertiesForSale_ThrowNullPointerException_1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyServiceClazz = Class.forName("com.stayhere.app.service.PropertyService");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyServiceClazz, "log"));
            try {
                setStaticField(propertyServiceClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(propertyRepositoryMock.getPropertiesByPropertyIsFor(any()))).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.service.PropertyService.getPropertiesForSale] produces [java.lang.NullPointerException] */
                propertyService.getPropertiesForSale();
            } finally {
                setStaticField(PropertyService.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region Errors report for getPropertiesForSale

    public void testGetPropertiesForSale_errors() {
        // Couldn't generate some tests. List of errors:
        // 
        // 1 occurrences of:
        // org.mockito.codegen.List$MockitoMock$LRlCHFZV

    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.service.PropertyService.getPropertiesForRentOrLease

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method getPropertiesForRentOrLease()

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#getPropertiesForRentOrLease()}
     * @utbot.invokes {@link List#isEmpty()}
     * @utbot.throwsException {@link NullPointerException} when: properties.isEmpty()
     */
    @Test
    @DisplayName("getPropertiesForRentOrLease: properties.isEmpty() -> ThrowNullPointerException")
    public void testGetPropertiesForRentOrLease_ThrowNullPointerException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyServiceClazz = Class.forName("com.stayhere.app.service.PropertyService");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyServiceClazz, "log"));
            try {
                Logger logMock = mock(Logger.class);
                (((Logger) (doNothing()).when(logMock))).info(((String) any(String.class)));
                setStaticField(propertyServiceClazz, "log", logMock);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(logMock);
                (when(propertyRepositoryMock.getPropertiesFor(any()))).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.service.PropertyService.getPropertiesForRentOrLease] produces [java.lang.NullPointerException] */
                propertyService.getPropertiesForRentOrLease();
            } finally {
                setStaticField(PropertyService.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }

    /**
     * @utbot.classUnderTest {@link PropertyService}
     * @utbot.methodUnderTest {@link PropertyService#getPropertiesForRentOrLease()}
     * @utbot.throwsException {@link NullPointerException} in: log.info("Fetched all property details successfully.");
     */
    @Test
    @DisplayName("getPropertiesForRentOrLease: log.info(\"Fetched all property details successfully.\") : True -> ThrowNullPointerException")
    public void testGetPropertiesForRentOrLease_ThrowNullPointerException_1() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        MockedStatic mockedStatic = null;
        try {
            Class propertyServiceClazz = Class.forName("com.stayhere.app.service.PropertyService");
            Logger prevLog = ((Logger) getStaticFieldValue(propertyServiceClazz, "log"));
            try {
                setStaticField(propertyServiceClazz, "log", null);
                mockedStatic = mockStatic(LogManager.class);
                (mockedStatic.when(() -> LogManager.getLogger(any(Class.class)))).thenReturn(((Logger) null));
                (when(propertyRepositoryMock.getPropertiesFor(any()))).thenReturn(((List) null));

                /* This test fails because method [com.stayhere.app.service.PropertyService.getPropertiesForRentOrLease] produces [java.lang.NullPointerException] */
                propertyService.getPropertiesForRentOrLease();
            } finally {
                setStaticField(PropertyService.class, "log", prevLog);
            }
        } finally {
            mockedStatic.close();
        }
    }
    ///endregion

    ///region Errors report for getPropertiesForRentOrLease

    public void testGetPropertiesForRentOrLease_errors() {
        // Couldn't generate some tests. List of errors:
        // 
        // 1 occurrences of:
        // org.mockito.codegen.List$MockitoMock$LRlCHFZV

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
