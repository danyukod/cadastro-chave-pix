package br.com.itau.cadastrochavepix.domain;

import br.com.itau.cadastrochavepix.domain.enums.PixKeyType;
import lombok.Getter;

import java.util.Random;
import java.util.UUID;

@Getter
public class PixKey {

    private PixKeyType pixKeyType;
    private String pixKey;
    private Account account;

    public PixKey(PixKeyType pixKeyType, String pixKey, Account account) {
        this.pixKeyType = pixKeyType;
        this.pixKey = isRandom() ? pixKey(generateRandomKey(), this.pixKeyType) : pixKey(pixKey, this.pixKeyType);
        this.account = account;
    }

    private boolean isRandom() {
        return pixKeyType.toString().equals(PixKeyType.RANDOM.toString());
    }

    private String pixKey(String pixKey, PixKeyType pixKeyType) {
        if (validatePixKey(pixKey, pixKeyType))
            return pixKey;
        else
            throw new IllegalArgumentException("Chave inválida");
    }

    private boolean validatePixKey(String pixKey, PixKeyType pixKeyType) {
        var validation = pixKeyType.validateFactory();
        return validation.pixKeyValidate(pixKey);
    }

    private String generateRandomKey() {
        return UUID.randomUUID().toString().replace("-", randomNumber());
    }

    private CharSequence randomNumber() {
        return String.valueOf(new Random().nextInt(9));
    }

}
