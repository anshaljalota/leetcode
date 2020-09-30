/*

Given two version numbers, version1 and version2, compare them.

Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.
*/

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] t1 = version1.split("\\.");
        String[] t2 = version2.split("\\.");
        int i,j;
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        for(i=0;i<t1.length;i++){
            String temp = t1[i];
            int val=0;
            for(j=0;j<temp.length();j++){
                val  = val*10 + (t1[i].charAt(j) - '0');
            }
            v1.add(val);
        }
        for(i=0;i<t2.length;i++){
            String temp = t2[i];
            int val=0;
            for(j=0;j<temp.length();j++){
                val  = val*10 + (t2[i].charAt(j) - '0');
            }
            v2.add(val);
        }
        int s1 = v1.size() , s2 = v2.size();
        int diff = Math.abs(s1-s2);
        if(s1<s2){
            while(diff-->0)
                v1.add(0);
        }
        else{
            while(diff-->0)
                v2.add(0);
        }
        int a,b,range = v1.size();
        i=0;
        while(i<range){
            a= v1.get(i);
            b = v2.get(i);
            if(a<b){
                return -1;
            }
            else if(b<a){
                return 1;
            }
            i++;
        }
        return 0;
    }
}
