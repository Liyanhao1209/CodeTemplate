package Tarjan.LCA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TarjanLCA {
    private List<Integer>[] e;
    private List<int[]>[] query;
    private int[] fa;
    private boolean[] vis;
    private int[] ans;

    /**
     * 求LCA
     * @param edge 边集
     * @param queries 查询
     * @param n 总共几个节点
     * @return 查询对应的LCA集合
     */
    public int[] Tarjan(int[][] edge,int[][] queries,int n,int root){
        e = new ArrayList[n];
        Arrays.setAll(e,e->new ArrayList<>());

        query = new ArrayList[n];
        Arrays.setAll(query,e->new ArrayList<>());

        fa = new int[n];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        vis = new boolean[n];
        Arrays.fill(vis,false);
        ans = new int[queries.length];

        // 邻接表建边
        for (int[] es : edge) {
            e[es[0]].add(es[1]);
            e[es[1]].add(es[0]);
        }

        // tarjan 查询数组
        for (int i = 0; i < queries.length; i++) {
            int[] qs = queries[i];
            query[qs[0]].add(new int[]{qs[1],i});
            query[qs[1]].add(new int[]{qs[0],i});
        }

        dfs(root);
        return ans;
    }

    private void dfs(int node){
        vis[node] = true;

        for (Integer child : e[node]) {
            if(!vis[child]){
                dfs(child);
                fa[child] = node;
            }
        }

        // 向上一层返回时记录LCA
        for (int[] q : query[node]) {
            if(vis[q[0]]){
                ans[q[1]] = find(q[0]);
            }
        }
    }

    private int find(int x){
        if(fa[x]!=x){
            fa[x] = find(fa[fa[x]]);
        }
        return fa[x];
    }

}
