public class sort {
    
    public static void bubbleSort(int arr[]){
        for(int j=0;j<arr.length;j++){
            int swapped = 0;
            for(int i=0;i<arr.length-1-j;i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = 1;
                }
            }
            if(swapped == 1){
                
            }
        }
    }

    public static void selectionSort(int arr[]){
        for(int i = 0;i<arr.length;i++){
            int minPos = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minPos]>arr[j]){
                    minPos = j;
                }
            }
            // SWAP CODE
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }
    public static void main(String args[]){
        int arr[] = {1,4,2,5,2,3};
        // bubbleSort(arr);
        selectionSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
