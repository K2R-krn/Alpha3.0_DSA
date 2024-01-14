import java.util.*;

public class ALL11Patterns {

// ***********************************************************************************************************************************************//
   
    // STAR PATTERN NESTED LOOP
    public static void StarpatternNestedLoos(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of lines : ");
        int n = sc.nextInt();

        for(int line = 1; line<=n; line++ ){
            for(int star=1; star<=line; star++){
                System.out.print("*");
            }
            System.out.println();
        }

    }   

// ***********************************************************************************************************************************************//
   
    // INVERTED STAR PATTERN 
        public static void InvertedStarPattern(){
            Scanner sc = new Scanner(System.in);
    
            System.out.print("Enter number of lines : ");
            int n = sc.nextInt();
    
            for(int lines = 1; lines<=n; lines++){
                for(int star = 1; star<=n-lines+1; star++){
                    System.out.print("*");
                }
            System.out.println();
            }   
                
                    // int rows = 5;        
                    // for (int i = rows; i >= 1; i--) {
                    //     for (int j = 1; j <= i; j++) {
                    //         System.out.print("* ");
                    //     }
                    //     System.out.println();
                    // }
                }
            
// ***********************************************************************************************************************************************//

    // HALF PYRAMID
    public static void HalfPyramidPattern(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of lines : ");
        int n = sc.nextInt();
        
        for(int line=1;line<=n; line++){
            for(int num=1; num<=line; num++){
                System.out.print(num);
            }
        System.out.println("");
        }
    
    }
// ***********************************************************************************************************************************************//
    
    // CharacterPattern
    public static void CharacterPattern(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of lines : ");
        int n = sc.nextInt();
        char ch = 'A';

        //Outer Loop
        for(int line = 1;line<=n;line++){
            //Inner Loop
            for(int chars=1; chars<=line; chars++){
                System.out.print(ch);
                ch++;
            }
        System.out.println();
        }
    }

// ***********************************************************************************************************************************************//

    // PQ4  FloydsTriangle 
    public static void PQ4FloydsTriangle(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of lines : ");
        int n = sc.nextInt();
        int ch = 1 ;              //Same as Character pattern. But there char ch ='A' //

        //Outer Loop
        for(int line = 1;line<=n;line++){
            //Inner Loop
            for(int chars=1; chars<=line; chars++){
                System.out.print(ch);
                ch++;
            }
        System.out.println();
        }
        
    }
// ***********************************************************************************************************************************************//
    public static void main(String args[]){

        StarpatternNestedLoos();
        InvertedStarPattern();
        HalfPyramidPattern();
        CharacterPattern();
        PQ4FloydsTriangle();
    
    }
}


