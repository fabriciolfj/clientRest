package br.com.client.restexpert.model;

import lombok.Data;

@Data
public class EnderecoModel {

    private String cep;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private CidadeModel cidade;

}
