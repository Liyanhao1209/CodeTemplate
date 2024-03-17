package util.ds.Collections.Stack;

import util.Exception.OppositeStackOverflowException;
import util.Interface.Expander;
import java.lang.reflect.Array;

public class OppositeStack<T> implements Expander<T> {
    private static final int ILLEGAL_TOP_PTR=-1;
    private T[] arr;
    int top1,top2;
    int expandSpeed;

    public void checkOverflow() {
        if (top1>=top2){
            try {
                throw new OppositeStackOverflowException("2 stack memory overflow");
            } catch (OppositeStackOverflowException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean is1Empty(){
        checkOverflow();
        return top1 == ILLEGAL_TOP_PTR;
    }

    public boolean is2Empty(){
        checkOverflow();
        return top2>=arr.length;
    }

    public int size1(){
        checkOverflow();
        return top1+1;
    }

    public int size2(){
        checkOverflow();
        return arr.length-top2;
    }

    public synchronized void push1(T ele){
        checkOverflow();
        if(top1+1>=top2){
            arr = this.dynamicDilatation(arr,(arr.length+1)*expandSpeed);
        }
        arr[++top1] = ele;
    }

    public synchronized void push2(T ele){
        checkOverflow();
        int newSize2 = size2()+1;
        if(top2-1<0||top2-1<=top1){
            arr = this.dynamicDilatation(arr,(arr.length+1)*expandSpeed);
        }
        top2 = arr.length-newSize2;
        arr[top2] = ele;
    }

    public synchronized T pop1(){
        checkOverflow();
        if(top1==ILLEGAL_TOP_PTR){
            return null;
        }

        return arr[top1--];
    }

    public synchronized T pop2(){
        checkOverflow();
        if(top2>=arr.length){
            return null;
        }

        return arr[top2++];
    }

    public synchronized T peek1(){
        checkOverflow();
        return top1==ILLEGAL_TOP_PTR?null:arr[top1];
    }

    public synchronized T peek2(){
        checkOverflow();
        return top2==arr.length?null:arr[top2];
    }

    @Override
    public String toString(){
        checkOverflow();
        StringBuilder sb = new StringBuilder();
        sb.append("from left to right correspond from bottom to top:\n");

        sb.append("[ ");
        for (int i = 0; i <= top1; i++) {
            sb.append(arr[i].toString()).append(" ");
        }
        sb.append("]\n");

        sb.append("[ ");
        for(int i = arr.length-1;i>=top2;i--){
            sb.append(arr[i].toString()).append(" ");
        }
        sb.append("]");

        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public OppositeStack(int expand){
        this.expandSpeed = expand;
        top1 = ILLEGAL_TOP_PTR;
        arr = (T[])new Object[0];
        top2 = arr.length;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] dynamicDilatation(T[] src, int newLen) {

        checkOverflow();

        if(src.length>=newLen){
            return src;
        }

        int size2 = size2();
        T[] res = (T[]) Array.newInstance(src.getClass().getComponentType(),newLen);
        if(top1!=-1){
            System.arraycopy(src,0,res,0,top1+1);
        }
        if(top2<arr.length){
            System.arraycopy(src,top2,res,newLen-size2,size2);
        }

        top2 = newLen-size2;
        return res;
    }
}
