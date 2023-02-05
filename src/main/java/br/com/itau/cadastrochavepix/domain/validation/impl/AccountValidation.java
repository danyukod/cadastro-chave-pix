package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.model.enums.AccountType;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRequest;

public class AccountValidation {

    public boolean accountValidate(PixKeyRequest pixKeyRequest) {
        if (pixKeyRequest == null || pixKeyRequest.accountType() == null) {
            return false;
        }
        return validateAccountType(pixKeyRequest.accountType())
                && validateAgencyNumber(pixKeyRequest.agencyNumber())
                && validateAccountNumber(pixKeyRequest.accountNumber());
    }

    private boolean validateAccountType(AccountType accountType) {
        if (accountType.equals(AccountType.CORRENTE) || accountType.equals(AccountType.POUPANCA))
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

}
