package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.domain.entity.validation.impl.PhoneValidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PhoneValidateTest {

    PhoneValidate phonePixKeyRegistration;

    @BeforeEach
    @DisplayName("Create new instance of PhonePixKeyRegistrationValidate")
    void setUp() {
        phonePixKeyRegistration = new PhoneValidate();
    }

    @Test
    @DisplayName("Given a valid phone number should return true")
    void givenAValidPhoneNumberShouldReturnTrue() {
        var phoneNumberValidateElevenDigits = "+51999999999";
        var phoneNumberValidateTwelveDigits = "+551999999999";
        var phoneNumberValidateThirteenDigits = "+5511999999999";
        var phoneNumberValidateFourteenDigits = "+55111999999999";

        assertTrue(phonePixKeyRegistration.pixKeyValidate(phoneNumberValidateElevenDigits));
        assertTrue(phonePixKeyRegistration.pixKeyValidate(phoneNumberValidateTwelveDigits));
        assertTrue(phonePixKeyRegistration.pixKeyValidate(phoneNumberValidateThirteenDigits));
        assertTrue(phonePixKeyRegistration.pixKeyValidate(phoneNumberValidateFourteenDigits));
    }

    @Test
    @DisplayName("Given a invalid phone number should return false")
    void givenAInvalidPhoneNumberShouldReturnFalse() {
        var phoneNumberWithoutPlus = "5515999999999";
        var phoneNumberLessDigits = "+5515999999";
        var phoneNumberHighestDigits = "+551599999999999";
        var phoneNumberWithLetter = "+5515999AAA999";

        assertFalse(phonePixKeyRegistration.pixKeyValidate(phoneNumberWithoutPlus));
        assertFalse(phonePixKeyRegistration.pixKeyValidate(phoneNumberLessDigits));
        assertFalse(phonePixKeyRegistration.pixKeyValidate(phoneNumberHighestDigits));
        assertFalse(phonePixKeyRegistration.pixKeyValidate(phoneNumberWithLetter));
    }


}