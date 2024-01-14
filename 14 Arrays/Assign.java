import java.util.*;
public class Assign {
    public static boolean RepeatOrNot(int nums[]){
        for(int i = 0; i <= nums.length;i++){
            for (int j = i+1; j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }


    // Question 2:There is an integer array nums sorted in ascending order (with distinct values).Prior to being 
    // passed to your function, nums is possibly rotated at an unknown pivot  index k (1  <=  k  <  nums.length)  such  that  
    // the  resulting  array  is [nums[k], nums[k+1],   ...,   nums[n-1], nums[0],   nums[1],   ...,   nums[k-1]] (0-indexed).   
    // For   example, [0,1,2,4,5,6,7] might        be        rotated        at        pivot        index 3   and become [4,5,6,7,0,1,2].
    // Given the array nums after the possible rotation and an integer target, returnthe index oftarget if it is in nums, or -1   
    // if it is not in nums.You must write an algorithm with O(log n) runtime complexity.


    public static int Q2(int nums[], int pivot){
        for(int i = 0;i<=nums.length;i++){
            if(nums[i]==pivot){
                return i;
            }
        }return -1;
    }
                                                 
    public static void Rotate(int nums[], int o,int temp[]){
        //int temp[]= new int[];
        // for(int i = 0;i<o;i++){
            int k =0;                            
            for(int j = o;j<nums.length;j++){   
                temp[k] = nums[j];     
                k++;
            } 
        // }
                                  
    }                                        
                                             

    public static void main(String args[]){
        int nums[] = {1,2,3,4,5,7,9,10};
        int temp[]= {1,0,0,0,0,0,0,0,0};
        int piv = 7;
        int o = Q2(nums, piv);
        
        Rotate(nums, o,temp);
        for(int i = 0;i<temp.length;i++){
            System.out.print(temp[i]);
        }
        //System.out.println(RepeatOrNot(nums));
    }
}
