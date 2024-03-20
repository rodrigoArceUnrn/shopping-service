package ar.edu.unrn.shoppingservice.rabbitmq.service;

import ar.edu.unrn.shoppingservice.dto.DetailSaleDTO;
import ar.edu.unrn.shoppingservice.rabbitmq.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * RabbitService.
 */
@Service
@Slf4j
public class RabbitService {

    private final Producer producer;

    public RabbitService(Producer producer) {
        this.producer = producer;
    }

    public void sendSaleSuccessfullMessage(DetailSaleDTO result) {
        log.info("Message '{}' will be send ...", result.toJsonString());
        this.producer.send(result.toJsonString());
    }
}