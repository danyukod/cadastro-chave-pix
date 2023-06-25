package br.com.itau.cadastrochavepix.domain.entity.validation.impl;

import br.com.itau.cadastrochavepix.domain.entity.validation.RegistrationValidation;
import br.com.itau.cadastrochavepix.domain.entity.validation.utils.CnpjVerification;

import java.util.regex.Pattern;

public class CnpjValidate implements RegistrationValidation {

    private static Pattern regexPatternCNPJ = Pattern.compile("^\\d{1,14}");

    @Override
    public boolean pixKeyValidate(String pixKey) {
        if (pixKey == null) {
            return false;
        }
        var cnpjValidate = new CnpjVerification();

        return cnpjValidate.isCNPJ(pixKey)
                && regexValidate(pixKey);
    }

    private boolean regexValidate(String pixKey) {
        return regexPatternCNPJ.matcher(pixKey).matches();
    }


}
