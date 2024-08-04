#include <iostream>
#include <vector>

using namespace std;

const int MAX_CORS = 5010;

int range_sum(int x1,int y1,int x2,int y2,const vector<vector<int>>& v){
    return v[x2][y2]-v[x1-1][y2]-v[x2][y1-1]+v[x1-1][y1-1];
}

int main(){
    int n,m;
    cin>>n>>m;

    vector<vector<int>> grid(MAX_CORS,vector<int>(MAX_CORS,0));
    vector<vector<int>> prefix(MAX_CORS,vector<int>(MAX_CORS,0));
    int x,y,v;
    for(int i=0;i<n;i++){
        cin >> x >> y >> v;
        grid[x+1][y+1] += v;
    }

    for(int i=1;i<MAX_CORS;i++){
        for(int j=1;j<MAX_CORS;j++){
            prefix[i][j] = prefix[i][j-1] + prefix[i-1][j] - prefix[i-1][j-1] + grid[i][j];
        }
    }

    int ans = 0;
    for(int i=1;i<=MAX_CORS-m;i++){
        for(int j=1;j<=MAX_CORS-m;j++){
            ans = max(
                ans,
                range_sum(i,j,i+m-1,j+m-1,prefix)
            );
        }
    }

    cout << ans << endl;
}