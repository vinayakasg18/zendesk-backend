package com.zendesk.dao;

import com.zendesk.config.Configuration;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Base64;

@Repository
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class TicketRepository {
    private RestTemplate restTemplate;
    private Configuration configuration;

    private HttpHeaders createHttpHeaders(String emailId, String token) {

        String notEncoded = emailId + "/token" + ":" + token;
        String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic " + encodedAuth);
        return headers;
    }


    public String fetchAllTickets() {
        String url = configuration.getTicketsApi();
        String emailId = configuration.getEmailId();
        String token = configuration.getToken();
        URI uri = null;
        String json = "";
        try {
            uri = new URI(url);
            HttpHeaders headers = createHttpHeaders(emailId, token);
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
            if (response.getStatusCode().equals(HttpStatus.OK)) {
                json = response.getBody();
            } else {
                throw new Exception("Ah oh!. Looks like something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
