package dev.config.bach.task;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public interface Itask {
    public void run(RestTemplate restTemplate) throws HttpClientErrorException;
}
