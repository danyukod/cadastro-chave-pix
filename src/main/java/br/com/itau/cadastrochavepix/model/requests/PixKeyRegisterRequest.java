package br.com.itau.cadastrochavepix.model.requests;

import br.com.itau.cadastrochavepix.model.enums.PixKeyType;

import java.util.Random;
import java.util.UUID;

public record PixKeyRegisterRequest(
        PixKeyType pixKeyType,
        String pixKey,
        String accountType,
        Integer agencyNumber,
        Integer accountNumber,
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
