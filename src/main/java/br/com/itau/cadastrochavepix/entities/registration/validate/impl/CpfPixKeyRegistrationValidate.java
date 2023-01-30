package br.com.itau.cadastrochavepix.entities.registration.validate.impl;

import br.com.itau.cadastrochavepix.entities.registration.utils.CpfValidate;
import br.com.itau.cadastrochavepix.entities.registration.validate.PixKeyRegistrationValidate;

import java.util.regex.Pattern;

public class CpfPixKeyRegistrationValidate implements PixKeyRegistrationValidate {

    public static final int MIN_CPF_LENGTH = 1;
    public static final int MAX_CPF_LENGTH = 11;

    private static Pattern regexPatternCPF = Pattern.compile("^\\d{1,11}");

    @Override
    public boolean formatValidate(String pixKey) {
        var cpfValite = new CpfValidate();

        return lengthValidate(pixKey) && cpfValite.isCPF(pixKey) && regexValidate(pixKey);
    }

    private boolean regexValidate(String pixKey) {
        return regexPatternCPF.matcher(pixKey).matches();
    }

    private boolean lengthValidate(String pixKey) {
        return pixKey.length() >= MIN_CPF_LENGTH && pixKey.length() <= MAX_CPF_LENGTH;
    }
}
