package util.dataStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class DataStream {
    private static void stdOut(String[] args){
        System.out.println("program argument: "+ Arrays.toString(args));
        System.out.println("Plz ensure your input txt file has correct format:");
        System.out.println("The first line which contains only one number k should be the total line number of the successive input data");
        System.out.println("Then there should have k extra lines to demonstrate the data,split by \",\"");
        System.out.println("Here's the result of your program:");
        System.out.println("-------------------------------------------------------------------------");
    }

    public static int[][] useInputFile(String[] args){
        stdOut(args);

        int[][] values = null;
        String filePath = args[1];
        try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
            int lines = Integer.parseInt(br.readLine());
            values = new int[lines][];

            for (int i = 0; i < lines; i++) {
                Integer[] line = Arrays.stream(br.readLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
                values[i] = new int[line.length];
                for (int j = 0; j < line.length; j++) {
                    values[i][j] = line[j];
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return values;
    }

    public static int[][] DIY_On_Your_Own(){
        return null;
    }
}
