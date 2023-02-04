package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.model.requests.PixKeyRequest;

public class AccountValidation {

    public boolean accountValidate(PixKeyRequest pixKeyRequest) {
        if (pixKeyRequest == null) {
            return false;
        }
        return validateAccountType(pixKeyRequest.accountType())
                && validateAgencyNumber(pixKeyRequest.agencyNumber())
                && validateAccountNumber(pixKeyRequest.accountNumber());
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
