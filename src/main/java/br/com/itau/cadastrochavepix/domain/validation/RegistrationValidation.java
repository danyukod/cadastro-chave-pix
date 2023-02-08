package br.com.itau.cadastrochavepix.domain.validation;

import br.com.itau.cadastrochavepix.app.model.requests.PixKeyRequest;

public interface RegistrationValidation {

    boolean pixKeyValidate(String pixKey);

    boolean accountValidate(PixKeyRequest pixKeyRequest);

}
