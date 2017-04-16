package data;

import java.util.HashMap;
import java.util.Map;

public class Topic<T> {

    private String name;
    private Map<Integer, Partition<T>> partitions;

    public Topic() {
        partitions = new HashMap<>();
    }

    public synchronized void accept(int partition, T message) {
         partitions.get(partition)
                 .enqueue(message);
    }

    public synchronized T release(int partition) {
       return partitions.get(partition)
               .dequeue();
    }

}
