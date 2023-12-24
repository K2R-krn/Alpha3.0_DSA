public class Substring {
    public static String Substring(String str, int si, int ei){
        String substr = "";
        for(int i = si;i<ei;i++){
            substr += str.charAt(i);

        }
        return substr;
    }

    public static void main(String args[]){
        //Substring
        String str = "HelloK2R";
        System.out.println(Substring(str, 0, 5));

        str.substring(0, 5);                           //*    THIS IS THE FUNCTION TO DO THE SAME
    }
}
