package com.food.ordering.system.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class KafkaMessageHelper {
    public <T> BiConsumer<SendResult<String, T>, Throwable>
    getKafkaCallback(String responseTopicName, T avroModel, String orderId, String avroModelName) {

        return new BiConsumer<SendResult<String, T>, Throwable>() {
            @Override
            public void accept(SendResult<String, T> stringPaymentRequestAvroModelSendResult, Throwable throwable) {
                if (throwable != null) {
                    log.error("Error while sending {} message {} to topic {}", avroModelName, avroModel.toString(), responseTopicName, throwable);
                } else {
                    RecordMetadata metadata = stringPaymentRequestAvroModelSendResult.getRecordMetadata();
                    log.info("Received successful response from kafka for order id: {}"
                                    + " topic {}, partition  {}, offsets {}, timestamp {}",
                            orderId,
                            metadata.topic(),
                            metadata.partition(),
                            metadata.offset(),
                            metadata.timestamp()
                    );
                }
            }
        };
    }
}
