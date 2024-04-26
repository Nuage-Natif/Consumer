package fr.lsarlinmagnus.nuna.kafka.consumer;


import jakarta.enterprise.context.ApplicationScoped;

import fr.lsarlinmagnus.nuna.kafka.model.Sentence;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Blocking;

@ApplicationScoped
public class SentenceProcessor {
    
    @Incoming("request")
    @Outgoing("sentence")
    @Blocking
    public Sentence process(String sentenceRequest) throws InterruptedException {
        Thread.sleep(200); //in ms
        String reversed = new StringBuilder(sentenceRequest).reverse().toString();
        return new Sentence(sentenceRequest, reversed);
    }
}
