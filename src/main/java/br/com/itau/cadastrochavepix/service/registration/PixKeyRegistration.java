package br.com.itau.cadastrochavepix.service.registration;

public interface PixKeyRegistration {

    void inclusion();

    boolean pixKeyNumberValidate();

    boolean quantityValidate();

    boolean formatValidate();

}
