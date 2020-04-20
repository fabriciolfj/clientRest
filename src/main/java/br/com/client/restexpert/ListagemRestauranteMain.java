package br.com.client.restexpert;

import br.com.client.restexpert.api.ClientApiException;
import br.com.client.restexpert.api.RestauranteClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class ListagemRestauranteMain {

    public static void main(String[] args) {
        try {
            RestauranteClient restauranteClient = new RestauranteClient(new RestTemplate(), "http://localhost:9090");
            restauranteClient.listar().stream().forEach(System.out::println);
        } catch (ClientApiException e) {
            log.error(e.getProblem() != null ? e.getProblem().toString() : "Error desconhecido. Trace: " + e.getMessage());
        }
    }
}
