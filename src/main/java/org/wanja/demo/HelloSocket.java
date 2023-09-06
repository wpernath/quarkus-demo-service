package org.wanja.demo;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloSocket {
    
    @Incoming("incoming-hello")
    @Outgoing("kafka")
    public String processHello(String message) {
        Log.info("WebService processed: " + message);
        return "Web Service processed: " + message;

    }
}
