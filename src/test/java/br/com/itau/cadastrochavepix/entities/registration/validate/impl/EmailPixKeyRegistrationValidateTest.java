package br.com.itau.cadastrochavepix.entities.registration.validate.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailPixKeyRegistrationValidateTest {

    EmailPixKeyRegistrationValidate emailPixKeyRegistrationValidate;

    @BeforeEach
    void setUp() {
        emailPixKeyRegistrationValidate = new EmailPixKeyRegistrationValidate();
    }

    @Test
    void givenAValidEmailThenShouldReturnTrue() {
        var email = "danilo@test.com";
        var emailWithLength77 = "danilotesteeeeeeeeeeeeeeeeeeeeeeee" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee@teste.com";


        assertTrue(emailPixKeyRegistrationValidate.formatValidate(email));
        assertTrue(emailPixKeyRegistrationValidate.formatValidate(emailWithLength77));
    }

    @Test
    void givenAInvalidEmailThenShouldReturnTrue() {
        var emailWithoutAtSign = "danilotest";
        var emailWithLengthHigherThan77 =
                "danilotesteeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                        "eeeeeeeeeeeeeeeeeeeeeeeeeeee@teste.com";

        assertFalse(emailPixKeyRegistrationValidate.formatValidate(emailWithoutAtSign));
        assertFalse(emailPixKeyRegistrationValidate.formatValidate(emailWithLengthHigherThan77));
    }

}