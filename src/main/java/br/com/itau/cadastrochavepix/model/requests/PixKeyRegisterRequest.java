package br.com.itau.cadastrochavepix.model.requests;

import br.com.itau.cadastrochavepix.model.enums.PixKeyType;

public record PixKeyRegisterRequest(
        PixKeyType pixKeyType,
        String pixKey,
        String pixAccountType,
        Integer agencyNumber,
        Integer accountNumber,
        String accountHolderName,
        String accountHolderLastName
) {

}
