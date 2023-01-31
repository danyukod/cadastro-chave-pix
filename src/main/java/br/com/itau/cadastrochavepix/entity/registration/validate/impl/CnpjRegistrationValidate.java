package br.com.itau.cadastrochavepix.entity.registration.validate.impl;

import br.com.itau.cadastrochavepix.entity.registration.validate.RegistrationValidate;
import br.com.itau.cadastrochavepix.entity.registration.validate.utils.CnpjValidate;

import java.util.regex.Pattern;

public class CnpjRegistrationValidate implements RegistrationValidate {

    private static Pattern regexPatternCNPJ = Pattern.compile("^\\d{1,14}");

    @Override
    public boolean formatValidate(String pixKey) {
        if (pixKey == null) {
            return false;
        }
        var cnpjValidate = new CnpjValidate();

        return cnpjValidate.isCNPJ(pixKey) && regexValidate(pixKey);
    }

    private boolean regexValidate(String pixKey) {
        return regexPatternCNPJ.matcher(pixKey).matches();
    }


}
