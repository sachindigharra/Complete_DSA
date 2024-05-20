import java.util.*;
public class UsingSingalstack {
    static class Queue{
        static Stack<Integer>s=new Stack<>();
        
        static void add(int data){
            if(s.isEmpty()){
                s.push(data);
                return;
    
            }
            int top=s.pop();
            add(data);
            s.push(top);
        }
        static int pop(){
            if(s.isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return s.pop();
        }
        static int peek(){
            if(s.isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return s.peek();
        }
        static boolean isEmpty(){
            return s.isEmpty();
        }
    }
    public static void main(String[] args) {
        // Queue qs=new Queue();
        // qs.add(10);
        // qs.add(20);
        // qs.add(30);
        // qs.add(40);
        // qs.add(50);
        // qs.add(60);
        // qs.add(70);
        // qs.add(80);
        // while(!qs.isEmpty()){
        //     System.out.println(qs.pop());
        // }

        
    }
}
