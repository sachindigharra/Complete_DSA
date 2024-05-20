//import java.util.*;
public class Avltree {
     static class Node {
        int item, height;
        Node left, right;
      
        Node(int d) {
          item = d;
          height = 1;
        }
      } 
      static Node root;
        static int height(Node N) {
         if (N == null)
           return 0;
         return N.height;
       }
    // public static int height(Node node){
    //     if(node==null)return 0;
    //     int hl= height(node.left);
    //     int hr=height(node.right);
    //     return Math.max(hl,hr)+1;
    // }
    public static Node rightRotate(Node y){
        Node x=y.left;
        Node t=x.right;
        x.right=y;
        y.left=t;
        y.height=max(height(y.left),height(y.right))+1;
        x.height=max(height(x.left),height(x.right))+1;
        return x;
    }
    private static int max(int a,int b) {
        return a>b?a:b;
    }
    public static Node leftRotate(Node x){
        Node y=x.right;
        Node t=y.left;
        y.left=x;
        y.right=t;
        y.height=max(height(y.left),height(y.right))+1;
        x.height=max(height(x.left),height(x.right))+1;
        return y;
    }
    
     public static void main(String[] args) {
        Node r=new Node(0);
        r.left=new Node(2);
        r.right=new Node(3);
        r.left.left=new Node(1);
        System.out.println(height(r));
     } 
}
