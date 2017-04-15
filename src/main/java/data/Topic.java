package data;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Topic {

    private String name;
    private BlockingQueue<Message> blockingQueue;

    public void accept(List<Message> messages) {
        messages.parallelStream()
                .forEach((message) -> accept(message));
    }

    private void accept(Message message) {
        blockingQueue.add(message);
    }

    public Message release() {
       return blockingQueue.remove();
    }

}
