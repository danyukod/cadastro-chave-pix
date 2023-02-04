package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.domain.validation.RegistrationValidation;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRequest;

import java.util.regex.Pattern;

public class PhoneValidate extends AccountValidation implements RegistrationValidation {

    private static Pattern regexPatternPhoneNumber = Pattern.compile("\\+((\\d{11,14}))");

    @Override
    public boolean pixKeyValidate(PixKeyRequest pixKeyRequest) {
        if (pixKeyRequest == null || pixKeyRequest.pixKey() == null) {
            return false;
        }
        return regexPatternPhoneNumber.matcher(pixKeyRequest.pixKey()).matches()
                && super.accountValidate(pixKeyRequest);
    }

}
