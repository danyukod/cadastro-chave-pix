package br.com.itau.cadastrochavepix.entities.registration;

public interface PixKeyRegistration {

    void inclusion();

    boolean pixKeyNumberValidate();

    boolean quantityValidate();

    boolean formatValidate(String PixKey);

}
