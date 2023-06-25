package br.com.itau.cadastrochavepix.domain.services.impl;

import br.com.itau.cadastrochavepix.adapters.input.web.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.domain.entity.Account;
import br.com.itau.cadastrochavepix.domain.entity.Holder;
import br.com.itau.cadastrochavepix.domain.services.DomainService;

public class AccountService implements DomainService<Account, PixKeyRegisterRequest> {

    private DomainService<Holder, PixKeyRegisterRequest> domainService;

    public AccountService(DomainService domainService) {
        this.domainService = domainService;
    }

    @Override
    public Account create(PixKeyRegisterRequest pixKeyRegisterRequest) {
        var holder = domainService.create(pixKeyRegisterRequest);
        return new Account(pixKeyRegisterRequest.accountType(),
                pixKeyRegisterRequest.accountNumber(),
                pixKeyRegisterRequest.agencyNumber(),
                holder);
    }
}
