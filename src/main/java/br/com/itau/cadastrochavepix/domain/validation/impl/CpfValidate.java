package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.domain.validation.RegistrationValidation;
import br.com.itau.cadastrochavepix.domain.validation.utils.CpfVerification;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRequest;

import java.util.regex.Pattern;

public class CpfValidate extends AccountValidation implements RegistrationValidation {

    private static Pattern regexPatternCPF = Pattern.compile("^\\d{1,11}");

    @Override
    public boolean pixKeyValidate(PixKeyRequest pixKeyRequest) {
        if (pixKeyRequest == null || pixKeyRequest.pixKey() == null) {
            return false;
        }
        var cpfValite = new CpfVerification();

        return cpfValite.isCPF(pixKeyRequest.pixKey())
                && regexValidate(pixKeyRequest.pixKey())
                && super.accountValidate(pixKeyRequest);
    }

    private boolean regexValidate(String pixKey) {
        return regexPatternCPF.matcher(pixKey).matches();
    }

}
