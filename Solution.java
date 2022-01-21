
import java.io.*;
import java.util.*;

class NegativeValueException extends Exception{
    public NegativeValueException(String msg){
        super(msg);                                                                                                                     
    }
}
class Solution {
    
    public static int value(String s){
        int ans = 0;
        String ar[] = s.split("\n");
        for(String i: ar){
            try{
                ans+=Integer.parseInt(i);
            }
            catch(Exception e){
                continue;
            }
        }
        return ans;
    }
    
    public static int count(String s, String ch){
        
        int index = 0, c = 0;
        while (true)
        {
            index = s.indexOf(ch, index);
            if (index != -1)
            {
                c ++;
                index += ch.length();
            }
            else {
                break;
            }
        }
        return c;
    }
    
    public static int add(String s)throws Exception{
        int ans = 0;
        char delimiter = ',';
        if(s.equals(""))
            return 0;
        if(s.length()>2 && s.charAt(0)=='/'&& s.charAt(1)=='/'){
            delimiter = s.charAt(2);
        }
        if(delimiter!='-' && s.contains("-")){
            int cc = count(s, "-");
            throw new NegativeValueException("Total "+cc+" negative numbers found");
        }
        else{
            if(s.contains("--")){
                
                int cc = count(s,"--");
                throw new NegativeValueException("Total "+cc+" negative numbers found");
                
            }
            else{
                String ar[] = s.split(delimiter+"");
                System.out.println(delimiter);
                System.out.println(Arrays.toString(ar));
                for(String i: ar){
                    ans+=value(i);
                }
            }
        }
        return ans;
    }
    
	public static void main (String[] args)throws Exception  {
// 		int ans = add("");
// 		System.out.println(ans);
	}
}
