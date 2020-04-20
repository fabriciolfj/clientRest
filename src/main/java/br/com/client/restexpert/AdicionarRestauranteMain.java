package br.com.client.restexpert;

import br.com.client.restexpert.api.ClientApiException;
import br.com.client.restexpert.api.RestauranteClient;
import br.com.client.restexpert.model.input.CidadeInput;
import br.com.client.restexpert.model.input.CozinhaInput;
import br.com.client.restexpert.model.input.EnderecoInput;
import br.com.client.restexpert.model.input.RestauranteInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
public class AdicionarRestauranteMain {

    public static void main(String[] args) {
        try {
            var restTemplate = new RestTemplate();
            var restauranteClient = new RestauranteClient(
                    restTemplate, "http://localhost:9090");

            var cozinha = new CozinhaInput();
            cozinha.setId(1L);

            var cidade = new CidadeInput();
            cidade.setId(1L);

            var endereco = new EnderecoInput();
            endereco.setCidade(cidade);
            endereco.setCep("38500-111");
            endereco.setLogradouro("Rua Xyz");
            endereco.setNumero(300);
            endereco.setBairro("Centro");

            var restaurante = new RestauranteInput();
            restaurante.setNome("Comida Mineira");
            restaurante.setTaxaFrete(new BigDecimal(9.5));
            restaurante.setCozinha(new CozinhaInput());
            restaurante.setCozinha(cozinha);
            restaurante.setEndereco(endereco);

            log.info(restauranteClient.adicionar(restaurante).toString());
        } catch (ClientApiException e) {
            Optional.ofNullable(e.getProblem().getObjects()).map(o -> {
                log.warn(o.toString());
                return o;
            }).orElseThrow(() -> new RuntimeException("Erro desconhecido. Trace " + e.getMessage()));
        }
    }
}
