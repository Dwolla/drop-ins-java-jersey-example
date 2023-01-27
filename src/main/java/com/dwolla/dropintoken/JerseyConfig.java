package com.dwolla.dropintoken;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // Filters
        register(CORSResponseFilter.class);

        // Message Handlers
        register(GsonMessageBodyHandler.class);

        // Resources
        register(ClientTokenResource.class);
    }
}
