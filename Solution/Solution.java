package Solution;

import util.ds.Collections.Queue.MyCircularQueue;

public class Solution{
    public void showCircularQueue(){
        MyCircularQueue q = new MyCircularQueue(6);

        q.enQueue(6);
        q.Rear();
        q.Rear();
        q.deQueue();
        q.enQueue(5);
        q.Rear();
        q.deQueue();
        q.Front();
        q.deQueue();
        q.deQueue();
        q.deQueue();
    }

}