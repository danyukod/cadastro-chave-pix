package br.com.itau.cadastrochavepix.domain.services.impl;

import br.com.itau.cadastrochavepix.adapters.input.web.model.request.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.domain.Account;
import br.com.itau.cadastrochavepix.domain.Holder;
import br.com.itau.cadastrochavepix.domain.enums.AccountType;
import br.com.itau.cadastrochavepix.domain.services.DomainService;

public class AccountService implements DomainService<Account, PixKeyRegisterRequest> {

    private DomainService<Holder, PixKeyRegisterRequest> domainService;

    public AccountService(DomainService domainService) {
        this.domainService = domainService;
    }

    @Override
    public Account create(PixKeyRegisterRequest pixKeyRegisterRequest) {
        var holder = domainService.create(pixKeyRegisterRequest);
        var accountType = AccountType.getAccountTypeFromString(pixKeyRegisterRequest.accountType());
        return new Account(accountType,
                pixKeyRegisterRequest.accountNumber(),
                pixKeyRegisterRequest.agencyNumber(),
                holder);
    }
}
