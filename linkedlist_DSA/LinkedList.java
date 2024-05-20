import java.util.Queue;

public class LinkedList implements Queue<Integer>, Queue<Add_one_row_at_depth.TreeNode>, Queue<int[]> { 
    class Node{
        int data;
        Node next;
        public Node(){};
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data){
        Node ele=new Node(data);
        if(head==null){
            head=tail=ele;
            size++;
            return;
        }
        ele.next=head;
        head=ele;
        size++;

    }
    public void addEnd(int x){
        Node ele = new Node(x);
        if(head==null){
            head=tail=ele;
            return;
        }
        tail.next=ele;
        tail=ele;
        size++;
        
    }
    public void display(){
        if(head==null){
            System.out.println();
            return;
        }
       Node p=head;
        while(p!=null){
            System.out.print(p.data+"->");
            p=p.next;
        }
        System.out.print("null");
        
    }
    public int length(){
         Node p=head;
         int res=0;
         while(p!=null){
             res+=1;
            p=p.next;
         }
         return res;
    }
    public boolean contain(int data){
        Node p=head;
        while(p!=null){
            if(p.data==data){
                return true;
            
            }
            p=p.next;
        }
        return false;
    }
    public void set(int index,int data){
        Node newnode=new Node(data);
        Node temp=head;
        if(index==0){
            addFirst(data);
            return;
        }
        int i=0;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
        size++;
    }
    public void deleteIndex(int index){
        Node temp=head;
        if(size==0){
            System.out.println("ll is empty");
            return;
        }
        if(size==1){
            head=tail=null;
            size--;
            return;
            
        }
        if(index==0){
            head=head.next;
            size--;
            return;
        }
        int i=0;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        size--;

    }
    public Node middleNode(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(Node head) {
        Node mid=middleNode(head);
        Node left=head;
        Node prev=null;
        Node curr=mid;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;  
    }
     public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
     }
     public void techReverse(Node head){
        Node temp=new Node();
        Node prev=head;
        while(prev!=null){
            addFirst(prev.data);
            prev=prev.next;
        }
        head=temp.next;

     }
     public void removeNthnode(int n){
        if(size==n){
            head=head.next;
            return;
        }
        Node prev=head;
        int i=1;
        while(i!=size-n){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
     }
    public void  insertSortList(int data,Node head){
        Node temp=new Node(data);
        Node p=head;
        if(head==null){
            addFirst(data);
            return;
        }
        while(p!=null){
            if(p.next.data>data){
                break;
            }
            p=p.next;

        }
        p.next=temp;
        temp.next=p.next;
    }
    public void sort(){
           Node slow=head;
           Node fast=null;
           while(slow!=null){
                fast=slow.next;
                while(fast!=null){
                    if(slow.data>fast.data){
                        int var=slow.data;
                        slow.data=fast.data;
                        fast.data=var;
                    }
                    fast=fast.next;
                }
                slow=slow.next;
           }
           
        }
    private Node  getMid(Node head){
            Node slow=head;
            Node fast=head.next;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
        }
    private Node mergeLinked(Node head1, Node head2){
            Node dummy=new Node(-1);
            Node temp=dummy;
            while(head1!=null && head2!=null){
                    if(head1.data<=head2.data){
                        temp.next=head1;
                        head1=head1.next;
                        temp=temp.next;
                    }
                    else{
                        temp.next=head2;
                        head2=head2.next;
                        temp=temp.next;
                    }
            }
            while(head1!=null){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            while(head2!=null){
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
            return dummy.next;
        }
    public Node mergeSort(Node head){
            //Step 1 find middle Node
            if(head==null ||head.next==null){
                return head;
            }
            //find Mid Node
            Node mid=getMid(head);
            //left && right Node ms
            Node right=mid.next;
            mid.next=null;
            Node newLeft=mergeSort(head);
            Node newRight=mergeSort(right);
            //merge sorted linked list
            return mergeLinked(newLeft, newRight);
        }
    public void zigZag(Node head){
        if(head==null || head.next==null){
            return;
        }
        // find middle Node
        Node mid=getMid(head);
        //linked break into two part
        Node curr=mid.next;
        mid.next=null;
        Node left=head;
        //reverse the second part of linkedlist 
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //arrange in Zigzag Structure
        Node nextl,nextr;
        while(left!=null && prev!=null){
            nextl=left.next;
            left.next=prev;
            nextr=prev.next;
            prev.next=nextl;
            //move forward no need this instruction left=left.next;
            left=nextl;
            prev=nextr;
        }
    }
    public void deleteValue(int value){
        if(head==null){
            return;
        }
        Node curr=head;
        Node prev=null;
        while(curr!=null){
           if(head.data==value){
                curr=curr.next;
                prev=null;
                head=curr;
           }
           else{
            if(curr.data==value){
                prev.next=curr.next;
            }
            prev=curr;
            curr=curr.next;
           }
        }
   }
    public void rotate(int k){
        while(k>0){
                Node temp=head;
            while(temp!=null){
                if(temp.next.next==null){
                    break;
                }
                 temp=temp.next;
            }
            Node prev=temp.next;
            temp.next=null;
            prev.next=head;
            head=prev;
            k=k-1;
        }
    }
    public boolean detectCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;// Cycle is exists
            }
        }
        return false;
    }
    public void removeCycle(){
        Node slow = head;
        Node fast = head;
        int flag=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                flag=1;
                break;
            }    
        }
        if(flag>0){
            Node prev=null;
            while(slow!=fast){
                prev=fast;
                fast=fast.next;
                slow=slow.next;
               
            }
            prev.next=null;
        }
    }
    public static Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                 return slow;
            }    
        }
    
        return null;
    }
    public Node getIntersectionNode(Node headA, Node headB) {
        Node left=headA;
        while(left!=null){
            Node right=headB;
            while(right!=null){
                if(right==left)return right;
                right=right.next;
            }
            left=left.next;
        }
        return null;
    }
    public Node removeList(int data){
        while(head!=null && head.data==data){
            head=head.next;
        }
            Node temp=head;
        while(temp!=null){
            if(temp.next!=null&& temp.next.data==data){
                temp.next=temp.next.next;
                continue;
            }
            temp=temp.next;
        }
        return head;
    }
    public static Node DeleteNodesAfteNodes(Node head,int n,int m){
        if(head==null || head.next==null) return head;
        Node temp=head;
        while(m-1>0){
            temp=temp.next;
            if(temp==null){
                System.out.println("length of LinkedList is Less than m");
                return head;
            }
            m--;
        }
        Node x=temp;
        while(n>0){
            x=temp.next;
            if(x==null){
                System.out.println("The Length of Linkedlist is less than M+N");
                return head;
            }
        }
        temp.next=x;
        return head;

    }
    public void swapNodes(Node head ,int x,int y){
        if(x==y)return;
    
    }
    public Node partitionList(int x){
        if(head ==null || head.next==null){
            return head;
        }
        Node slow=head;
        Node fast=head;
        while(slow!=null){
                if(slow.next.data<x){
                    Node prev=slow.next;
                    slow.next=slow.next.next;
                    prev.next=fast.next;
                    fast.next=prev;
                    fast=fast.next;
                }
                slow=slow.next;
        }
        return head;
    }
    public static Node swapNode(Node head){
        if(head==null || head.next==null) return head;
        Node temp=head.next;
        Node prev=head;
        boolean flag=false;
        while(temp!=null || prev!=null){
            if(!flag){
                head=temp;
                head.next=prev;
            }
            else{
                head.next=temp;
                head.next.next=prev;
            }
            temp=temp.next.next;
            prev=prev.next.next;
        }
        return head;
    }
    public static Node removeZeroSumSublists(Node head) {
        if(head==null)return head;
        Node dummy=new Node(0);
        dummy.next=head;
        Node prev=dummy;
        head=head.next;
        while(head!=null){
            if((prev.next.data+head.data)==0){
                prev.next=null;
            }
            else if(prev.next==null)prev.next=head;
           else{
            prev=prev.next;
            prev.next=head;
           }
            head=head.next;
        }
        return dummy.next;
    }
    public static Node rotate(Node head,int k){
        while(k>0){
            Node prev=head;
            while(prev.next.next!=null){
                prev=prev.next;
            }
            prev.next.next=head;
            head=prev.next;
            prev.next=null;
            k--;
        }
        return head;
    }
    public void clear(){
        head.next=null;
        head=null;
    }
    public static void main(String[] args) {
        LinkedList ls=new LinkedList();
        //1,4,3,2,5,2
       ls.addEnd(1);
       ls.addEnd(2);
       ls.addEnd(-3);
       ls.addEnd(3);
       ls.addEnd(1);
       //ls.addEnd(2);
      // head=swapNode(head);
       //System.out.println(head.data);
        //ls.display();
        //ls.display();
        // ls.zigZag(head);
        //System.out.println();
        // head=ls.partitionList(3);
        ls.display();
        head=removeZeroSumSublists(head);
        System.out.println();
        ls.display();
    }

}   