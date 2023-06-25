package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.domain.entity.validation.impl.CnpjValidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CnpjValidateTest {
    CnpjValidate cnpjRegistrationValidate;

    @BeforeEach
    void setUp() {
        cnpjRegistrationValidate = new CnpjValidate();
    }

    @Test
    @DisplayName("Given a valid cnpj then should return true")
    void givenAValidCnpjThenShouldReturnTrue() {
        var cnpj = "52323817000102";

        assertTrue(cnpjRegistrationValidate.pixKeyValidate(cnpj));
    }

    @Test
    @DisplayName("Given a invalid cnpj then should return false")
    void givenAInvalidCnpjThenShouldReturnFalse() {
        var invalidCnpjNumber = "12345678910112";
        var cnpjWithMoreThanFourteenDigits = "123456789101112";


        assertFalse(cnpjRegistrationValidate.pixKeyValidate(invalidCnpjNumber));
        assertFalse(cnpjRegistrationValidate.pixKeyValidate(cnpjWithMoreThanFourteenDigits));
    }
}