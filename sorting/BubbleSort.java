import java.util.ArrayList;

class BubbleSort {
    public int[] sort(int[] list){
        int n = list.length;
        for(int i =0 ; i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(list[j] > list[j+1]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        return list;
    }
    public static void main(String[] args){
        BubbleSort b = new BubbleSort();
        int[] arr = {12,65,22,1,23};
        int[] sorted_list = b.sort(arr);
        for(int i : sorted_list){
            System.out.print(i+" ");
        }
    }
}
