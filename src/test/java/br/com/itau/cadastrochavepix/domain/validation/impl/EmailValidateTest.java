package br.com.itau.cadastrochavepix.domain.validation.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailValidateTest {

    EmailValidate emailPixKeyRegistrationValidate;

    @BeforeEach
    void setUp() {
        emailPixKeyRegistrationValidate = new EmailValidate();
    }

    @Test
    @DisplayName("Given a valid email then should return true")
    void givenAValidEmailThenShouldReturnTrue() {
        var email = "danilo@test.com";
        var emailWithLength77 = "danilotesteeeeeeeeeeeeeeeeeeeeeeee" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee@teste.com";


        assertTrue(emailPixKeyRegistrationValidate.pixKeyValidate(email));
        assertTrue(emailPixKeyRegistrationValidate.pixKeyValidate(emailWithLength77));
    }

    @Test
    @DisplayName("Given a invalid email then should return false")
    void givenAInvalidEmailThenShouldReturnTrue() {
        var emailWithoutAtSign = "danilotest";
        var emailWithLengthHigherThan77 =
                "danilotesteeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                        "eeeeeeeeeeeeeeeeeeeeeeeeeeee@teste.com";

        assertFalse(emailPixKeyRegistrationValidate.pixKeyValidate(emailWithoutAtSign));
        assertFalse(emailPixKeyRegistrationValidate.pixKeyValidate(emailWithLengthHigherThan77));
    }

}