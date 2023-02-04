package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountValidationTest {

    private AccountValidation accountValidation;


    @BeforeEach
    void setUp() {
        accountValidation = new AccountValidation();
    }

    @Test
    void shouldReturnTrueWhenGivenValidAccout() {
        PixKeyRequest pixKeyRequestWithValidAccount = createPixKeyRequest("CORRENTE",
                1234, 12345678);

        assertTrue(accountValidation.accountValidate(pixKeyRequestWithValidAccount));
    }

    private PixKeyRequest createPixKeyRequest(String accountType, Integer agencyNumber, Integer accountNumber) {
        return new PixKeyRegisterRequest(
                null, null, accountType, agencyNumber,
                accountNumber, null, null);
    }

}