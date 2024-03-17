package util.ds.Collections.Queue;

class MyCircularDeque {
    int[] arr;
    int front,rear;

    public MyCircularDeque(int k) {
        arr = new int[k+1];

        front = rear = 0;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }

        int nF = (front-1+arr.length)%arr.length;

        arr[nF] = value;
        front = nF;

        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }

        arr[rear] = value;
        rear = (rear+1)%arr.length;

        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }

        front = (front+1)%arr.length;

        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }

        rear = (rear-1+arr.length)%arr.length;

        return true;
    }

    public int getFront() {
        return isEmpty()?-1:arr[front];
    }

    public int getRear() {
        return isEmpty()?-1:arr[(rear-1+arr.length)%arr.length];
    }

    public boolean isEmpty() {
        return front==rear;
    }

    public boolean isFull() {
        return front==(rear+1)%arr.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */