package consumer;

import data.Topic;

public class Consumer<T> extends Thread {

    private Topic<T> topic;
    private int targetPartition;

    public Consumer(Topic topic) {
        this.topic = topic;
        targetPartition = 0;
    }

    public Consumer(Topic topic, int targetPartition) {
        this.topic = topic;
        this.targetPartition = targetPartition;
    }

    private T consume(int partition) {
        return topic.release(partition);
    }

    @Override
    public void run() {
       while (notInterrupted()) {
           T message = consume(targetPartition);
       }
    }

    public boolean notInterrupted() {
        return ! Thread.currentThread().isInterrupted();
    }
}
