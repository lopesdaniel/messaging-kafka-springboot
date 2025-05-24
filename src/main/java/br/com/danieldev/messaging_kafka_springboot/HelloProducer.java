package br.com.danieldev.messaging_kafka_springboot;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloProducer {

  private KafkaTemplate<String, String> kafkatemplate;

  public HelloProducer(KafkaTemplate<String, String> kafkatemplate) {
    this.kafkatemplate = kafkatemplate;
  }

  public void sendMessage(String message) {
    kafkatemplate.send("hello-topic", message);
  }

}
