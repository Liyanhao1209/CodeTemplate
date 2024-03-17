package util.ds.Collections.Queue;

public class MyCircularQueue {

    private final int[] arr;
    private int front,rear;
    private boolean tag;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = rear = 0;
        tag = true;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }

        arr[rear] = value;
        rear = (rear+1)%arr.length;
        if(rear==front&&tag){
            tag = false;
        }

        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        front = (front+1)%arr.length;
        if(front==rear&&!tag){
            tag = true;
        }

        return true;
    }

    public int Front() {
        return isEmpty()?-1:arr[front];
    }

    public int Rear() {
        return isEmpty()?-1:arr[(rear-1+arr.length)%arr.length];
    }

    public boolean isEmpty() {
        return front==rear && tag;
    }

    public boolean isFull() {
        return front==rear && !tag;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
