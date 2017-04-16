package producer;

import data.Topic;

public class Producer<T> extends Thread {

    private Topic<T> topic;

    public Producer(Topic topic) {
        this.topic = topic;
    }

    private void send(int partition, T message) {
        topic.accept(partition, message);
    }

    @Override
    public void run() {
        while (notInterrupted()) {

        }
    }

    public boolean notInterrupted() {
        return !Thread.currentThread().isInterrupted();
    }
}
