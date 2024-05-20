import java.util.*;
public class Code {
    static class Heap{
        ArrayList<Integer>ls=new ArrayList<>();
        public  void add(int ele){
            ls.add(ele);
            int x=ls.size()-1; // childe element 
            int par=(x-1)/2; // parent element of child
            while(ls.get(x)<ls.get(par)){
                int temp=ls.get(x);
                ls.set(x,ls.get(par));
                ls.set(par,temp);
                x=par;
                par=(x-1)/2;
            }
        }
        public int peek(){
            if(ls.size()==0){
                return -1;
            }
            return ls.get(0);
        }
        private void heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i;
            // check weather left is minimum then root
            if(left<ls.size()&& ls.get(left)<ls.get(i)){
                minIdx=left;
            }
            // check weather right is minimum then root
            if(right<ls.size()&& ls.get(right)<ls.get(i)){
                minIdx=right;
            }
            //root node satify the min heap condition or not
            if(minIdx!=i){
                int temp= ls.get(i);
                ls.set(i,ls.get(minIdx));
                ls.set(minIdx,temp);
                // check for next child is valid for min Heap
                heapify(minIdx);
            }
            
        }
        public int remove(){
            if(ls.size()==0){
                return -1;
            }
            // swap first element with last
            int temp=ls.get(ls.size()-1);
            ls.set(ls.size()-1,ls.get(0));
            ls.set(0,temp);
            // remove last element
            ls.remove(ls.size()-1);
            // check tree is nim Heap or not and Heapify make minheap;
            heapify(0);
            return temp;
        }
        public boolean isEmpty(){
            return ls.size()==0;
        }

    }
    
    public static void main(String[] args) {
        Heap pq=new Heap();
        pq.add(4);
        pq.add(-1);
        pq.add(1);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
            
        }
    }
}
