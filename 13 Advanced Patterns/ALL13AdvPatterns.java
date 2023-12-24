import java.util.*;
public class ALL13AdvPatterns {
    
// ***********************************************************************************************************************************************//

    // B U T T E R F L Y

    public static void Butterfly(int n){
        for(int i = 1;i<=n;i++){           // First Half
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            for(int j = 1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }System.out.println();
        }
        for(int i = n;i>=1;i--){           // Second Half
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            for(int j = 1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }System.out.println();
        }
    }

// ***********************************************************************************************************************************************//

        // Hollow Rectangle
        public static void HollowRectangle(int tr , int tc){
            for(int i = 1; i<=tr;i++){                      // Outer loop
                for(int j = 1;j<=tc;j++){                   //Inner loop
                    if(i==1||i==tr||j==1||j==tc){           // cell - (i,j)
                        System.out.print("*");              // Boundry cells
                    }
                    else{
                        System.out.print(" ");
                    }
                }System.out.println();
            }
        }
// ***********************************************************************************************************************************************//

        // Inverted Rotated Half Pyramid
        public static void InvRotHalPyr(int n){
            for(int i = 1; i<=n;i++){
                for(int j = 1;j<=n-i;j++){          // SPACES
                    System.out.print(" ");
                }
                for(int j = 1;j<=i;j++){            // STARS
                    System.out.print("*");
                }System.out.println();
            }   
        }
// ***********************************************************************************************************************************************//

        // Inverted Rotated Half pyramid With NOS
        public static void InvRotHalfPyramidNOS(int n){
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n-i+1;j++){
                    System.out.print(j);
                }System.out.println();
            }
        }
// ***********************************************************************************************************************************************//

        // FLOYDS TRIANGLE WITH NOS
        public static void FloydsTrianglewithNOS(int a){
            int c=1;
            for(int i=1;i<=a;i++){
                for(int j=1;j<=i;j++){
                    System.out.print(c);
                    c++;
                }System.out.println();
            }
        }
// ***********************************************************************************************************************************************//

        // 0 1 Triangle with Pattern.
        public static void Traingle01(int n){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=i;j++){
                    if((i+j)%2==0){
                        System.out.print("1");
                    }
                    else{
                        System.out.print("0");
                    }
                }System.out.println();
            }
        }
// ***********************************************************************************************************************************************//

        //  Solid Rhombus Pattern
        public static void SolidRhombus(int n){
            for(int i = 1; i<=n; i++){
                for(int j=1; j<=(n-i);j++){      //Spaces
                    System.out.print(" ");
                }for(int j=1;j<=n;j++){          //Stars
                    System.out.print("*");
                }System.out.println();
            }
        }

// ***********************************************************************************************************************************************//

        // HOLLOW RHOMBUS
        public static void HollowRhombus(int n){
            for(int i=1; i<=n; i++){
                for(int j=1;j<=(n-i);j++){                   //Spaces
                    System.out.print(" ");
                }
                for(int j=1; j<=n; j++){                    //Hollow Rectangle
                    if(i==1|| i==n|| j==1 || j== n ){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }System.out.println();
            }
        }

// ***********************************************************************************************************************************************//

       // D I A M O N D
         public static void Diamond(int a){
            // F I R S T     H A L F
            for(int i=1;i<=a;i++){
                for(int j=1;j<=a-i;j++){
                    System.out.print(" ");
                }
                for(int j=1;j<=(2*i)-1;j++){
                    System.out.print("*");
                }System.out.println();
            }
            // S E C O N D   H A L F
            for(int i=a;i>=1;i--){
                for(int j=1;j<=a-i;j++){
                    System.out.print(" ");
                }
                for(int j=1;j<=(2*i)-1;j++){
                    System.out.print("*");
                }System.out.println();
            }
        }  

// ***********************************************************************************************************************************************//

    public static void main(String args[]){
        HollowRectangle(a, b);
        InvRotHalPyr(a);
        InvRotHalfPyramidNOS(a);
        FloydsTrianglewithNOS(a);
        Traingle01(a);
        Butterfly(a);
        SolidRhombus(a);
        HollowRhombus(a);
        Diamond(a);
    }
}
