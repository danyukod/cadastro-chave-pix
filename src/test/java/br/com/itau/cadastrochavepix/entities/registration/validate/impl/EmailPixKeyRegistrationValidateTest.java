package br.com.itau.cadastrochavepix.entities.registration.validate.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailPixKeyRegistrationValidateTest {

    EmailPixKeyRegistrationValidate emailPixKeyRegistrationValidate;

    @BeforeEach
    void setUp() {
        emailPixKeyRegistrationValidate = new EmailPixKeyRegistrationValidate();
    }

    @Test
    void givenEmailPixKey_whenFormatValidate_thenTrue() {
        String email = "danilo@test.com";

        assertTrue(emailPixKeyRegistrationValidate.formatValidate(email));
    }

}