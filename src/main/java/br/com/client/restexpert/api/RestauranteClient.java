package br.com.client.restexpert.api;

import br.com.client.restexpert.model.RestauranteResumoModel;
import br.com.client.restexpert.model.input.RestauranteInput;
import lombok.AllArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestauranteClient {

    private static final String RESOURCE_PATH = "/restaurantes";
    private RestTemplate restTemplate;
    private String url;

    public List<RestauranteResumoModel> listar() {
        try {
            var uri = URI.create(url + RESOURCE_PATH);
            var restaurantes = restTemplate.getForObject(uri, RestauranteResumoModel[].class);
            return Arrays.asList(restaurantes);
        } catch (RestClientResponseException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
    }

    public RestauranteResumoModel adicionar(RestauranteInput restauranteInput) {
        try {
            var uri = URI.create(url + RESOURCE_PATH);
            return restTemplate.postForObject(uri, restauranteInput, RestauranteResumoModel.class);
        } catch (HttpClientErrorException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
    }
}
