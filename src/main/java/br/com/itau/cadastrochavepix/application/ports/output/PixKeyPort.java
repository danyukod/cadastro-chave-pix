package br.com.itau.cadastrochavepix.application.ports.output;

import br.com.itau.cadastrochavepix.adapters.input.web.model.response.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.domain.entity.PixKey;

public interface PixKeyPort {
    PixKeyRegisterResponse save(PixKey pixKey);

    boolean existsByPixKey(String pixKey);

    Long countByAgencyNumberAndAccountNumber(Integer agencyNumber, Integer accountNumber);
}
