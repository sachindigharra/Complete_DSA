public class CircularQueue {
    int []queue;
    int rear;
    int front;
    int size;
    public CircularQueue(int c){
        super();
        this.queue=new int[c];
        this.rear=-1;
        this.front=-1;
        this.size=c;
    }
    public boolean isEmpty(){
        return front==-1;
    }
    public boolean isFull(){
        return front==(rear+1)%size;
    }
    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue Is Full");
            return;
        }
        rear=(rear+1)%size;
        queue[rear]=data;
        if(front==-1) front=0;
        System.out.println("data: "+data+" front: "+front+" rear: "+rear);
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Queue Is empty");
            return;
        }
        for(int i=front;i!=rear;i=(i+1)%size){
            System.out.print(queue[i]+"<--");
        }
        System.out.println(queue[rear]);
    }
    public int deQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int temp=queue[front];
        if(front==rear){
            front=-1;
            rear=-1;
        }
        else{
            front=(front+1)%size;
        }
        
        return temp;
        

    }
    public static void main(String[] args) {
        CircularQueue qc=new CircularQueue(5);
        qc.enqueue(10);
        qc.enqueue(20);
        qc.enqueue(30);
        qc.enqueue(40);
        qc.enqueue(50);
        qc.enqueue(600);
        qc.display();

        
    }
}
