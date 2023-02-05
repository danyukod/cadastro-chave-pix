package br.com.itau.cadastrochavepix.model.mapper;

import br.com.itau.cadastrochavepix.model.entity.PixKey;
import br.com.itau.cadastrochavepix.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.model.responses.PixKeyRegisterResponse;

public class PixKeyMapper {

    public PixKey mapRegisterToPixKey(PixKeyRegisterRequest pixKeyRegisterRequest) {
        var p = pixKeyRegisterRequest;

        return PixKey.builder()
                .pixKeyType(p.pixKeyType())
                .pixKey(p.pixKey())
                .accountType(p.accountType())
                .agencyNumber(p.agencyNumber())
                .accountNumber(p.accountNumber())
                .accountHolderName(p.accountHolderName())
                .accountHolderLastName(p.accountHolderLastName())
                .build();
    }

    public PixKeyRegisterResponse mapPixKeyToRegisterResponse(PixKey pixKey) {
        return PixKeyRegisterResponse.builder()
                .id(pixKey.getId())
                .pixKeyType(pixKey.getPixKeyType())
                .pixKey(pixKey.getPixKey())
                .accountType(pixKey.getAccountType())
                .agencyNumber(pixKey.getAgencyNumber())
                .accountNumber(pixKey.getAccountNumber())
                .accountHolderName(pixKey.getAccountHolderName())
                .accountHolderLastName(pixKey.getAccountHolderLastName())
                .createdAt(pixKey.getCreatedAt())
                .build();
    }

}
