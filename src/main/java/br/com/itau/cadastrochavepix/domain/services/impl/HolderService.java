package br.com.itau.cadastrochavepix.domain.services.impl;

import br.com.itau.cadastrochavepix.adapters.input.web.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.domain.entity.Holder;
import br.com.itau.cadastrochavepix.domain.services.DomainService;

public class HolderService implements DomainService<Holder, PixKeyRegisterRequest> {
    @Override
    public Holder create(PixKeyRegisterRequest pixKeyRegisterRequest) {
        return new Holder(pixKeyRegisterRequest.accountHolderName(),
                pixKeyRegisterRequest.accountHolderLastName());
    }
}
