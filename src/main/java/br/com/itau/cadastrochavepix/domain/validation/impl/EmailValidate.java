package br.com.itau.cadastrochavepix.domain.validation.impl;

import br.com.itau.cadastrochavepix.domain.validation.RegistrationValidation;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRequest;

public class EmailValidate extends AccountValidation implements RegistrationValidation {

    public static final int MIN_EMAIL_LENGTH = 3;
    public static final int MAX_EMAIL_LENGHT = 77;
    private static String regexPatternEmail = "^[A-Za-z0-9+_.-]+@(.+)$";


    @Override
    public boolean pixKeyValidate(PixKeyRequest pixKeyRequest) {
        if (pixKeyRequest == null || pixKeyRequest.pixKey() == null) {
            return false;
        }
        return pixKeyRequest.pixKey().matches(regexPatternEmail)
                && verifyLength(pixKeyRequest.pixKey())
                && super.accountValidate(pixKeyRequest);
    }

    private boolean verifyLength(String PixKey) {
        return PixKey.length() >= MIN_EMAIL_LENGTH && PixKey.length() <= MAX_EMAIL_LENGHT;
    }

}
