#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll n,d;

    while(cin>>n>>d)
    {
        vector<ll> ans;
        ll aux = 0;
        while((n % d) != 0)
        {
            ll di = n/d;
            ans.push_back(di);
            aux = d;
            d = n - di * d;
            n = aux;
        }
        ll di = n/d;
            ans.push_back(di);
            aux = d;
            d = n - di * d;
            n = aux;
        if(ans.size() == 1){
            printf("[%lld;]\n", ans[0]);
        }else{
            printf("[%lld;",ans[0]);
            for(int i=1;i<ans.size();i++)
                if(i == ans.size()-1)
                    printf("%lld]\n", ans[i]);
                else
                    printf("%lld,", ans[i]);
        }
    }
}
