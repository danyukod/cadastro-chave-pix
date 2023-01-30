package br.com.itau.cadastrochavepix.models.responses;

import br.com.itau.cadastrochavepix.models.enums.PixKeyType;

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
