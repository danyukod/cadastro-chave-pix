package br.com.itau.cadastrochavepix.entity.registration.validate.impl;

import br.com.itau.cadastrochavepix.entity.registration.validate.RegistrationValidate;
import br.com.itau.cadastrochavepix.entity.registration.validate.utils.CpfValidate;

import java.util.regex.Pattern;

public class CpfRegistrationValidate implements RegistrationValidate {

    private static Pattern regexPatternCPF = Pattern.compile("^\\d{1,11}");

    @Override
    public boolean formatValidate(String pixKey) {
        if (pixKey == null) {
            return false;
        }
        var cpfValite = new CpfValidate();

        return cpfValite.isCPF(pixKey) && regexValidate(pixKey);
    }

    private boolean regexValidate(String pixKey) {
        return regexPatternCPF.matcher(pixKey).matches();
    }

}
