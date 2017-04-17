package data;

import java.util.HashMap;
import java.util.Map;

public class Topic<T> {

    private String name;
    private Map<Integer, Partition<T>> partitions;

    public Topic(int numPartitions) {
        partitions = new HashMap<>(numPartitions);
        setUpTopic(numPartitions);
    }

    public Topic(int numPartitions, int partitionCapacity) {
        partitions = new HashMap<>(numPartitions);
        setUpTopicWithPartitionCapacity(numPartitions, partitionCapacity);
    }

    private void setUpTopic(int numPartitions) {
        for (int i = 0; i < numPartitions; i++) {
            partitions.put(i, new Partition<T>());
        }
    }

    private void setUpTopicWithPartitionCapacity(int numPartitions, int capacity) {
        for (int i = 0; i < numPartitions; i++) {
            partitions.put(i, new Partition<T>(capacity));
        }
    }

    public void accept(int partition, T message) {
         partitions.get(partition)
                 .enqueue(message);
    }

    public T release(int partition) {
       return partitions.get(partition)
               .dequeue();
    }

}
