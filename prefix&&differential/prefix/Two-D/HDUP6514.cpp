#include <string>
#include <iostream>
#include <vector>

using namespace std;

int main(){
    int n,m,p,q;
    cin>>n>>m;
    cin>>p;

    vector<vector<int>> grid(n+1,vector<int>(m+1,0));
    vector<vector<int>> prefix(n+1,vector<int>(m+1,0));

    int x1,y1,x2,y2;
    for(int i=0;i<p;i++){
        cin>>x1>>y1>>x2>>y2;
        for(int j=x1;j<=x2;j++){
            for(int k=y1;k<=y2;k++){
                grid[j][k] = 1;
            }
        }
    }

    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            prefix[i][j] = prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+grid[i][j];
        }
    }

    cin>>q;
    int sum;
    for(int i=0;i<q;i++){
        cin>>x1>>y1>>x2>>y2;
        sum = prefix[x2][y2]-prefix[x1-1][y2]-prefix[x2][y1-1]+prefix[x1-1][y1-1];
        if(sum==(x2-x1+1)*(y2-y1+1)){
            cout<<"YES"<<endl;
        }else{
            cout<<"NO"<<endl;
        }
    }
}