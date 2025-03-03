package com.irs.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateNewTopic() {
        HashMap<String, String> configProps = new HashMap<>();

        // delete (borra mensaje), compact (mantiene el más actual)
        configProps.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);

        // Tiempo en ms de retención de mensajes, por defecto -1, retención permanente (86400000 = 1 día)
        configProps.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");

        // Tamaño máximo del segmento, expresado en bytes, por defecto 1073741824 (1073741824 = 1GB)
        configProps.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");

        // Tamaño máximo del mensaje, expresado en bytes, por defecto 1MB (1000000 = 1MB)
        configProps.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000000");

        // Si le asigno estas propiedades da un error al arrancar, como si no se tuviera permisos para acceder a Kafka Admin
        // las comento y funciona, crea el topic en envia el mensaje

        return TopicBuilder
                .name("springbootkafkaexample-topic")
                .partitions(1)
                .replicas(1)
                //.configs(configProps)
                .build();
    }
}
