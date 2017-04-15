package consumer;

import data.Message;
import data.Topic;

public class Consumer extends Thread {

    private Topic topic;

    public Consumer(Topic topic) {
       this.topic = topic;
    }

    private Message consume() {
        return topic.release();
    }

    @Override
    public void run() {
       while (notInterrupted()) {
           Message message = consume();

           if (message == null) {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
               }
           }
       }
    }

    public boolean notInterrupted() {
        return ! Thread.currentThread().isInterrupted();
    }
}
