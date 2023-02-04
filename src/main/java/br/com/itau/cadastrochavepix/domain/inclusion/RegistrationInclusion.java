package br.com.itau.cadastrochavepix.domain.inclusion;

import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyRegisterResponse;

public interface RegistrationInclusion {
    public PixKeyRegisterResponse includes(PixKeyRegisterRequest request);

}
