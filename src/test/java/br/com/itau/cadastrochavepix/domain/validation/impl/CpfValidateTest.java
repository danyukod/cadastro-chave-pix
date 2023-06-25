package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.domain.entity.validation.impl.CpfValidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CpfValidateTest {

    CpfValidate cpfPixKeyRegistrationValidate;

    @BeforeEach
    void setUp() {
        cpfPixKeyRegistrationValidate = new CpfValidate();
    }

    @Test
    @DisplayName("Given a valid cpf then should return true")
    void givenAValidCpfThenShouldReturnTrue() {
        var cpf = "39357160876";

        assertTrue(cpfPixKeyRegistrationValidate.pixKeyValidate(cpf));
    }

    @Test
    @DisplayName("Given a invalid cpf then should return false")
    void givenAInvalidCpfThenShouldReturnFalse() {
        var invalidCpfNumver = "12345678910";
        var cpfWithMoreThanElevenDigits = "1234567891011";


        assertFalse(cpfPixKeyRegistrationValidate.pixKeyValidate(invalidCpfNumver));
        assertFalse(cpfPixKeyRegistrationValidate.pixKeyValidate(cpfWithMoreThanElevenDigits));
    }

}