package com.challenge.restaurant.domain.generic;

import lombok.Getter;

@Getter
public class OutputError implements OutputInterface{
    public final String mensagem;

    public OutputError(String mensagem){
        this.mensagem = mensagem;
    }

    @Override
    public Object getBody() {
        return null;
    }
}
