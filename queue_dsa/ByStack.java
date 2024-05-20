import java.util.*;
public class ByStack {
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();
        public static boolean isEmpty(){
            return s1.isEmpty() && s2.isEmpty();
        }
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public static int pop(){
            if(s1.isEmpty()) return -1;
            return s1.pop();
        }
        public static int peek(){
            if(s1.isEmpty())return -1;
            return s1.peek();
        }
    public static void main(String[] args) {
        //ByStack Sq=new ByStack();
        // Sq.add(10);
        // Sq.add(20);
        // Sq.add(30);
        // Sq.add(40);
        // Sq.add(50);
        // Sq.add(60);
        // while(!s1.isEmpty()){
        //     System.out.println(s1.pop());
        // }
    }
}
