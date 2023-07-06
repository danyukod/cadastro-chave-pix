package br.com.itau.cadastrochavepix.domain;

import br.com.itau.cadastrochavepix.domain.enums.AccountType;
import lombok.Getter;

@Getter
public class Account {

    AccountType accountType;

    Integer number;

    Integer agency;

    Holder holder;

    public Account(AccountType accountType, Integer number, Integer agency, Holder holder) {
        this.accountType = accountType;
        this.number = number;
        this.agency = agency;
        this.holder = holder;
        validate();
    }

    private void validate() {
        if (!validateAccountNumber(this.number))
            throw new IllegalArgumentException("Número da conta inválido");
        if (!validateAgencyNumber(this.agency))
            throw new IllegalArgumentException("Número da agência inválido");
    }

    private boolean validateAgencyNumber(Integer agencyNumber) {
        if (agencyNumber < 0 || agencyNumber > 9999)
            return false;
        else
            return true;
    }

    private boolean validateAccountNumber(Integer accountNumber) {
        if (accountNumber < 0 || accountNumber > 99999999)
            return false;
        else
            return true;
    }


}
