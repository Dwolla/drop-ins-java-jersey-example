package com.dwolla.dropintoken;

import com.dwolla.Dwolla;
import com.dwolla.DwollaEnvironment;
import com.dwolla.exception.DwollaException;
import com.dwolla.http.JsonBody;
import com.dwolla.http.Response;
import com.google.gson.JsonObject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
public class ClientTokenResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientTokenResource.class);

    private Dwolla dwolla = new Dwolla(
        "[DWOLLA_API_KEY]",
        "[DWOLLA_API_SECRET]",
        DwollaEnvironment.SANDBOX
    );

    @POST
    @Path("/tokenUrl")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String clientToken(JsonObject body) {
        try {
            LOGGER.info("Request Body: {}", body);
            Response<String> response = dwolla.post("client-tokens", jsonObjectToJsonBody(body));
            LOGGER.info("Dwolla Response: {}", response.body);
            return response.body;
        } catch (DwollaException e) {
            e.printStackTrace();
        }
        return null;
    }

    private JsonBody jsonObjectToJsonBody(JsonObject jsonObject) {
        JsonBody jsonBody = new JsonBody();
        jsonObject
            .entrySet()
            .forEach(item -> jsonBody.add(item.getKey(), item.getValue()));
        return jsonBody;
    }
}
