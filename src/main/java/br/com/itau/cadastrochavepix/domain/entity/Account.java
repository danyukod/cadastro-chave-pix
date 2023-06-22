package br.com.itau.cadastrochavepix.domain.entity;

import br.com.itau.cadastrochavepix.adapters.input.web.model.enums.AccountType;
import lombok.Getter;

@Getter
public class Account {

    AccountType accountType;

    Integer number;

    Integer agency;

    String holderName;

    String holderLastName;

    public Account(String accountType, Integer number, Integer agency, String holderName, String holderLastName) {
        this.accountType = accountType(accountType);
        this.number = number(number);
        this.agency = agency(agency);
        this.holderName = holderName;
        this.holderLastName = holderLastName;
    }

    private AccountType accountType(String accountType) {
        if (validateAccountType(accountType))
            return AccountType.valueOf(accountType);
        else
            throw new IllegalArgumentException("Tipo de conta inválido");
    }

    private Integer number(Integer number) {
        if (validateAccountNumber(number))
            return number;
        else
            throw new IllegalArgumentException("Número da conta inválido");
    }

    private Integer agency(Integer agency) {
        if (validateAgencyNumber(agency))
            return agency;
        else
            throw new IllegalArgumentException("Número da agência inválido");
    }

    private String holderName(String holderName) {
        if (validateHolderName(holderName))
            return holderName;
        else
            throw new IllegalArgumentException("Nome do titular inválido");
    }

    private boolean validateAccountType(String accountType) {
        if (accountType.equals(AccountType.CORRENTE.name()) || accountType.equals(AccountType.POUPANCA.name()))
            return true;
        else
            return false;
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

    private boolean validateHolderName(String holderName) {
        if (holderName.length() < 3 || holderName.length() > 50)
            return false;
        else
            return true;
    }

}
