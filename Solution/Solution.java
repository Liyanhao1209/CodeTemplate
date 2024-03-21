package Solution;

import util.ds.Collections.Stack.ArrayStack;

import java.util.Arrays;

public class Solution{
    int n,k;
    int min,minStk;
    public boolean reArrange(int[] sequence,int k){
        int cur = 1;
        n = sequence.length;
        this.k = k;
        min = n +1;
        minStk = k+1;

        ArrayStack<Integer>[] tracks = new ArrayStack[k];
        Arrays.setAll(tracks,e->new ArrayStack<>(10));

        for (int car : sequence) {
            if(car==cur){
                System.out.println("Moving car "+car+" from input track to output track");
                cur++;

                // 把能输出的车全部输出出来
                while(min==cur){
                    outputFromCache(tracks, minStk);
                    cur++;
                }
            }else{
                // 将车辆置入轨道
                boolean flag = putCarToCache(car, tracks);
                if(!flag){
                    return false;
                }
            }

        }


        return true;
    }

    public void outputFromCache(ArrayStack<Integer>[] tracks,int track){
        Integer car = tracks[track].pop();
        System.out.println("Moving car "+car+" from cache "+track+" to output track");

        // 更新最小值
        min = n+2;

        for (int i = 0; i < tracks.length; i++) {
            ArrayStack<Integer> stk = tracks[i];
            if(!stk.isEmpty()&&stk.peek()<min){
                min = stk.peek();
                minStk = i;
            }
        }
    }

    public boolean putCarToCache(int car,ArrayStack<Integer>[] tracks){
        int track = -1;
        int top = n+1;

        for (int i = 0; i < tracks.length; i++) {
            ArrayStack<Integer> stk = tracks[i];

            if(!stk.isEmpty()){
                Integer peek = stk.peek();
                if(car<peek&&peek<top){
                    top = peek;
                    track = i;
                }
            }else{
                if(track==-1){
                    track = i;
                }
            }
        }

        if(track==-1){
            // 没找到能放的轨道
            return false;
        }

        tracks[track].push(car);
        System.out.println("Moving car "+car+" from input track to cache "+track);

        if(car<min){
            min = car;
            minStk = track;
        }

        return true;
    }

}