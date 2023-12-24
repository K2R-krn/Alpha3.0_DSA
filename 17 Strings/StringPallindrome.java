import java.util.*;
public class StringPallindrome {
    public static boolean isPallindrome(String str){
        for(int i = 0; i<str.length()/2;i++){
            if(str.charAt(i)!= str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        String str = "racrercar";
        System.out.println(isPallindrome(str));
    }
}