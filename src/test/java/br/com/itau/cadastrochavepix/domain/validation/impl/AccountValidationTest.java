package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountValidationTest {

    private AccountValidation accountValidation;


    @BeforeEach
    void setUp() {
        accountValidation = new AccountValidation();
    }

    @Test
    @DisplayName("Should return true when given valid account")
    void shouldReturnTrueWhenGivenValidAccout() {
        PixKeyRequest pixKeyRequestWithValidAccount = createPixKeyRequest("CORRENTE",
                1234, 12345678);

        assertTrue(accountValidation.accountValidate(pixKeyRequestWithValidAccount));
    }

    @Test
    void shouldReturnFalseWhenGivenInvalidAccout() {
        PixKeyRequest pixKeyRequestWithInvalidAccountType = createPixKeyRequest("TESTE",
                1234, 12345678);
        PixKeyRequest pixKeyRequestWithInvalidAgencyNumber = createPixKeyRequest("CORRENTE",
                12345, 12345678);
        PixKeyRequest pixKeyRequestWithInvalidAccountNumber = createPixKeyRequest("CORRENTE",
                1234, 123456789);

        assertFalse(accountValidation.accountValidate(pixKeyRequestWithInvalidAccountType));
        assertFalse(accountValidation.accountValidate(pixKeyRequestWithInvalidAgencyNumber));
        assertFalse(accountValidation.accountValidate(pixKeyRequestWithInvalidAccountNumber));
    }

    private PixKeyRequest createPixKeyRequest(String accountType, Integer agencyNumber, Integer accountNumber) {
        return new PixKeyRegisterRequest(
                null, null, accountType, agencyNumber,
                accountNumber, null, null);
    }

}