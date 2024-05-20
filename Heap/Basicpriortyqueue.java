//We basicaly implemented the priority Queue Using Java Collections
import java.util.*;
class Basicpriortyqueue {
    static class  Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name, int rank){
            this.name=name;
            this.rank=rank;

        }
        @Override 
    public int compareTo(Student s2){
        return this.rank-s2.rank;
    }
    }
    
    public static void main(String[] args) {
     
       PriorityQueue<Student>pq=new PriorityQueue<>();
       pq.add(new Student("Ram", 1));
       pq.add(new Student("KANA", 1));
       pq.add(new Student("Kuldeep", 3));
       pq.add(new Student("sachin", 5));
       while (!pq.isEmpty()) {{
        System.out.println(pq.peek().name+"->"+pq.peek().rank);
        pq.remove();
       }
        
       }
    }
}