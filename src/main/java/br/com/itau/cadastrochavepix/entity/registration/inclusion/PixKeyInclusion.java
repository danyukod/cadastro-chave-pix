package br.com.itau.cadastrochavepix.entity.registration.inclusion;

import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyRegisterResponse;

public interface PixKeyInclusion {
    public PixKeyRegisterResponse inclusion(PixKeyRegisterRequest request);

}
