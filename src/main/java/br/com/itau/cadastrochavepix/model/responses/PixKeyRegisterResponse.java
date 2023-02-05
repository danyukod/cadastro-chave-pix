package br.com.itau.cadastrochavepix.model.responses;

import br.com.itau.cadastrochavepix.model.enums.PixKeyType;

import java.util.Date;

public record PixKeyRegisterResponse(
        String id,
        PixKeyType pixKeyType,
        String pixKey,
        String pixAccountType,
        Integer agencyNumber,
        Integer accountNumber,
        String accountHolderName,
        String accountHolderLastName,
        Date createdAt
) {

}
