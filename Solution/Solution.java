package Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution{
    public boolean isValid(int[] pushSeq, List<int[]> pattern){
        if(pattern.size()==1){
            return true;
        }

        pattern.sort(Comparator.comparingInt(o -> o[1]));

        int len = Arrays.stream(pushSeq).max().getAsInt();
        int[] map = new int[len + 1];

        for (int i = 0; i < pushSeq.length; i++) {
            map[pushSeq[i]] = i;
        }

        int max;
        for (int i = 0; i < pattern.size();i++) {
            max = safelyGet(pattern.get(i)[0],map);
            for (int j = i+1; j < pattern.size(); j++) {
                max = Math.max(max,safelyGet(pattern.get(j)[0],map));
                if(safelyGet(pattern.get(j)[0],map)<safelyGet(pattern.get(i)[0],map)){
                    int posDiff = pattern.get(j)[1]-pattern.get(i)[1]-1;
                    int rankDiff = max - safelyGet(pattern.get(j)[0], map) - 1;
                    if(posDiff > rankDiff){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private int safelyGet(int ele,int[] rank){
        if(ele>=rank.length||ele<0){
            return 0;
        }
        return rank[ele];
    }
}