package br.com.client.restexpert.model.input;

import lombok.Data;

@Data
public class EnderecoInput {

    private String cep;
    private String logradouro;
    private Integer numero;
    private String bairro;
    private CidadeInput cidade;
}
