package br.com.itau.cadastrochavepix.domain.validation;

import br.com.itau.cadastrochavepix.model.requests.PixKeyRequest;

public interface RegistrationValidation {

    boolean pixKeyValidate(PixKeyRequest pixKeyRequest);

}
