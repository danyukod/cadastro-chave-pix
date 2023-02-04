package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.domain.validation.RegistrationValidation;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRequest;

import java.util.regex.Pattern;

public class RandomValidate extends AccountValidation implements RegistrationValidation {

    private static Pattern regexPatternPhoneNumber = Pattern.compile("^[a-zA-Z0-9]{36}$");

    @Override
    public boolean pixKeyValidate(PixKeyRequest pixKeyRequest) {
        if (pixKeyRequest == null || pixKeyRequest.pixKey() == null)
            return false;

        return regexPatternPhoneNumber.matcher(pixKeyRequest.pixKey()).matches()
                && super.accountValidate(pixKeyRequest);
    }


}
