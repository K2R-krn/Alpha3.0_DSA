import java.nio.file.SecureDirectoryStream;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
public class CharacterPattern {
    public static void main(String args[]){
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
}
