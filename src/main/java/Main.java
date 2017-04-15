import java.util.ArrayList;
import java.util.List;

import consumer.Consumer;
import data.Message;
import data.Topic;
import producer.Producer;

public class Main {

    public static void main(String[] args) {
        List<Message<Integer>> messages = new ArrayList<>();

        for (int i = 0; i < 2000; i++) {
            messages.add(new Message<>(new Integer(22)));
        }

        Topic topic = new Topic();

        Producer producer = new Producer(topic);
        producer.start();

        int numConsumers = 2;

        for (int i = 0; i < numConsumers; i++) {
            new Consumer(topic).start();
        }

    }
}
