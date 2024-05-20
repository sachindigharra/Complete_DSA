public class Byarray {
    int rear;
    int size;
    int []queue;
    int front;
    public Byarray(int c){    
        this.rear=-1;
        this.queue=new int[c];
        this.size=c;
        front=-1;
    }
    public boolean isEmpty(){
        return rear==-1 && front==-1;
    }
    public boolean isFull(){
        return (rear+1)%size==front;
    }
    public void enQueue(int data){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }
        if(front==-1)front=0;
        rear=(rear+1)%size;
        queue[rear]=data;
        //System.out.println("Dta : "+data+" Added"+" front : "+front+" rear : "+rear);
    }
    public int deQueue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int result=queue[front];
        if(front==rear){
            front=rear=-1;
        }
        else{
            front=(front+1)%size;
        }
        return result;
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return ;
        }
        for(int i=0;i<=rear;i++){
            System.out.println(queue[i]);
        }
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is null");
            return -1;
        }
        return queue[front];
    }
    public static void main(String[] args) {
        Byarray q=new Byarray(5);
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);
        q.enQueue(50);
        q.enQueue(60);
        q.deQueue();
        q.display();
        System.out.println("peek value :"+q.peek());
    
    }
}
