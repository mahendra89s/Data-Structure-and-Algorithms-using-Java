import java.util.*;;
public class HeapExample{


    public static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);

            int x = arr.size() - 1; //child index
            int parent = (x-1)/2; // parent index
            while(arr.get(x) < arr.get(parent)){
                // Swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                //after swap -> now parent will be child for next iteration
                // and using (x-1)/2 will get the parent for this.
                x = parent;
                parent = (x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }

        public int remove(){
            int data = arr.get(0);

            //Step 1->Swap first and last element
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,data);

            //Step2 -> remove last element
            arr.remove(arr.size()-1);

            // step 3 -> heapify
            heapify(0);
            return data;
        }

        private void heapify(int i){
            //     1
            //   2   3
            //  Heapify means restoring the heap structure again.
            //  i.e for min heap -> parent should be smaller than child.
            //  so swap the smaller child with parent if child is smaller than parent.

            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;
            if(left < arr.size() && arr.get(minIdx)>arr.get(left)){
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                // to recursion restore the structure for all nodes.
                heapify(minIdx);
            }
        }
    }


    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        while(!pq.isEmpty()){
            System.out.print(pq.peek()+ " ");
            pq.remove();
        }
    }

}