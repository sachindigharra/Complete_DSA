public class Bylinkedlist {  
    static class Queuelinkedlist{
        int data;
        Queuelinkedlist next;
        Queuelinkedlist(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Queuelinkedlist head;
    static Queuelinkedlist tail;
    static boolean isEmpty(){
        return head==null && tail==null;
    }
    static void enQueue(int data){
        Queuelinkedlist temp=new Queuelinkedlist(data);
        if(head==null){
            head=tail=temp;
        }
        tail.next=temp;
        tail=temp;
    }
    static void deQueue(){
        if(isEmpty()){
            System.out.println("Queue is Null");
        }
        head=head.next;
    }
    static void display(){
        Queuelinkedlist temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        //Bylinkedlist ql=new Bylinkedlist();
        // ql.enQueue(10);
        // ql.enQueue(20);
        // ql.enQueue(30);
        // ql.enQueue(40);
        // ql.enQueue(50);
        // ql.enQueue(60);
        // ql.deQueue();
        // ql.display();
    }
}
