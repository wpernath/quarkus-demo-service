package org.wanja.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaConsumer {
    AtomicLong msgNumber = new AtomicLong(0);

    //@Channel("kafka")
    //Emitter<String> emitter;

    @Incoming("kafka")
    public void consume(String message) {
        Log.info("Kafka consumed: " + message);
    }

    /*
    @Scheduled(every = "1s")
    public void produceKafkaMessage() {
        String message = "Menno: " + msgNumber.getAndIncrement();
        Log.info("Scheduler is creating a new kafka message");
        emitter.send(message);
     }
     */
}
