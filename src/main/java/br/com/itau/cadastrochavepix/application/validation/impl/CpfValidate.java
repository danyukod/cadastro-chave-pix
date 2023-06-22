package br.com.itau.cadastrochavepix.application.validation.impl;

import br.com.itau.cadastrochavepix.application.validation.RegistrationValidation;
import br.com.itau.cadastrochavepix.application.validation.utils.CpfVerification;

import java.util.regex.Pattern;

public class CpfValidate implements RegistrationValidation {

    private static Pattern regexPatternCPF = Pattern.compile("^\\d{1,11}");

    @Override
    public boolean pixKeyValidate(String pixKey) {
        if (pixKey == null) {
            return false;
        }
        var cpfValite = new CpfVerification();

        return cpfValite.isCPF(pixKey)
                && regexValidate(pixKey);
    }

    private boolean regexValidate(String pixKey) {
        return regexPatternCPF.matcher(pixKey).matches();
    }

}
