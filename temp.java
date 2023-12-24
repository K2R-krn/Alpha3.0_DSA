public class temp {
    
    //*   T O    U P P E R
    public static String toUppeString(String str){
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i =1; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
//TODO ==========================================================================================================================================
    
    //*   C O M P R E S S 
    public static String Compress(String str){
        //String newStr = "";
        StringBuilder newStr = new StringBuilder("");

        
        for(int i=0; i<str.length();i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            //newStr += str.charAt(i);
            newStr.append(str.charAt(i));
            if(count>1){
                //newStr += count.toString();
                newStr.append(count.toString());
            }
        }
        return newStr.toString();
    }

//TODO ===========================================================================================================================================

    public static void main(String args[]){
        String str = "hello, i am k2R";
        String sstr = "aaaappowiieeerrrttttttt";
        System.out.println(toUppeString(str));
        System.out.println(Compress(sstr));
    }
}