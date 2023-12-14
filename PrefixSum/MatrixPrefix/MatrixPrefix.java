package PrefixSum.MatrixPrefix;

public class MatrixPrefix {
    private final int[][] sum;

    public MatrixPrefix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        sum = new int[m+1][n+1]; // convenient to compute
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum[i+1][j+1] = sum[i+1][j] + sum[i][j+1] - sum[i][j] + matrix[i][j]; // m[i][j] -> sum[i+1][j+1]
            }
        }
    }

    // top left corner: (r1,c1)
    // bottom right corner: (r2,c2)
    public int query(int r1,int c1,int r2,int c2){
        return
                sum[r2+1][c2+1] - sum[r2+1][c1] - sum[r1][c2+1] + sum[r1][c1];
    }
}
