import java.util.*;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;
public class BinaryTreea {
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    static class BinaryTree{
        static int sum=0;
        static int temp=0;
        static int idx=-1;
        public static Node  bulidTree(int[]Nodes){
            idx++;
            if(idx==Nodes.length)return null;
            if( Nodes[idx]==-1){
                return null;
            }
            Node root=new Node(Nodes[idx]);
            root.left=bulidTree(Nodes);
            root.right=bulidTree(Nodes);
            return root;

        }
        public static void preorder(Node root){
            if(root==null) {System.out.print("-1 ");
            return;}
            System.out.print(root.data);
            preorder(root.left);
            preorder(root.right);
        }
        public static void inOrder(Node root){
            if(root==null){
                System.out.print("-1 ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data);
            inOrder(root.right);
        }
        //inorder traversal Using Stack 
        // public static List<Integer> inOrderStack(Node root){
        //     List<Integer>ls=new ArrayList<>();
        //     if(root==null)return ls;
        //     Stack<Node>s=new Stack<>();
        //     s.push(root);
        //     Node temp;
        //     while(!s.isEmpty()){
        //         temp=s.pop();
        //         if(temp.right!=null) s.push(temp.right);
        //         s.push(temp);
        //         if(temp.left!=null)s.push(temp.left);
        //         temp=s.pop();
        //         int val=temp.data;
        //         ls.add(val);
        //     }
        //     return ls; 
        // }
        public static List<Integer> preOrderStack(Node root){
           List<Integer> ls=new ArrayList<>();
            Stack<Node>s=new Stack<>();
           if(root==null)return ls;
           s.push(root);
           while(!s.isEmpty()){
                Node temp=s.pop();
                int val=temp.data;
                ls.add(val);
                if(temp.right!=null) s.push(temp.right);
                if(temp.left!=null)s.push(temp.left);            
           }
           return ls;
        }
        public static void postOrder(Node root){
            if(root==null){
                System.out.print("-1 ");
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data);
        }
        public static void insertLevel(Node root){
            Queue<Node>q=new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                Node temp=q.poll();
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                else{
                 
                }
            }
        }
        public static  List<List<Integer>> levelOrder(Node root){
            List<List<Integer>>ls=new LinkedList<>();
            if(root== null) return ls;
            Queue<Node> q=new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                List<Integer>temp=new LinkedList<>();
               
                int level=q.size();
                for(int i=0;i<level;i++){
                    if(q.peek().left!=null){
                        q.add(q.peek().left);
                    }
                    if(q.peek().right!=null){
                        q.add(q.peek().right);
                    }
                    temp.add(q.remove().data);
                }
                ls.add(temp);
            }
            return ls;
            
        }
        public static boolean isBalaencentree(Node root){
            if(root==null)return true;
            if(root.left==null && root.right==null) return true;
            int lh=height(root.left);
            int rh=height(root.right);
            lh=lh-rh;
            return 1>=Math.abs(lh);

        }
        public static int height(Node root){
            if(root==null)return 0;
            int hl= height(root.left);
            int hr=height(root.right);
            return Math.max(hl,hr)+1;
        }
        public static int numberOfNodes(Node root){
            if(root==null){
                return 0;
            }
            int nl=numberOfNodes(root.left);
            int nr=numberOfNodes(root.right);
            return(nl+nr+1);
        }
        public static boolean hasPathSum(Node root, int target) {
           if(root==null)return false;
           if(root.left==null &&root.right==null &&root.data==target)return true;
           return hasPathSum(root.left, target-root.data) ||hasPathSum(root.right, target-root.data);
        }
        // O(n^2)complexity
        public static int diameter(Node root){
            if(root==null)return 0;
            int hl=height(root.left);
            int hr=height(root.right);
            int dl=diameter(root.left);
            int dr=diameter(root.right);
            int selfd=hl+hr+1;
            return Math.max( selfd,Math.max(dl,dr));
        }

        static class Info{
            int h;
            int dia;
            public Info(int dia,int h){
                this.h=h;
                this.dia=dia;
            }
        }
        public static Info diameter1(Node root){
            // In this method height and diameter both calculated simanteanously
            //Complexity is O(n)
            if(root==null)return new Info(0,0);
            Info leftInfo=diameter1(root.left);
            Info rightInfo=diameter1(root.right);
            int dia=Math.max(Math.max(leftInfo.dia,rightInfo.dia),leftInfo.h + rightInfo.h + 1);
            int h=Math.max(leftInfo.h,rightInfo.h)+ 1;
            return  new Info(dia,h);
        }
        public static boolean isSubTree(Node root,Node subroot){
            if(root==null)return false;
            if(root.data==subroot.data){
                if(isIdentical(root, subroot))return true;
            }
            return isIdentical(root.left, subroot)||isIdentical(root.right, subroot);
        }
        static boolean isIdentical(Node root,Node Subroot){
            if(root==null && Subroot==null)return true;

            else if(root==null || Subroot==null || root.data!=Subroot.data){return false;}

             if (!isIdentical(root.left,Subroot.left))return false;
             if(!isIdentical(root.right, Subroot.right))return false;

             return true;
        }
        static void inorderIterative(Node root){
            if(root==null)return;
            Stack<Node>s=new Stack<>();
            Node curr=root;
            while (curr != null || s.size() > 0){
                while (curr !=  null)
                {
                    /* place pointer to a tree node on
                       the stack before traversing
                      the node's left subtree */
                    s.push(curr);
                    curr = curr.left;
                }
     
                /* Current must be NULL at this point */
                curr = s.pop();
     
                System.out.print(curr.data + " ");
     
                /* we have visited the node and its
                   left subtree.  Now, it's right
                   subtree's turn */
                curr = curr.right;
            }
        }
        
        static boolean isFullBinary(Node root){
            if(root==null)return true;
            if(root.left==null && root.right==null)
                return true;
            if(root.left!=null&&root.right!=null)
                return isBalaencentree(root.left) && isBalaencentree(root.right);
            return false;
        }
        static void KLevel(Node root,int level,int k){
        if(root==null)return;
        if(level==k){
            System.out.print(root.data);
            return;
        }
        KLevel(root.left,level+1,k);
        KLevel(root.right,level+1,k);
    }
     static boolean getPath(Node root,int n,ArrayList<Node>path){
        if(root==null)return false;
        path.add(root);
        if(root.data==n)return true;


        boolean leftres=getPath(root.left, n, path);

        boolean rightres=getPath(root.right, n, path);

        if(leftres || rightres)return true;

        path.remove(path.size()-1);

        return false;
    }
    public static Node lowestCommonAccentor(Node root,int n1,int n2){
        if(root==null)return null;

        

        ArrayList<Node>path1=new ArrayList<>();

        ArrayList<Node>path2=new ArrayList<>();

        getPath(root,n1,path1);

        getPath(root,n2,path2);

        int i=0;
        while(i<path1.size()&& i<path2.size()){
                if(path1.get(i)!=path2.get(i))break;
                i++;
        }
        return path1.get(i-1);


    }
    
    // static class Exobj{
    //     Node node;
    //      static int hd;
    //     public Exobj(Node node,int hd){
    //         this.node=node;
    //         this.hd=hd;
    //     }
    // }
    // public static void topVeiw(Node root){
    //     List<Integer>ls=new LinkedList<>();
    //     if(root==null)return;
    //     int max=0,min=0; 
    //     Queue<Exobj>q=new LinkedList<>();
    //     HashMap<Integer,Node>map=new HashMap<>(); 
    //     q.add(new Exobj(root,0));
    //     q.add(null);
    //     while(!q.isEmpty()){
    //        Exobj currNode=q.remove();
    //         if(currNode==null){
    //             System.out.println();
    //             if(q.isEmpty())break;
    //             else{
    //                 q.add(null);
    //             }
            
    //        }
    //        else{
    //             if(!map.containsKey(Exobj.hd)){
    //                 map.put(currNode.hd,currNode.node );
    //             }
    //             if(currNode.node.left!=null){
    //                 q.add(new Exobj(currNode.node, currNode.hd-1));
    //                 min=Math.min(min,Exobj.hd-1);
    //             }
    //             if(currNode.node.left!=null){
    //                 q.add(new Exobj(currNode.node, currNode.hd+1));
    //                 max=Math.max(max,Exobj.hd+1); 
    //             }
    //         }
    //     }
    //     for(int i=min;i<=max;i++){
           
    //     }

    // }
        static Node lCA2(Node root,int n1,int n2){
            if(root==null)return null;

            if(root.data==n1 ||root.data==n2){

                    return root;
            }
            Node leftlca=lCA2( root.left, n1, n2);

            Node rightlca=lCA2( root.right, n1, n2);

            if(rightlca==null)return leftlca;

            if(leftlca==null)return rightlca;

            return root;


        }
        static int distanceLca(Node root,int n){
            if(root==null){
                return-1;
            }
            if(root.data==n){
                return 0;
            }
            int leftdis=distanceLca(root.left, n);
            int rightdis=distanceLca(root.right, n);
            if(leftdis==-1 && rightdis==-1)return -1;
            else if(leftdis==-1){
                return rightdis+1;
            }
            
                return leftdis+1;
        }

        public static int distancebtwNode(Node root,int n1,int n2){
                if(root==null)return -1;

                Node lca=lCA2(root, n1, n2);

                int disn1=distanceLca(lca, n1);

                int disn2=distanceLca(lca, n2);
            
                return disn1+disn2;
        }
        public static int kThAncenstorNode(Node root,int n1,int k){
            if(root==null){
                return -1;
            }
            if(root.data==n1){
                return 0;
            }
            int ldis=kThAncenstorNode(root.left, n1, k);
            int rdis=kThAncenstorNode(root.right, n1, k);
            if(ldis==-1 && rdis==-1){
                return -1;

            }
            int Max=Math.max(ldis, rdis);
            if(Max+1==k){
                System.out.println(root.data);
            }
            return Max+1;
        }
         public static int maxPathSum(Node root) {
            if(root==null){
            return -1;
            }
            int[]dp={0};
            dp[0]=getPathSum(root,dp[0]);
            return dp[0];
        }
        public static int getPathSum(Node root,int x){
            if(root==null){
                return 0;
            }
            int lefts=getPathSum(root.left, x);
            int rights=getPathSum(root.right, x);
            x=Math.max(x,Math.max(lefts,rights))+root.data;
            return x;
        }
        public static int  treeOfSumNode(Node root){
                if(root==null){
                    return 0;
                }
                int Newleft=root.left== null ?0:root.left.data;
                int Newright=root.right== null ? 0:root.right.data;
                int leftSum=treeOfSumNode(root.left);
                int rightsum=treeOfSumNode(root.right);
                int data=root.data;
                root.data=Newleft+leftSum+Newright+rightsum;
                return data;
        }
        public static List<Integer> traverseBoundary(Node root){
            List<Integer>ls=new ArrayList<>();
            if(root==null)return ls;
            ls.add(root.data);
            if(root.left==null && root.right==null){
                return ls;
            }
            leftExceedNode(root.left, ls);
            leafNode(root, ls);
            rightExceedNode(root.right, ls);
            return ls;
    
    
        }
        
         static void leftExceedNode(Node root,List<Integer> ls){
            // break condition
            if(root==null){
                return ;
            }
            if(root.left==null&& root.right==null){
                return;
            }
            ls.add(root.data);
            if(root.left==null){
                leftExceedNode(root.right, ls);
            }
            leftExceedNode(root.left, ls);
    
        }
         static void leafNode(Node root,List<Integer> ls){
            if(root==null){
                return ;
            }
            if(root.left==null && root.right==null){
                ls.add(root.data);
            }
            leafNode(root.left, ls);
            leafNode(root.right, ls);
        }
       static void rightExceedNode(Node root,List<Integer> ls){
            // break condition
            if(root==null){
                return ;
            }
            if(root.left==null&& root.right==null){
                return;
            }
            
            if(root.right==null){
                rightExceedNode(root.left, ls);
            }
            rightExceedNode(root.right, ls);
            ls.add(root.data);
        }
        static class VeiwOrder{
            Node root;
            int hd;
            int vd;
            VeiwOrder(Node root,int hd,int vd){
                this.root=root;
                this.hd=hd;
                this.vd=vd;
            }
            

        }
        static int val;
        static int pos=-1;
        static void left_Bottom(Node root,int l,int child){
            if(root==null){
                return;
            }
            if(root.left==null&& root.right==null &&child==0){
                if(pos<l){
                    val=root.data;
                    pos=l;
                }
                return ;
            }
           
             left_Bottom(root.left, l+1,0);
             left_Bottom(root.right, l+1, 1);
        }
        public static boolean even_oddTree(Node root){
            if(root.data%2==0) return false;;
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            int l=0;
            int prev=0;
            while(!q.isEmpty()){
               if(l%2!=0)prev = Integer.MAX_VALUE;
            else{
                prev = Integer.MIN_VALUE;
            }
                int level=q.size();
                for(int i=0;i<level;i++){
                    if(q.peek().left!=null){
                        q.add(q.peek().left);
                    }
                    if(q.peek().right!=null){
                        q.add(q.peek().right);
                    }
                    int temp=q.remove().data;
                    if(l%2==0){
                        if(prev>=temp || temp%2==0)return false;
                        else{
                            prev=temp;
                        }
                    }
                    else{
                        if(prev<=temp || temp%2!=0)return false;
                        else{
                            prev=temp;
                        }
                    }
                    
                }
                l++;
            }
            return true;
        }
        
        public static List<List<Integer>>verticalVeiw(Node root){
             List<List<Integer>>ls=new ArrayList<>();
                if(root==null){
                    return ls;
                }
                Queue<VeiwOrder> q=new LinkedList<>();
                TreeMap<Integer,TreeMap<Integer,PriorityQueue < Integer >>>map=new TreeMap < > ();
                q.offer(new VeiwOrder(root,0,0));
                while (!q.isEmpty()) {
                    VeiwOrder node=q.poll();
                    Node temp=node.root;
                    int x=node.hd;
                    int y=node.vd;
                    if(!map.containsKey(x)){
                        map.put(x, new TreeMap());
                    }
                    if(!map.get(x).containsKey(y)){
                        map.get(x).put(y,new PriorityQueue());
                    }
                    map.get(x).get(y).offer(root.data);
                    if(root.left!=null){
                        q.offer(new VeiwOrder(root.left, x-1,y+1));
                    }
                    if(root.right!=null){
                        q.offer(new VeiwOrder(root.right, x + 1, y + 1));
                    }
                }
                    for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
                            ls.add(new ArrayList < > ());
                            for (PriorityQueue < Integer > nodes: ys.values()) {
                                     while (!nodes.isEmpty()) {
                                        ls.get(ls.size() - 1).add(nodes.poll());
                                }
            
                            }
       
                    }
                    return ls;

        }
        
            

    }

    public static void main(String[] args) {
        /*           1
                /        \
                2         3 
            /     \    /     \ 
            4       5 6       7
        */
        int[]x={1,2,-1,-1,3,-1,-1};
        
        BinaryTree tree=new BinaryTree();
        Node k=tree.bulidTree(x);
        Node root=new Node(1);
        root.left=new Node(4);
        root.right=new Node(2);
        root.left.left=new Node(3);
        root.left.right=new Node(5);
        root.right.left=new Node(7);
        root.right.right=new Node(9);
        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);
        // Node temp=tree.lowestCommonAccentor(root, 4, 5);
        // System.out.println(temp.data);
        // int miniDis=tree.distancebtwNode(root, 4, 5);
        // System.out.println(miniDis);
        // int ans=tree.kThAncenstorNode(root, 4, 2);
        // System.out.println(ans);
        // List<Integer> ls=tree.traverseBoundary(root);
        // for(int i=0;i<ls.size();i++){
        //     System.out.println(ls.get(i));
        // }
        // List<List<Integer>> list=tree.verticalVeiw(root);
        // for(List<Integer>item:list){
        //     for(int val:item){
        //         System.out.print(val);
        //     }
        //     System.out.println();
        // }
        // tree.left_Bottom(root, 0, -1);
        //     System.out.println(tree.val);
        //     System.out.println(tree.even_oddTree(root));


        
        

        
    }

    
}
