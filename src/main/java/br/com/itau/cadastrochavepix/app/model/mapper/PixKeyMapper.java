package br.com.itau.cadastrochavepix.app.model.mapper;

import br.com.itau.cadastrochavepix.app.model.requests.PixKeyRegisterRequest;
import br.com.itau.cadastrochavepix.infra.entity.PixKey;
import br.com.itau.cadastrochavepix.app.model.responses.PixKeyRegisterResponse;

import java.time.LocalDateTime;

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
                .createdAt(LocalDateTime.now())
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
