package br.com.itau.cadastrochavepix.models.requests;

import br.com.itau.cadastrochavepix.models.enums.PixKeyType;

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
