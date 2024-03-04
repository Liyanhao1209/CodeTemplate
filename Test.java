import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();

        int[][] values = null;
        if(Objects.equals(args[0], "1")){
            values = useInputFile(args); // 使用读入文件的方式
        }

        // 使用程序内嵌数据的方式


        assert values != null;
        BiListNode biListNode = constructBiLinkedListViaArray(values[0]);

        for(int i=1;i<=5;i++){
            for(int j=0;j<i;j++){
                System.out.println(
                        s.locate(biListNode,i)
                );
            }
        }
    }

    public static ListNode[] test(int[][] values){
        return constructKLinkedListViaArray(values);
    }

    public static BiListNode constructBiLinkedListViaArray(int[] values){
        BiListNode head = new BiListNode(null,null,0,0);

        BiListNode cur = head;
        for (int value : values) {
            cur.next = new BiListNode(cur,null,value,0);
            cur = cur.next;
        }

        return head;
    }

    // 创造K个单循环链表
    public static ListNode[] constructKCyclicLinkedListViaArray(int[][] values){
        ListNode[] LinkedLists = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            LinkedLists[i] = constructCyclicLinkedListViaArray(values[i]);
        }

        return LinkedLists;
    }

    // 创造1个单循环链表
    public static ListNode constructCyclicLinkedListViaArray(int[] values){
        ListNode dummy = new ListNode(0, null);

        ListNode cur = dummy;
        for (int value : values) {
            cur.next = new ListNode(value,null);
            cur = cur.next;
        }

        cur.next = dummy;

        return dummy;
    }

    // 根据K个数组生成K个链表
    public static ListNode[] constructKLinkedListViaArray(int[][] values){
        ListNode[] LinkedLists = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            LinkedLists[i] = constructLinkedListViaArray(values[i]);
        }

        return LinkedLists;
    }

    // 根据1个数组生成1个链表
    public static ListNode constructLinkedListViaArray(int[] arr){
        ListNode head  = new ListNode(0,null);
        ListNode cur = head;

        for (int i : arr) {
            cur.next = new ListNode(i,null);
            cur = cur.next;
        }

        return head;
    }

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

    public static void stdOut(String[] args){
        System.out.println("program argument: "+Arrays.toString(args));
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
}
