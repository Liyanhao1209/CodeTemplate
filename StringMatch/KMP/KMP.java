package StringMatch.KMP;

import java.util.ArrayList;
import java.util.List;

public class KMP {

    /**
     * 计算p在s中所有匹配子串的开始位置
     * @param s 主串
     * @param p 模式串
     * @return 所有匹配子串的开始位置
     */
    public List<Integer> search(String s,String p){
        ArrayList<Integer> ans = new ArrayList<>();
        char[] sch = s.toCharArray();
        char[] pch = p.toCharArray();
        int[] next = buildNext(p);

        int j = 0;
        for(int i=0;i<sch.length;){
            if(sch[i]==pch[j]){
                j++;
                if(j==pch.length){
                    ans.add(i-pch.length+1);
                    j=0;
                    if(pch.length>1){
                        continue;
                    }
                }
                i++;
                continue;
            }
            i -= j<1?-1:next[j-1];
            j=0;
        }

        return ans;
    }

    private int[] buildNext(String p){
        char[] ch = p.toCharArray();
        int plen = ch.length;
        int[] next = new int[plen];
        /*
        注意next[i]的值不可能是i+1，选取整个子串对跳过失败位置没有任何帮助
        例如abcabcd，匹配到d错了，此时看前方next[5]=3，即前五位正确，并且3前缀=3后缀
        然后向后挪动三位 也就是用第二个abc去匹配第一个abc
        但如果选取整个子串 next[5] = 6，这样向后挪动6位，就从d那一位开始匹配了
        反而错过了第二个abc，导致可能的错误
         */
        next[0] = 0;
        for(int i=1;i<plen;i++){
            // 先找到上一位匹配的k的长度
            int prev = next[i - 1];
            // 若上一轮匹配的k的后面一位等于当前这一位，相当于可以扩展一位
            /*
            例如，abcdabc,i=7,ch[7] = d
            既然要看这一轮的最大k，那么检查上一轮的k=3，说明ch[0,6]中 ch[0,2] 与 ch[4,6]是相等的
            这样如果 ch[3] = ch[7] = d，就可以在ch[0,2] = ch[4,6]上扩展一位
            变成 ch[0,3] = ch[4,7]
             */
            if(ch[prev]==ch[i]){
                next[i] = prev + 1;
            }
            /*
            若不等于，我们也不一定要从0再开始。举个例子
            abcabd dd abcab, i=13 ch[13] = c
            那么 c!= ch [ next[13-1] ] = ch[5] = d
            但 c = ch[ next[4] ]啊 那么这个4怎么来的？
            由于next[12] = 5，即ch[0,12]的5前缀等于5后缀 也就是说ch[0,4] = ch[8,12]
            那么我们想求最大的K，使得 ch[0,k-1] = ch[13-k+1,13]
            其中这个K很显然<5，不然就直接匹配上了，变成第一种情况了，也就是ch[13] = ch[5]了

            可以检查 next[4] ，也就是ch[0,4]中的最大K，这里是2 也即 ch[0,1] = ab = ch[3,4]
            又因为ch[0,4] = ch[8,12] 所以 ch[0,1] = ch[11,12]
            这个next[ next[13-1] - 1 ] = 2，就是本轮算上ch[13] = c之前的最大匹配长度
            所以 next[13] = 2+1 = 3
            可以用反证法证明
            假设存在3<k<5，使得ch[0,k-1] = ch[13-k+1,13]
            那么必有 abca = cabc，矛盾
             */
            else{
                /*
                如果得知ch[0,next[i-1]-1]中的最大K值，也就是next[ next[i-1]-1 ]，为0，

                 */
                int pnxtk = next[Math.max(next[i - 1] - 1, 0)];
                next[i] = 0;
                if(ch[i]==ch[pnxtk]){
                    next[i] = pnxtk + 1;
                }
            }
        }

        return next;
    }

}
