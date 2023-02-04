package br.com.itau.cadastrochavepix.model.requests;

import br.com.itau.cadastrochavepix.model.enums.PixKeyType;

public interface PixKeyRequest {

    String pixKey();

    PixKeyType pixKeyType();

    String accountType();

    Integer agencyNumber();

    Integer accountNumber();

}
