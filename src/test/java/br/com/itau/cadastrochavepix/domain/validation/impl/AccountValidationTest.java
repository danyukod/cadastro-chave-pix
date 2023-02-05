package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.model.enums.AccountType;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountValidationTest {
    public static final int AGENCY_NUMBER = 1234;
    public static final int ACCOUNT_NUMBER = 12345678;
    public static final int INVALID_AGENCY_NUMBER = 12345;
    public static final int INVALID_ACCOUNT_NUMBER = 123456789;
    private AccountValidation accountValidation;


    @BeforeEach
    void setUp() {
        accountValidation = new AccountValidation();
    }

    @Test
    @DisplayName("Should return true when given valid account")
    void shouldReturnTrueWhenGivenValidAccout() {
        var pixKeyRequestWithValidAccountCorrente = createPixKeyRequest(AccountType.CORRENTE, AGENCY_NUMBER, ACCOUNT_NUMBER);
        var pixKeyRequestWithValidAccountPoupanca = createPixKeyRequest(AccountType.POUPANCA, AGENCY_NUMBER, ACCOUNT_NUMBER);

        assertTrue(accountValidation.accountValidate(pixKeyRequestWithValidAccountCorrente));
        assertTrue(accountValidation.accountValidate(pixKeyRequestWithValidAccountPoupanca));
    }

    @Test
    void shouldReturnFalseWhenGivenInvalidAccout() {
        var pixKeyRequestWithInvalidAccountType = createPixKeyRequest(null, AGENCY_NUMBER, ACCOUNT_NUMBER);
        var pixKeyRequestWithInvalidAgencyNumber = createPixKeyRequest(AccountType.CORRENTE, INVALID_AGENCY_NUMBER, ACCOUNT_NUMBER);
        var pixKeyRequestWithInvalidAccountNumber = createPixKeyRequest(AccountType.CORRENTE, AGENCY_NUMBER, INVALID_ACCOUNT_NUMBER);

        assertFalse(accountValidation.accountValidate(pixKeyRequestWithInvalidAccountType));
        assertFalse(accountValidation.accountValidate(pixKeyRequestWithInvalidAgencyNumber));
        assertFalse(accountValidation.accountValidate(pixKeyRequestWithInvalidAccountNumber));
    }

    private PixKeyRequest createPixKeyRequest(AccountType accountType, Integer agencyNumber, Integer accountNumber) {
        return new PixKeyRegisterRequest(
                null, null, accountType, agencyNumber,
                accountNumber, null, null);
    }

}