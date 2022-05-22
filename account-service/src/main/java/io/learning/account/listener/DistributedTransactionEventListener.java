package io.learning.account.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.learning.account.service.EventBus;
import io.learning.core.domain.DistributedTransaction;
import lombok.extern.slf4j.Slf4j;

import static io.learning.account.config.MQConfig.QUEUE;

@Component
@Slf4j
public class DistributedTransactionEventListener {

    @Autowired
    private EventBus eventBus;
    @RabbitListener(queues={QUEUE} )
    public void onMessage(String transaction) {
        log.debug("Transaction message received: {}", transaction);
        // eventBus.sendTransaction(transaction);
    }

//    @RabbitListener(bindings = {
//            @QueueBinding(value = @Queue("txn-events-account"), exchange = @Exchange(type = ExchangeTypes.TOPIC, name = "txn-events"))
//    })
//    public void onMessage(String transaction) {
//        log.debug("Transaction message received: {}", transaction);
//       // eventBus.sendTransaction(transaction);
//    }

}
