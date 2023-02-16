package br.com.itau.cadastrochavepix.app.model.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PixKeyRegisterRequest(

        @NotBlank
        String pixKeyType,
        String pixKey,
        @NotBlank
        String accountType,
        @NotNull
        Integer agencyNumber,
        @NotNull
        Integer accountNumber,
        @NotBlank
        String accountHolderName,
        String accountHolderLastName

) {
}