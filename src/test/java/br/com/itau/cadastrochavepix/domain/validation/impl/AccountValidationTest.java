package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.app.model.enums.AccountType;
import br.com.itau.cadastrochavepix.domain.entity.Account;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountValidationTest {
    public static final int AGENCY = 1234;
    public static final int NUMBER = 12345678;
    public static final int INVALID_AGENCY = 12345;
    public static final int INVALID_NUMBER = 123456789;

    @Test
    @DisplayName("Should return true when given valid account")
    void shouldReturnTrueWhenGivenValidAccout() {
        var validAccountPoupanca = createAccount(AccountType.POUPANCA.name(), NUMBER, AGENCY, "Joao", "Silva");
    }

    @Test
    @Disabled
    void shouldReturnFalseWhenGivenInvalidAccout() {
        var invalidAgencyNumber = createAccount(AccountType.CORRENTE.name(), NUMBER, INVALID_AGENCY, "Joao", "Silva");
        var invalidAccountNumber = createAccount(AccountType.CORRENTE.name(), INVALID_NUMBER, AGENCY, "Joao", "Silva");
    }

    private Account createAccount(String accountType, Integer number, Integer agency, String holderName, String holderLastName) {
        return new Account(accountType, number, agency, holderName, holderLastName);
    }

}