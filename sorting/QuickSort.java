class QuickSort{
    public static void main(String[] args) {
        int[] arr = {1,45,23,11,89,22,0,2};
        int start = 0;
        int end = arr.length - 1;
        sort(arr,start,end);
        print(arr);
    }

    //QuickSort
    public static void sort(int[] arr, int start , int end){
        if(start<end){
            int partitionIndex =  partition(arr, start, end);
            sort(arr,start,partitionIndex-1);
            sort(arr,partitionIndex+1,end);
        }
    }

    //partition 
    public static int partition(int[] arr,int start, int end){
        int pivot = arr[end];
        int i = (start - 1);
        for(int j = start; j <= end; j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,end);
        return (i+1);
    }

    //Swap
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void print(int[] arr){
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}