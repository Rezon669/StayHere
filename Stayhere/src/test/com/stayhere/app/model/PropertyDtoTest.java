package com.stayhere.app.model;

import com.stayhere.app.model.PropertyDto.BHK;
import com.stayhere.app.model.PropertyDto.PropertyIsFor;
import com.stayhere.app.model.PropertyDto.PropertyType;
import com.stayhere.app.model.PropertyDto.YesNoNA;
import com.stayhere.app.model.UserDto.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.utbot.runtime.utils.java.UtUtils.getFieldValue;

public final class PropertyDtoTest {
    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setMaintenanceCharges

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setMaintenanceCharges(com.stayhere.app.model.PropertyDto$YesNoNA)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setMaintenanceCharges(YesNoNA)}
     */
    @Test
    @DisplayName("setMaintenanceCharges: ")
    public void testSetMaintenanceCharges() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        PropertyDto propertyDto = new PropertyDto();
        YesNoNA maintenanceCharges = YesNoNA.NO;
        propertyDto.setMaintenanceCharges(maintenanceCharges);

        propertyDto.setMaintenanceCharges(null);

        YesNoNA finalPropertyDtoMaintenanceCharges = ((YesNoNA) getFieldValue(propertyDto, "com.stayhere.app.model.PropertyDto", "maintenanceCharges"));

        assertNull(finalPropertyDtoMaintenanceCharges);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setNormalWater

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setNormalWater(com.stayhere.app.model.PropertyDto$YesNoNA)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setNormalWater(YesNoNA)}
     */
    @Test
    @DisplayName("setNormalWater: ")
    public void testSetNormalWater() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        PropertyDto propertyDto = new PropertyDto();
        YesNoNA normalWater = YesNoNA.NO;
        propertyDto.setNormalWater(normalWater);

        propertyDto.setNormalWater(null);

        YesNoNA finalPropertyDtoNormalWater = ((YesNoNA) getFieldValue(propertyDto, "com.stayhere.app.model.PropertyDto", "normalWater"));

        assertNull(finalPropertyDtoNormalWater);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setDrinkingWater

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setDrinkingWater(com.stayhere.app.model.PropertyDto$YesNoNA)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setDrinkingWater(YesNoNA)}
     */
    @Test
    @DisplayName("setDrinkingWater: ")
    public void testSetDrinkingWater() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        PropertyDto propertyDto = new PropertyDto();
        YesNoNA drinkingWater = YesNoNA.NO;
        propertyDto.setDrinkingWater(drinkingWater);

        propertyDto.setDrinkingWater(null);

        YesNoNA finalPropertyDtoDrinkingWater = ((YesNoNA) getFieldValue(propertyDto, "com.stayhere.app.model.PropertyDto", "drinkingWater"));

        assertNull(finalPropertyDtoDrinkingWater);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setPropertyIsFor

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setPropertyIsFor(com.stayhere.app.model.PropertyDto$PropertyIsFor)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setPropertyIsFor(PropertyIsFor)}
     */
    @Test
    @DisplayName("setPropertyIsFor: ")
    public void testSetPropertyIsFor() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        PropertyDto propertyDto = new PropertyDto();
        PropertyIsFor propertyIsFor = PropertyIsFor.SALE;
        propertyDto.setPropertyIsFor(propertyIsFor);

        propertyDto.setPropertyIsFor(null);

        PropertyIsFor finalPropertyDtoPropertyIsFor = ((PropertyIsFor) getFieldValue(propertyDto, "com.stayhere.app.model.PropertyDto", "propertyIsFor"));

        assertNull(finalPropertyDtoPropertyIsFor);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setBhk

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setBhk(com.stayhere.app.model.PropertyDto$BHK)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setBhk(BHK)}
     */
    @Test
    @DisplayName("setBhk: ")
    public void testSetBhk() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        PropertyDto propertyDto = new PropertyDto();
        BHK bhk = BHK.FOUR_BHK;
        propertyDto.setBhk(bhk);

        propertyDto.setBhk(null);

        BHK finalPropertyDtoBhk = ((BHK) getFieldValue(propertyDto, "com.stayhere.app.model.PropertyDto", "bhk"));

        assertNull(finalPropertyDtoBhk);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setElectricity

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setElectricity(com.stayhere.app.model.PropertyDto$YesNoNA)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setElectricity(YesNoNA)}
     */
    @Test
    @DisplayName("setElectricity: ")
    public void testSetElectricity() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        PropertyDto propertyDto = new PropertyDto();
        YesNoNA electricity = YesNoNA.NO;
        propertyDto.setElectricity(electricity);

        propertyDto.setElectricity(null);

        YesNoNA finalPropertyDtoElectricity = ((YesNoNA) getFieldValue(propertyDto, "com.stayhere.app.model.PropertyDto", "electricity"));

        assertNull(finalPropertyDtoElectricity);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setParking

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setParking(com.stayhere.app.model.PropertyDto$YesNoNA)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setParking(YesNoNA)}
     */
    @Test
    @DisplayName("setParking: ")
    public void testSetParking() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        PropertyDto propertyDto = new PropertyDto();
        YesNoNA parking = YesNoNA.NO;
        propertyDto.setParking(parking);

        propertyDto.setParking(null);

        YesNoNA finalPropertyDtoParking = ((YesNoNA) getFieldValue(propertyDto, "com.stayhere.app.model.PropertyDto", "parking"));

        assertNull(finalPropertyDtoParking);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setPropertyType

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setPropertyType(com.stayhere.app.model.PropertyDto$PropertyType)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setPropertyType(PropertyType)}
     */
    @Test
    @DisplayName("setPropertyType: ")
    public void testSetPropertyType() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        PropertyDto propertyDto = new PropertyDto();
        PropertyType propertyType = PropertyType.APARTMENT;
        propertyDto.setPropertyType(propertyType);

        propertyDto.setPropertyType(null);

        PropertyType finalPropertyDtoPropertyType = ((PropertyType) getFieldValue(propertyDto, "com.stayhere.app.model.PropertyDto", "propertyType"));

        assertNull(finalPropertyDtoPropertyType);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getPropertyId

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getPropertyId()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getPropertyId()}
     * @utbot.returnsFrom {@code return propertyId;}
     */
    @Test
    @DisplayName("getPropertyId: -> return propertyId")
    public void testGetPropertyId_ReturnPropertyId() {
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setPropertyId(-255L);

        long actual = propertyDto.getPropertyId();

        assertEquals(-255L, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setPropertyId

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setPropertyId(long)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setPropertyId(long)}
     */
    @Test
    @DisplayName("setPropertyId: ")
    public void testSetPropertyId() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setPropertyId(1L);

        propertyDto.setPropertyId(-255L);

        long finalPropertyDtoPropertyId = ((Long) getFieldValue(propertyDto, "com.stayhere.app.model.PropertyDto", "propertyId"));

        assertEquals(-255L, finalPropertyDtoPropertyId);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getUser

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getUser()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getUser()}
     * @utbot.returnsFrom {@code return user;}
     */
    @Test
    @DisplayName("getUser: -> return user")
    public void testGetUser_ReturnUser() {
        PropertyDto propertyDto = new PropertyDto();
        UserDto user = new UserDto();
        propertyDto.setUser(user);

        UserDto actual = propertyDto.getUser();

        long userUserid = user.getUserid();
        long actualUserid = actual.getUserid();
        assertEquals(userUserid, actualUserid);

        String actualUsername = actual.getUsername();
        assertNull(actualUsername);

        String actualFirstname = actual.getFirstname();
        assertNull(actualFirstname);

        String actualLastname = actual.getLastname();
        assertNull(actualLastname);

        String actualEmail = actual.getEmail();
        assertNull(actualEmail);

        String actualPhonenumber = actual.getPhonenumber();
        assertNull(actualPhonenumber);

        String actualPassword = actual.getPassword();
        assertNull(actualPassword);

        Role userRole = user.getRole();
        Role actualRole = actual.getRole();
        assertEquals(userRole, actualRole);

    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setUser

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setUser(com.stayhere.app.model.UserDto)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setUser(UserDto)}
     */
    @Test
    @DisplayName("setUser: ")
    public void testSetUser() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        PropertyDto propertyDto = new PropertyDto();
        UserDto user = new UserDto();
        propertyDto.setUser(user);

        propertyDto.setUser(null);

        UserDto finalPropertyDtoUser = ((UserDto) getFieldValue(propertyDto, "com.stayhere.app.model.PropertyDto", "user"));

        assertNull(finalPropertyDtoUser);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getPropertyType

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getPropertyType()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getPropertyType()}
     * @utbot.returnsFrom {@code return propertyType;}
     */
    @Test
    @DisplayName("getPropertyType: -> return propertyType")
    public void testGetPropertyType_ReturnPropertyType() {
        PropertyDto propertyDto = new PropertyDto();
        PropertyType propertyType = PropertyType.APARTMENT;
        propertyDto.setPropertyType(propertyType);

        PropertyType actual = propertyDto.getPropertyType();

        assertEquals(propertyType, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getBhk

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getBhk()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getBhk()}
     * @utbot.returnsFrom {@code return bhk;}
     */
    @Test
    @DisplayName("getBhk: -> return bhk")
    public void testGetBhk_ReturnBhk() {
        PropertyDto propertyDto = new PropertyDto();
        BHK bhk = BHK.ONE_BHK;
        propertyDto.setBhk(bhk);

        BHK actual = propertyDto.getBhk();

        assertEquals(bhk, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getPropertyIsFor

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getPropertyIsFor()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getPropertyIsFor()}
     * @utbot.returnsFrom {@code return propertyIsFor;}
     */
    @Test
    @DisplayName("getPropertyIsFor: -> return propertyIsFor")
    public void testGetPropertyIsFor_ReturnPropertyIsFor() {
        PropertyDto propertyDto = new PropertyDto();
        PropertyIsFor propertyIsFor = PropertyIsFor.RENT;
        propertyDto.setPropertyIsFor(propertyIsFor);

        PropertyIsFor actual = propertyDto.getPropertyIsFor();

        assertEquals(propertyIsFor, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getMaintenanceCharges

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getMaintenanceCharges()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getMaintenanceCharges()}
     * @utbot.returnsFrom {@code return maintenanceCharges;}
     */
    @Test
    @DisplayName("getMaintenanceCharges: -> return maintenanceCharges")
    public void testGetMaintenanceCharges_ReturnMaintenanceCharges() {
        PropertyDto propertyDto = new PropertyDto();
        YesNoNA maintenanceCharges = YesNoNA.YES;
        propertyDto.setMaintenanceCharges(maintenanceCharges);

        YesNoNA actual = propertyDto.getMaintenanceCharges();

        assertEquals(maintenanceCharges, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getRentAmount

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getRentAmount()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getRentAmount()}
     * @utbot.returnsFrom {@code return rentAmount;}
     */
    @Test
    @DisplayName("getRentAmount: LongValueOf -> return rentAmount")
    public void testGetRentAmount_LongValueOf() {
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setRentAmount(-255L);

        Long actual = propertyDto.getRentAmount();

        Long expected = -255L;

        assertEquals(expected, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setRentAmount

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setRentAmount(java.lang.Long)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setRentAmount(Long)}
     * @utbot.invokes {@link Long#longValue()}
     */
    @Test
    @DisplayName("setRentAmount: -> LongLongValue")
    public void testSetRentAmount_LongLongValue() {
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setRentAmount(-255L);
        Long rentAmount = -255L;

        propertyDto.setRentAmount(rentAmount);
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method setRentAmount(java.lang.Long)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setRentAmount(Long)}
     * @utbot.invokes {@link Long#longValue()}
     * @utbot.throwsException {@link NullPointerException} in: this.rentAmount = rentAmount;
     */
    @Test
    @DisplayName("setRentAmount: this.rentAmount = rentAmount -> ThrowNullPointerException")
    public void testSetRentAmount_ThrowNullPointerException() {
        PropertyDto propertyDto = new PropertyDto();
        
        /* This test fails because method [com.stayhere.app.model.PropertyDto.setRentAmount] produces [java.lang.NullPointerException]
            com.stayhere.app.model.PropertyDto.setRentAmount(PropertyDto.java:151) */
        propertyDto.setRentAmount(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getDoorNo

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getDoorNo()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getDoorNo()}
     * @utbot.returnsFrom {@code return doorNo;}
     */
    @Test
    @DisplayName("getDoorNo: -> return doorNo")
    public void testGetDoorNo_ReturnDoorNo() {
        PropertyDto propertyDto = new PropertyDto();
        String doorNo = "";
        propertyDto.setDoorNo(doorNo);

        String actual = propertyDto.getDoorNo();

        assertEquals(doorNo, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setDoorNo

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setDoorNo(java.lang.String)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setDoorNo(String)}
     */
    @Test
    @DisplayName("setDoorNo: ")
    public void testSetDoorNo() {
        PropertyDto propertyDto = new PropertyDto();
        String doorNo = "";
        propertyDto.setDoorNo(doorNo);

        propertyDto.setDoorNo(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getArea

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getArea()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getArea()}
     * @utbot.returnsFrom {@code return area;}
     */
    @Test
    @DisplayName("getArea: -> return area")
    public void testGetArea_ReturnArea() {
        PropertyDto propertyDto = new PropertyDto();
        String area = "";
        propertyDto.setArea(area);

        String actual = propertyDto.getArea();

        assertEquals(area, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setArea

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setArea(java.lang.String)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setArea(String)}
     */
    @Test
    @DisplayName("setArea: ")
    public void testSetArea() {
        PropertyDto propertyDto = new PropertyDto();
        String area = "";
        propertyDto.setArea(area);

        propertyDto.setArea(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getCity

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getCity()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getCity()}
     * @utbot.returnsFrom {@code return city;}
     */
    @Test
    @DisplayName("getCity: -> return city")
    public void testGetCity_ReturnCity() {
        PropertyDto propertyDto = new PropertyDto();
        String city = "";
        propertyDto.setCity(city);

        String actual = propertyDto.getCity();

        assertEquals(city, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setCity

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setCity(java.lang.String)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setCity(String)}
     */
    @Test
    @DisplayName("setCity: ")
    public void testSetCity() {
        PropertyDto propertyDto = new PropertyDto();
        String city = "";
        propertyDto.setCity(city);

        propertyDto.setCity(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getState

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getState()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getState()}
     * @utbot.returnsFrom {@code return state;}
     */
    @Test
    @DisplayName("getState: -> return state")
    public void testGetState_ReturnState() {
        PropertyDto propertyDto = new PropertyDto();
        String state = "";
        propertyDto.setState(state);

        String actual = propertyDto.getState();

        assertEquals(state, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setState

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setState(java.lang.String)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setState(String)}
     */
    @Test
    @DisplayName("setState: ")
    public void testSetState() {
        PropertyDto propertyDto = new PropertyDto();
        String state = "";
        propertyDto.setState(state);

        propertyDto.setState(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getCountry

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getCountry()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getCountry()}
     * @utbot.returnsFrom {@code return country;}
     */
    @Test
    @DisplayName("getCountry: -> return country")
    public void testGetCountry_ReturnCountry() {
        PropertyDto propertyDto = new PropertyDto();
        String country = "";
        propertyDto.setCountry(country);

        String actual = propertyDto.getCountry();

        assertEquals(country, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setCountry

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setCountry(java.lang.String)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setCountry(String)}
     */
    @Test
    @DisplayName("setCountry: ")
    public void testSetCountry() {
        PropertyDto propertyDto = new PropertyDto();
        String country = "";
        propertyDto.setCountry(country);

        propertyDto.setCountry(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getPincode

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getPincode()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getPincode()}
     * @utbot.returnsFrom {@code return pincode;}
     */
    @Test
    @DisplayName("getPincode: -> return pincode")
    public void testGetPincode_ReturnPincode() {
        PropertyDto propertyDto = new PropertyDto();
        String pincode = "";
        propertyDto.setPincode(pincode);

        String actual = propertyDto.getPincode();

        assertEquals(pincode, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.setPincode

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method setPincode(java.lang.String)

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#setPincode(String)}
     */
    @Test
    @DisplayName("setPincode: ")
    public void testSetPincode() {
        PropertyDto propertyDto = new PropertyDto();
        String pincode = "";
        propertyDto.setPincode(pincode);

        propertyDto.setPincode(null);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getDrinkingWater

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getDrinkingWater()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getDrinkingWater()}
     * @utbot.returnsFrom {@code return drinkingWater;}
     */
    @Test
    @DisplayName("getDrinkingWater: -> return drinkingWater")
    public void testGetDrinkingWater_ReturnDrinkingWater() {
        PropertyDto propertyDto = new PropertyDto();
        YesNoNA drinkingWater = YesNoNA.YES;
        propertyDto.setDrinkingWater(drinkingWater);

        YesNoNA actual = propertyDto.getDrinkingWater();

        assertEquals(drinkingWater, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getNormalWater

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getNormalWater()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getNormalWater()}
     * @utbot.returnsFrom {@code return normalWater;}
     */
    @Test
    @DisplayName("getNormalWater: -> return normalWater")
    public void testGetNormalWater_ReturnNormalWater() {
        PropertyDto propertyDto = new PropertyDto();
        YesNoNA normalWater = YesNoNA.YES;
        propertyDto.setNormalWater(normalWater);

        YesNoNA actual = propertyDto.getNormalWater();

        assertEquals(normalWater, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getParking

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getParking()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getParking()}
     * @utbot.returnsFrom {@code return parking;}
     */
    @Test
    @DisplayName("getParking: -> return parking")
    public void testGetParking_ReturnParking() {
        PropertyDto propertyDto = new PropertyDto();
        YesNoNA parking = YesNoNA.YES;
        propertyDto.setParking(parking);

        YesNoNA actual = propertyDto.getParking();

        assertEquals(parking, actual);
    }
    ///endregion

    ///endregion

    ///region Test suites for executable com.stayhere.app.model.PropertyDto.getElectricity

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method getElectricity()

    /**
     * @utbot.classUnderTest {@link PropertyDto}
     * @utbot.methodUnderTest {@link PropertyDto#getElectricity()}
     * @utbot.returnsFrom {@code return electricity;}
     */
    @Test
    @DisplayName("getElectricity: -> return electricity")
    public void testGetElectricity_ReturnElectricity() {
        PropertyDto propertyDto = new PropertyDto();
        YesNoNA electricity = YesNoNA.YES;
        propertyDto.setElectricity(electricity);

        YesNoNA actual = propertyDto.getElectricity();

        assertEquals(electricity, actual);
    }
    ///endregion

    ///endregion
}
