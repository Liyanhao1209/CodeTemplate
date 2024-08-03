#include <stdio.h>
#include <vector>

using namespace std;

int main(){
    int n;
    scanf("%d",&n);

    int a=0;int b=0;
    for(int i=0;i<n;i++){
        scanf("%d",&b);
        printf("%d ",b-a);
        a=b;
    }
}