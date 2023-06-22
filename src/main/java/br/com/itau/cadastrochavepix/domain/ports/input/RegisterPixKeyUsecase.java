package br.com.itau.cadastrochavepix.domain.ports.input;

import br.com.itau.cadastrochavepix.adapters.input.web.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.adapters.input.web.model.responses.PixKeyRegisterResponse;

public interface RegisterPixKeyUsecase {

    PixKeyRegisterResponse execute(PixKeyRegisterRequest pixKeyRegisterRequest);

}
