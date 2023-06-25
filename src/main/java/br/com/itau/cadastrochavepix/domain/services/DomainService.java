package br.com.itau.cadastrochavepix.domain.services;

public interface DomainService<T, Y> {

    T create(Y y);

}
