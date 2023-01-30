package br.com.itau.cadastrochavepix.entities.registration.inclusion;

import br.com.itau.cadastrochavepix.models.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.models.responses.PixKeyRegisterResponse;

public interface PixKeyInclusion {
    public PixKeyRegisterResponse inclusion(PixKeyRegisterRequest request);

}
