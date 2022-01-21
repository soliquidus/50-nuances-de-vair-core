package dev.config.bach.task;

import dev.entity.City;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public interface ItaskCity<T> {

    public T run(RestTemplate restTemplate, City city)throws HttpClientErrorException;
}
