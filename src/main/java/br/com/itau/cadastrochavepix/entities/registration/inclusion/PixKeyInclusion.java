package br.com.itau.cadastrochavepix.entities.registration.inclusion;

import br.com.itau.cadastrochavepix.models.requests.PixKeyRequest;

public interface PixKeyInclusion {
    public void inclusion(PixKeyRequest request);

    boolean verifyEqualsPixKeyNumber();

    boolean verifyPixKeyQuantity();

}
