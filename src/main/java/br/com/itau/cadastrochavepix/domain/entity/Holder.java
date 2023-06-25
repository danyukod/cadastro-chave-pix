package br.com.itau.cadastrochavepix.domain.entity;

import lombok.Getter;

@Getter
public class Holder {
    String name;

    String lastName;

    public Holder(String name, String lastName) {
        this.name = name(name);
        this.lastName = lastName;
    }

    private String name(String name) {
        if (validateName(name))
            return name;
        else
            throw new IllegalArgumentException("Nome do titular inválido");
    }

    private boolean validateName(String name) {
        if (name.length() < 3 || name.length() > 50)
            return false;
        else
            return true;
    }

}
