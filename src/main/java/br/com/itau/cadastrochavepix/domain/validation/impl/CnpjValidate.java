package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.domain.validation.RegistrationValidation;
import br.com.itau.cadastrochavepix.domain.validation.utils.CnpjVerification;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRequest;

import java.util.regex.Pattern;

public class CnpjValidate extends AccountValidation implements RegistrationValidation {

    private static Pattern regexPatternCNPJ = Pattern.compile("^\\d{1,14}");

    @Override
    public boolean pixKeyValidate(PixKeyRequest pixKeyRequest) {
        if (pixKeyRequest == null || pixKeyRequest.pixKey() == null) {
            return false;
        }
        var cnpjValidate = new CnpjVerification();

        return cnpjValidate.isCNPJ(pixKeyRequest.pixKey())
                && regexValidate(pixKeyRequest.pixKey())
                && super.accountValidate(pixKeyRequest);
    }

    private boolean regexValidate(String pixKey) {
        return regexPatternCNPJ.matcher(pixKey).matches();
    }


}
