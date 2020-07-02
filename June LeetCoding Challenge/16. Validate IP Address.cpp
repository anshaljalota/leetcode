/*
Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
*/
class Solution {
public:
    bool validate_char(char ch){
        ch = tolower(ch);
        if(ch>='a' && ch<='f')
            return true;
        return false;
    }
    bool validate_ipv6(string str){
        int i,len = str.length();
        if(len==0 || len>4)
            return false;
        
        for(i=0;i<len;i++){
            if(!(isdigit(str[i]) || validate_char(str[i])))
                return false;
        }
       return true;
    }
    bool ipv6(vector<string> vals){
        for(int i=0;i<vals.size();i++){
            if(!validate_ipv6(vals[i]))
                return false;
        }
        return true;
    }
    bool validate_ipv4(string str){
        int i,len = str.length();
        if(len==0 || len>3)
            return false;
        if(str[0]=='0' && len>1)
            return false;
        for(i=0;i<len;i++){
            if(!isdigit(str[i]))
                return false;
        }
        if(str<"256")
            return true;
        return false;
    }
    bool ipv4(vector<string> vals){
        for(int i=0;i<vals.size();i++){
            if(!validate_ipv4(vals[i]))
                return false;
        }
        return true;
    }
    string validIPAddress(string IP) {
        int i,j,len = IP.length(),count=0;
        vector<string> vals;
        string temp="",res="Neither";
        for(i=0;i<len;i++){
            if(IP[i]=='.'|| IP[i]==':'){
                count++;
                if(temp=="")
                    return res;
                vals.push_back(temp);
                temp="";
            }
            else{
                temp+=IP[i];
            }
        }
        if(temp!="")
            vals.push_back(temp);
        if(count==3 && vals.size()==4){
            if(ipv4(vals)){
                res="IPv4";
            }
        }
        else if(count==7 && vals.size()==8){
            if(ipv6(vals)){
                res="IPv6";
            }
        }
        return res;
    }
};
