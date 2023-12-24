public class FindSubsets {
    public static void findSubsets(String str, int i, String ans){
        //BC
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }
            else{
                System.out.println(ans);
            }
            return;
        }
        
        // If choice is YES
        findSubsets(str, i+1, ans+str.charAt(i));

        // If choice is NO
        findSubsets(str, i+1, ans);
    }

    public static void main(String args[]){
        findSubsets("abc",0, "");
    }
}
