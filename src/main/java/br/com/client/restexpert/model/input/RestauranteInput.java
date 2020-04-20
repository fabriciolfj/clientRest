package br.com.client.restexpert.model.input;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestauranteInput {

    private String nome;
    private BigDecimal taxaFrete;
    private CozinhaInput cozinha;
    private EnderecoInput endereco;
}
