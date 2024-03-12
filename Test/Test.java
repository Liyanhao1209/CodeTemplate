package Test;

import Solution.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static util.dataStream.DataStream.DIY_On_Your_Own;
import static util.dataStream.DataStream.useInputFile;
import static util.function.NodeFunction.constructKLinkedListViaArray;

public class Test {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();

        int[][] values = null;

        if(Objects.equals(args[0], "1")){
            values = useInputFile(args); // 使用读入文件的方式
        }else{
            values = DIY_On_Your_Own(); // 使用程序内嵌数据的方式
        }

        assert values != null;

        System.out.println(
                Arrays.toString(s.reverseQueue(values[0]))
        );

    }

}
