package util.function;

import java.util.Random;

public class RandomFunction {
    // 生成一个在[l,r]中间的随机数
    public static int randomNum1(int l,int r){
        Random generator = new Random();
        int num;
        do {
            num = generator.nextInt(Integer.MAX_VALUE);
        }while(num<l||num>r);

        return num;
    }

    // 生成一个不在[l,r]的随机数
    public static int randomNum2(int l,int r){
        Random generator = new Random();
        int num;
        do {
            num = generator.nextInt(Integer.MAX_VALUE);
        }while(num>=l&&num<=r);

        return num;
    }
}
