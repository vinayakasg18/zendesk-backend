package com.zendesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // This is a comb of @componentscan, @autoconf, and @conf
// Creates a container and keeps all the components intact
public class ZendeskBootStrapper {
    public static void main(String[] args) {
        SpringApplication.run(ZendeskBootStrapper.class);
    }
}
