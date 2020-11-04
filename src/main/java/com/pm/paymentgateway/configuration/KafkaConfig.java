package com.pm.paymentgateway.configuration;

import com.pm.paymentgateway.model.Order;
import com.pm.paymentgateway.model.ProductDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {



    @Bean
    public ConsumerFactory<String, String> consumerFactory(){

        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory (){

        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<String, String>();

        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    // Factory for model Order
    @Bean
    public ConsumerFactory<String, Order> orderConsumerFactory(){

        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "ec2-18-207-140-130.compute-1.amazonaws.com:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"order");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(ConsumerConfig.SECURITY_PROVIDERS_CONFIG, "*");

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                new JsonDeserializer<>(Order.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Order> orderKafkaListenerFactory(){

        ConcurrentKafkaListenerContainerFactory<String, Order> factory = new
                ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(orderConsumerFactory());

        return factory;
    }




    //========== Kafka producer beans ===========//
    @Bean
    public ProducerFactory<String, ProductDto> producerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "ec2-18-207-140-130.compute-1.amazonaws.com:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonDeserializer.class);


        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, ProductDto> kafkaTemplate(){

        return new KafkaTemplate<String, ProductDto>(producerFactory());
    }

}
