package br.com.itau.cadastrochavepix.app.service.impl;

import br.com.itau.cadastrochavepix.app.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyRegisterResponse;
import br.com.itau.cadastrochavepix.domain.entity.Account;
import br.com.itau.cadastrochavepix.domain.entity.PixKey;
import br.com.itau.cadastrochavepix.domain.inclusion.RegistrationInclusion;

public class RegisterPixKeyService {

    RegistrationInclusion registrationInclusion;

    RegisterPixKeyService(RegistrationInclusion registrationInclusion) {
        this.registrationInclusion = registrationInclusion;
    }

    public PixKeyRegisterResponse registerPixKey(PixKeyRegisterRequest pixKeyRegisterRequest) {
        PixKey pixKey = createPixKey(pixKeyRegisterRequest);
        return includesPixKey(pixKey, registrationInclusion);
    }

    private PixKey createPixKey(PixKeyRegisterRequest pixKeyRegisterRequest) {
        Account account = createAccount(pixKeyRegisterRequest);

        return new PixKey(pixKeyRegisterRequest.pixKeyType(),
                pixKeyRegisterRequest.pixKey(),
                account);
    }

    private Account createAccount(PixKeyRegisterRequest pixKeyRegisterRequest) {
        return new Account(pixKeyRegisterRequest.accountType(),
                pixKeyRegisterRequest.accountNumber(),
                pixKeyRegisterRequest.agencyNumber(),
                pixKeyRegisterRequest.accountHolderName(),
                pixKeyRegisterRequest.accountHolderLastName());
    }

    private PixKeyRegisterResponse includesPixKey(PixKey pixKey, RegistrationInclusion registrationInclusion) {
        return registrationInclusion.includes(pixKey);
    }

}
