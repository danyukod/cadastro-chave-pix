package br.com.itau.cadastrochavepix.entity.registration.validate.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CnpjRegistrationValidateTest {
    CnpjRegistrationValidate cnpjRegistrationValidate;

    @BeforeEach
    void setUp() {
        cnpjRegistrationValidate = new CnpjRegistrationValidate();
    }

    @Test
    @DisplayName("Given a valid cnpj then should return true")
    void givenAValidCnpjThenShouldReturnTrue() {
        var cnpj = "39357160876";

        assertTrue(cnpjRegistrationValidate.formatValidate(cnpj));
    }

    @Test
    @DisplayName("Given a invalid cnpj then should return false")
    void givenAInvalidCnpjThenShouldReturnFalse() {
        var invalidCnpjNumber = "12345678910";
        var cnpjWithMoreThanElevenDigits = "1234567891011";


        assertFalse(cnpjRegistrationValidate.formatValidate(invalidCnpjNumber));
        assertFalse(cnpjRegistrationValidate.formatValidate(cnpjWithMoreThanElevenDigits));
    }
}