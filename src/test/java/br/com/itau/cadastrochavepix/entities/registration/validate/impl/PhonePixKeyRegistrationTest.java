package br.com.itau.cadastrochavepix.entities.registration.validate.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PhonePixKeyRegistrationTest {

    PhonePixKeyRegistrationValidate phonePixKeyRegistration;

    @BeforeEach
    @DisplayName("Create new instance of PhonePixKeyRegistrationValidate")
    void setUp() {
        phonePixKeyRegistration = new PhonePixKeyRegistrationValidate();
    }

    @Test
    @DisplayName("Given a valid phone number should return true")
    void givenAValidPhoneNumberShouldReturnTrue() {
        var phoneNumber = "+5515999999999";

        assertTrue(phonePixKeyRegistration.formatValidate(phoneNumber));
    }

    @Test
    @DisplayName("Given a invalid phone number should return false")
    void givenAInvalidPhoneNumberShouldReturnFalse() {
        var phoneNumberWithoutPlus = "5515999999999";
        var phoneNumberLessDigits = "+551599999999";
        var phoneNumberHighestDigits = "+55159999999999";
        var phoneNumberWithLetter = "+551599999A999";

        assertFalse(phonePixKeyRegistration.formatValidate(phoneNumberWithoutPlus));
        assertFalse(phonePixKeyRegistration.formatValidate(phoneNumberLessDigits));
        assertFalse(phonePixKeyRegistration.formatValidate(phoneNumberHighestDigits));
        assertFalse(phonePixKeyRegistration.formatValidate(phoneNumberWithLetter));
    }


}