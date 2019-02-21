package edu.cnm.deepdive.diceware;

import java.security.SecureRandom;
import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class DicewareApplication {

  public static void main(String[] args) {
    SpringApplication.run(DicewareApplication.class, args);
  }

  @Bean
  public Random getRng() {
    return new SecureRandom(); // suitable for cryptographic purposes
  }


}
