package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.model.requests.PixKeyRequest;

public class AccountValidation {

    public static final String CONTA_CORRENTE = "CORRENTE";
    public static final String CONTA_POUPANCA = "POUPANCA";

    public boolean accountValidate(PixKeyRequest pixKeyRequest) {
        if (pixKeyRequest == null) {
            return false;
        }
        return validateAccountType(pixKeyRequest.accountType())
                && validateAgencyNumber(pixKeyRequest.agencyNumber())
                && validateAccountNumber(pixKeyRequest.accountNumber());
    }

    private boolean validateAccountType(String accountType) {
        if (accountType.equals(CONTA_CORRENTE) || accountType.equals(CONTA_POUPANCA))
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
