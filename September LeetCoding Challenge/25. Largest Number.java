/*

Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null)
            return "";
        int range = nums.length;
        if(range==0)
            return "";
        String []str_val = new String[range];
        for(int i =0;i<range;i++)
            str_val[i] = String.valueOf(nums[i]);
        /*Comparator<String> custom = new Comparator<>(){
            @Override
            public int compare(String a, String b){
                String s1 = a+b;
                String s2 = b+a;
                return s2.compareTo(s1);
            }
        };*/
        Arrays.sort(str_val,new Comparator<>(){
            @Override
            public int compare(String a, String b){
                String s1 = a+b;
                String s2 = b+a;
                return s2.compareTo(s1);
            }
        });
        if(str_val[0].charAt(0)=='0'){
            return "0";
        }
        String res="";
        for(String str : str_val){
            res+=str;
        }
        return res;
    }
}
