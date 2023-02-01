package br.com.itau.cadastrochavepix.entity.registration.validate.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomRegistrationValidateTest {

    RandomRegistrationValidate randomRegistrationValidate;

    @BeforeEach
    void setUp() {
        randomRegistrationValidate = new RandomRegistrationValidate();
    }

    @Test
    @DisplayName("Given a valid random pix key then should return true")
    void givenAValidRandomPixKeyThenShouldReturnTrue() {
        var random = generateRandomPixKey();

        assertTrue(randomRegistrationValidate.formatValidate(random));
    }

    @Test
    @DisplayName("Given a invalid random pix key then should return false")
    void givenAInvalidRandomPixKeyThenShouldReturnFalse() {
        var randomPixKeyWithMoreThanThirtySixCharacters = generateRandomPixKey() + generateRandomPixKey();
        var randomPixKeyWithLessThanThirtySixCharacters = generateRandomPixKey().substring(0, 29);

        assertFalse(randomRegistrationValidate.formatValidate(randomPixKeyWithMoreThanThirtySixCharacters));
        assertFalse(randomRegistrationValidate.formatValidate(randomPixKeyWithLessThanThirtySixCharacters));
    }

    private String generateRandomPixKey() {
        return UUID.randomUUID().toString().replace("-", randomNumber());
    }

    private CharSequence randomNumber() {
        return String.valueOf(new Random().nextInt(9));
    }

}