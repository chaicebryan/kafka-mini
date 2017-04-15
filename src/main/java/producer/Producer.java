package producer;

import java.util.List;

import data.Message;
import data.Topic;

public class Producer extends Thread {

    private Topic topic;

    public Producer() {
    }

    public Producer(Topic topic) {
        this.topic = topic;
    }

    private void send(List<Message> messages) {
        topic.accept(messages);
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
