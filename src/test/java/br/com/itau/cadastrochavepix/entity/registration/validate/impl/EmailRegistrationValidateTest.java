package br.com.itau.cadastrochavepix.entity.registration.validate.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailRegistrationValidateTest {

    EmailRegistrationValidate emailPixKeyRegistrationValidate;

    @BeforeEach
    void setUp() {
        emailPixKeyRegistrationValidate = new EmailRegistrationValidate();
    }

    @Test
    @DisplayName("Given a valid email then should return true")
    void givenAValidEmailThenShouldReturnTrue() {
        var email = "danilo@test.com";
        var emailWithLength77 = "danilotesteeeeeeeeeeeeeeeeeeeeeeee" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee@teste.com";


        assertTrue(emailPixKeyRegistrationValidate.formatValidate(email));
        assertTrue(emailPixKeyRegistrationValidate.formatValidate(emailWithLength77));
    }

    @Test
    @DisplayName("Given a invalid email then should return false")
    void givenAInvalidEmailThenShouldReturnTrue() {
        var emailWithoutAtSign = "danilotest";
        var emailWithLengthHigherThan77 =
                "danilotesteeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                        "eeeeeeeeeeeeeeeeeeeeeeeeeeee@teste.com";

        assertFalse(emailPixKeyRegistrationValidate.formatValidate(emailWithoutAtSign));
        assertFalse(emailPixKeyRegistrationValidate.formatValidate(emailWithLengthHigherThan77));
    }

}