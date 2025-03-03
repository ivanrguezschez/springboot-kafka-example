package com.irs.provider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringbootKafkaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaProviderApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			kafkaTemplate.send("springbootkafkaexample-topic", "Hola Mundo Kafka desde Spring Boot App Provider");
		};
	}
}
