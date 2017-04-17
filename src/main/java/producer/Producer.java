package producer;

import data.Topic;

public class Producer<T> {

    private Topic<T> topic;

    public Producer(Topic topic) {
        this.topic = topic;
    }

    public void send(int partition, T message) {
        topic.accept(partition, message);
    }

    public boolean notInterrupted() {
        return !Thread.currentThread().isInterrupted();
    }
}
