package br.com.itau.cadastrochavepix.domain.inclusion;

import br.com.itau.cadastrochavepix.app.model.responses.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.domain.entity.PixKey;

public interface RegistrationInclusion {
    public PixKeyRegisterResponse includes(PixKey pixKey);

}
