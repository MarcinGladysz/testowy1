package testowy1.kafka;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import testowy1.cqrs.commands.CommandProcessor;


public class Receiver {

    @Autowired
    private CommandProcessor processor;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topics.helloworld}")
    public void receive(String payload) {
        LOGGER.info("received payload='{}'", payload);
        System.out.println("doszlo"+ payload);
        latch.countDown();
    }

    @KafkaListener(topics = "${kafka.topics.comand}")
    public void commandReceive(String command){
        System.out.println("command doszlo"+ command);
    }
}
