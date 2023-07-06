package br.com.itau.cadastrochavepix.domain;

import lombok.Getter;

@Getter
public class Holder {
    String name;

    String lastName;

    public Holder(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        validate();
    }

    private void validate() {
        if (!validateName(this.name))
            throw new IllegalArgumentException("Nome do titular inválido");
    }

    private boolean validateName(String name) {
        if (name.length() < 3 || name.length() > 50)
            return false;
        else
            return true;
    }

}
