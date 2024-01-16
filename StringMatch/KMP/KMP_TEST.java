package StringMatch.KMP;

public class KMP_TEST {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(
                kmp.search("ababaabaabac","abaabac")
        );
    }
}
