package data;

import java.util.LinkedList;
import java.util.List;

public class Partition<T> {

   private List<T> records;
   private int limit;

   public Partition() {
      records = new LinkedList<T>();
      limit = 2000;
   }

   public Partition(int limit) {
      records = new LinkedList<T>();
      this.limit = limit;
   }

   public synchronized void enqueue(T message) {
       while (capacityReached()) {
           try {
               wait();
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
           }
       }
       records.add(message);
       notifyAll();
   }

   public synchronized T dequeue() {
       if (records.isEmpty()) {
           System.out.println("Empty partition. Waiting....");
           try {
               wait();
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
           }
       }
       int lastIndex = records.size() - 1;

       T record = records.remove(lastIndex);
       notifyAll();
       return record;
   }

   private boolean capacityReached() {
      return (records.size() == limit);
   }

}
