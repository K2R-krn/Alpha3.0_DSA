
public class GetSetClearUpdateClearendClearrange_ithBit {
    //*   G E T   
    public static int GetIthBit(int n, int i){
        int bitMask = 1<<i;
        if((n & bitMask) == 0){
            return 0;
        } else {

            return 1;
        }
    }

    //*   S E T   
    public static int SetIthBit(int n , int i){
        int bitMask = 1<<i;
        return n | bitMask;
    }

    //*   C L E A R 
    public static int ClearIthBit(int n , int i){
        int bitMask = ~(1<<i);
        return n & bitMask;
    }

    //*  U P D A T E 
    public static int updateIthBit(int n, int i, int newBit){
        //^ Approach 1
        // if(newBit == 0){
        //     return ClearIthBit(n, i);
        // }else{
        //     return SetIthBit(n, i);
        // }

        //^ Approach 2
        n = ClearIthBit(n, i);
        int bitMask = newBit<<i;
        return n | bitMask;
    }

    //*  C L E A R    L A S T    i th   B I T S 
    public static int clearIBits(int n, int i){
        int bitMask = (~0)<<i;
        return n & bitMask;
    }

    //*  C L E A R    R A N G E    O F    B I T S 
    public static int ClearRange(int n, int i, int j){
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        int bitMask = a | b;
        return n & bitMask ;
    }
    public static void main(String args[]){
        System.out.println(GetIthBit(15, 3));
        System.out.println(SetIthBit(10, 2));
        System.out.println(ClearIthBit(10, 1));
        System.out.println(updateIthBit(10,2,1));
        System.out.println(clearIBits(15, 2));
        System.out.println(ClearRange(10, 2, 4));
        
    }
}
