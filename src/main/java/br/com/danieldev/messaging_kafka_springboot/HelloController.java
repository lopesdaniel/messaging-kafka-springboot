package br.com.danieldev.messaging_kafka_springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class HelloController {

  private HelloProducer serviceProducer;

  public HelloController(HelloProducer serviceProducer) {
    this.serviceProducer = serviceProducer;
  }

  @GetMapping("/hello/{name}")
  public String hello(@PathVariable("name") String name) {
    serviceProducer.sendMessage("Hello! " + name);
    return "OK";
  }

}
