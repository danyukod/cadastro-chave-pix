package br.com.itau.cadastrochavepix.domain.entity;

import br.com.itau.cadastrochavepix.adapters.input.web.model.enums.PixKeyType;
import lombok.Getter;

import java.util.Random;
import java.util.UUID;

@Getter
public class PixKey {

    private PixKeyType pixKeyType;
    private String pixKey;
    private Account account;

    public PixKey(String pixKeyType, String pixKey, Account account) {
        this.pixKeyType = pixKeyType(pixKeyType);
        this.pixKey = isRandom() ? pixKey(generateRandomKey(), this.pixKeyType) : pixKey(pixKey, this.pixKeyType);
        this.account = account;
    }

    private boolean isRandom() {
        return pixKeyType.equals(PixKeyType.RANDOM);
    }

    private PixKeyType pixKeyType(String pixKeyType) {
        if (validatePixKeyType(pixKeyType))
            return PixKeyType.valueOf(pixKeyType);
        else
            throw new IllegalArgumentException("Tipo de chave inválido");
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

    private boolean validatePixKeyType(String pixKeyType) {
        if (pixKeyType.equals(PixKeyType.CPF)
                || pixKeyType.equals(PixKeyType.CNPJ)
                || pixKeyType.equals(PixKeyType.PHONE)
                || pixKeyType.equals(PixKeyType.EMAIL)
                || pixKeyType.equals(PixKeyType.RANDOM))
            return true;
        else
            return false;
    }

    private String generateRandomKey() {
        return UUID.randomUUID().toString().replace("-", randomNumber());
    }

    private CharSequence randomNumber() {
        return String.valueOf(new Random().nextInt(9));
    }

}
