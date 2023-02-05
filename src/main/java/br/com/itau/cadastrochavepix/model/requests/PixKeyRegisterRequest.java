package br.com.itau.cadastrochavepix.model.requests;

import br.com.itau.cadastrochavepix.model.enums.AccountType;
import br.com.itau.cadastrochavepix.model.enums.PixKeyType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Random;
import java.util.UUID;

public record PixKeyRegisterRequest(

        @NotNull
        PixKeyType pixKeyType,
        @NotBlank
        String pixKey,
        @NotNull
        AccountType accountType,
        @NotNull
        Integer agencyNumber,
        @NotNull
        Integer accountNumber,
        @NotBlank
        String accountHolderName,
        String accountHolderLastName

) implements PixKeyRequest {
    @Override
    public String pixKey() {
        if (pixKeyType.equals(PixKeyType.RANDOM))
            return generateRandomKey();
        else
            return pixKey;
    }

    private String generateRandomKey() {
        return UUID.randomUUID().toString().replace("-", randomNumber());
    }

    private CharSequence randomNumber() {
        return String.valueOf(new Random().nextInt(9));
    }
}
