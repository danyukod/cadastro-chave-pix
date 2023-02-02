package br.com.itau.cadastrochavepix.domain.validation.impl;

public class AccountValidation {

    public boolean accountValidate(String accountType, Integer agencyNumber, Integer accountNumber) {
        if (accountType == null || agencyNumber == null || accountNumber == null) {
            return false;
        }
        return validateAccountType(accountType) && validateAgencyNumber(agencyNumber) && validateAccountNumber(accountNumber);
    }

    private boolean validateAccountType(String accountType) {
        if (accountType != "CORRENTE" || accountType != "POUPANCA")
            return false;
        else
            return true;
    }

    private boolean validateAgencyNumber(Integer agencyNumber) {
        if (agencyNumber < 0 || agencyNumber > 4)
            return false;
        else
            return true;
    }

    private boolean validateAccountNumber(Integer accountNumber) {
        if (accountNumber < 0 || accountNumber > 8)
            return false;
        else
            return true;
    }

}
