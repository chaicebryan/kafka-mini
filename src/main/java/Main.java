import java.util.ArrayList;
import java.util.List;

import consumer.Consumer;
import data.Message;
import data.Topic;
import producer.Producer;

public class Main {

    public static void main(String[] args) {
        List<Message<Integer>> records = new ArrayList<>();

        for(int i = 0; i < 60000; i++) {
            records.add(new Message<>(i));
        }

        Topic<Message<Integer>> topic = new Topic<>(1, 100000);

        Consumer<Message<Integer>> recordConsumer1 = new Consumer<>(topic, 0);
        recordConsumer1.start();

        Producer<Message<Integer>> recordProducer = new Producer<>(topic);

        for (Message message : records) {
            recordProducer.send(0, message);
        }

    }
}
