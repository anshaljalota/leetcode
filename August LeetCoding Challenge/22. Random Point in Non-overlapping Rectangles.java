/*

Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.

Note:

An integer point is a point that has integer coordinates. 
A point on the perimeter of a rectangle is included in the space covered by the rectangles. 
ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
length and width of each rectangle does not exceed 2000.
1 <= rects.length <= 100
pick return a point as an array of integer coordinates [p_x, p_y]
pick is called at most 10000 times.
*/

class Solution {
    TreeMap<Integer,Integer> tm;
    int sum;
    Random rand = new Random();
    int [][] arr;

    public Solution(int[][] rects) {
        tm = new TreeMap<>();
        sum=0;
        arr=rects;
        for(int i=0;i<rects.length;i++){
            int []rect = rects[i];
            sum+=(rect[2]-rect[0]+1)*(rect[3]-rect[1]+1);
            tm.put(sum,i);
        }
    }
    
    public int[] pick() {
        int c = tm.ceilingKey(rand.nextInt(sum)+1);
        return util(arr[tm.get(c)]);
    }
    int[] util(int[] rect){
       int l = rect[0], r=rect[2],b = rect[1], t = rect[3];
        return new int[]{l + rand.nextInt(r-l+1),b+rand.nextInt(t-b+1)};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
