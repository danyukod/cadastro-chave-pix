package br.com.itau.cadastrochavepix.entities.registration.impl;

import br.com.itau.cadastrochavepix.entities.registration.validate.impl.PhonePixKeyRegistrationValidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PhonePixKeyRegistrationTest {

    PhonePixKeyRegistrationValidate phonePixKeyRegistration;

    @BeforeEach
    void setUp(){
        phonePixKeyRegistration = new PhonePixKeyRegistrationValidate();
    }

    @Test
    void givenAValidPhoneNumberShouldReturnTrue() {
        String phoneNumber = "+5515999999999";
        boolean result = phonePixKeyRegistration.formatValidate(phoneNumber);

        assertTrue(result);
    }

    @Test
    void givenAInvalidPhoneNumberShouldReturnFalse() {
        String phoneNumberWithoutPlus = "5515999999999";
        String phoneNumberLessDigits = "+551599999999";
        String phoneNumberHighestDigits = "+55159999999999";
        String phoneNumberWithLetter = "+551599999A999";
        boolean resultWithoutPlus = phonePixKeyRegistration.formatValidate(phoneNumberWithoutPlus);
        boolean resultLessDigits = phonePixKeyRegistration.formatValidate(phoneNumberLessDigits);
        boolean resultHighestDigits = phonePixKeyRegistration.formatValidate(phoneNumberHighestDigits);
        boolean resultWithLetter = phonePixKeyRegistration.formatValidate(phoneNumberWithLetter);

        assertFalse(resultWithoutPlus);
        assertFalse(resultLessDigits);
        assertFalse(resultHighestDigits);
        assertFalse(resultWithLetter);
    }


}