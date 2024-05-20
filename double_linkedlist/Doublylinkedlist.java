public class Doublylinkedlist{
    static Node head;
    static Node tail;
    static int size;
    private static class Node{
        private int data;
        Node prev;
        Node next;
        public Node(int data){
            this.data=data;
            prev=null;
            next=null;

        }
    }
    public int length(){
        return size;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void  insertFirst(int data){
        Node p=new Node( data);
        if(isEmpty()){
            head=tail=p;
            size++;
        }
        else{
            head.prev=p;
            p.next=head;
            head=p;
            size++;

        }
    }
    public void insertLast(int data){
        Node temp=new Node(data);
        if(isEmpty()){
            head=tail=temp;
            size++;
            return;
        }
        tail.next=temp;
        temp.prev =tail;
        tail=temp;
        size++;
    }
    public void forwardDisplay(){
        Node p=head;
        while(p!=null){
            System.out.print(p.data+"->");
            p=p.next;
        }
        System.out.print("null ");
    }
    public void backwardDisplay(){
        Node p=tail;
        while(p!=null){
            System.out.print(p.data+"<-");
            p=p.prev;
        }
        System.out.print("null");
    }
    public void removeFirst(){
            if(isEmpty()){
                return;
            }
            Node temp=head.next;
            head=temp;
            head.prev=null;
            size--;
    }
    public void removeLast(){
        if(isEmpty()){
            return;
        }
        tail=tail.prev;
        tail.next=null;
        size--;
    }
    public boolean  isPlaindrome(){
        if(tail.data!=head.data){
            return false;
        }
        return true;
    }
    public void reverse(){
        Node curr=head;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }          
    public static void main(String[] args) {
        Doublylinkedlist ls=new Doublylinkedlist();
        ls.insertFirst(100);
        ls.insertFirst(90);
        ls.insertFirst(80);
        ls.insertLast(110);
        ls.insertLast(120);
        ls.insertLast(130);
        ls.reverse();
        ls.forwardDisplay();
    }
}