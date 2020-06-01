/*
Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6]
*/

class StockSpanner {
public:
    int res;
    stack<pair<int,int>>st;
    StockSpanner() {
        res=0;
        while(!st.empty()){
            st.pop();
        }
    }
    
    int next(int price) {
        res++;
        int count;
        if(st.empty()){
            count=1;
        }
        else if(st.top().first>price){
            count = res - st.top().second;
        }
        else{
            while(!st.empty() && price>=st.top().first)
                st.pop();
            if(st.empty())
                count = res;
            else
                count = res - st.top().second;
        }
        st.push(make_pair(price,res));
        return count;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */
