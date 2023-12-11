package PrimeSieve;

import PrimeSieve.Eth.EthPS;
import PrimeSieve.EulerPS.EulerPS;
import PrimeSieve.regular.RegularPS;
import PrimeSieve.sqrt.SqrtPS;

import java.util.List;

public class test {
    static int num = 200;

    public static void main(String[] args) {
        List<Integer> rps = new RegularPS().ps(num);
        List<Integer> sps = new SqrtPS().ps(num);
        List<Integer> Ethps = new EthPS().ps(num);
        List<Integer> Eulerps = new EulerPS().ps(num);
        System.out.println("Regular:");
        System.out.println(rps);
        System.out.println("Sqrt");
        System.out.println(sps);
        System.out.println("Eth");
        System.out.println(Ethps);
        System.out.println("Euler");
        System.out.println(Eulerps);
    }
}
