import java.util.*;
public class BinarySearchTree {
        static TreeNode root;
    static class TreeNode{
        
		TreeNode left,right;
		int data;
		TreeNode(int d){this.data = d;}
	}
	public static int  maxBSt=0;
	public static TreeNode insert(TreeNode root , int val) {
		if (root == null) {
			root = new TreeNode(val);
			return root;
		}	
		
		else if (root.data > val) {
			root.left = insert(root.left, val);
		}
		else {
			root.right = insert(root.right, val);
		}
		
		return root;
	}
        public static void inOrder(TreeNode root){
            if(root==null)return;
            inOrder(root.left);
            System.out.print(root.data);
            inOrder(root.right);
        }
        public static List<Integer>inOrderStack(TreeNode root){
            List<Integer> ls=new ArrayList<>();
            Stack<TreeNode>s=new Stack<>();
           if(root==null)return ls;
           s.push(root);
           TreeNode curr=root;
           while(!s.isEmpty() ||curr!=null){
                while(curr!=null){
                    s.push(curr.left);
                }
                curr=s.pop();
                int temp=curr.data;
                ls.add(temp);
                curr=curr.right;
           }
           return ls;
            
        }
        public static boolean isPresent(TreeNode node){
            if(root==null)return false;
            if(root!=null&& node.data==root.data)return true;
            if(root.data>node.data){
                isPresent(node.left);
            }
            else{
                isPresent(node.right);
            }
            return false;
        }
        public static boolean isBinarySearchTree(TreeNode root){
            if(root==null)return true;
            if(root.left!=null && root.data<root.left.data)return false;
            if(root.right!=null && root.data>root.right.data)return false;
            isBinarySearchTree(root.left);
            isBinarySearchTree(root.right);
            return true;
            
        }
        public static TreeNode deleteNode(TreeNode root,int val){
            if(root.data<val){
                //update right subtree
                root.right=deleteNode(root.right, val);
            }
            else if(root.data>val){
                //update left subtree
               root.left=deleteNode(root.left, val);
            }
            else{
                // case-1 no child
                if(root.left==null && root.right==null){
                    return null;
                }
                // case-2 Single child 
                 if(root.left==null){
                    return root.right;
                }
                else if(root.right==null){
                    return root.left;
                }
                //case-3 Two children
                TreeNode temp= findInoderSucessor(root.right);
                root.data=temp.data; 
                root.right=deleteNode(root.right, temp.data);
            }
            return root;
        }
        public static TreeNode findInoderSucessor(TreeNode root){
          while(root.left!=null){
            root=root.left;
          }
          return root;
        }
        public static void printRange(TreeNode root,int k1,int k2){
            if(root==null)return;
            if(root.data >=k1 && root.data<= k2){
                printRange(root.left, k1, k2);
                System.out.print(root.data);
                printRange(root.right, k1, k2);
            }
            else if(root.data<k1){
                printRange(root.left, k1, k2);
            }
            
            else{
                printRange(root.right, k1, k2);
            }
            
        }
        static TreeNode createMirror(TreeNode root){
            if(root==null){
                return null;
            }
            TreeNode lefts=createMirror(root.left);
            TreeNode rights=createMirror(root.right);
            root.left=rights;
            root.right=lefts;
            return root;
        }
        public static void pathToLeaf(TreeNode root,ArrayList<Integer>path){
            if(root==null)return;
            path.add(root.data);
            if(root.left==null && root.right==null){
                for(int i=0;i<path.size();i++){
                    System.out.print(path.get(i));
                }
            }
            pathToLeaf(root.left,path);
            pathToLeaf(root.right, path);
            path.remove(path.size()-1);
        }
        public static boolean isValidBST(TreeNode root,TreeNode min,TreeNode max){
            if(root==null){
                return true;
            }
            //right subtree
            if(min!=null && root.data<=min.data){
                return false;
            }
            if(max!=null && root.data>=max.data){
                return false;
            }
            return isValidBST(root.left, min, root) && isValidBST(root.right,root, max);
        }
        public static TreeNode createBST(int[]nums,int st,int end){
            if(st>end){
                return null;
            }
            int mid=(st+end)/2;
            // Mid of array(root Node for each tree)
            TreeNode  root=new TreeNode(nums[mid]);
            // Left subtree
            root.left=createBST(nums,st,mid-1);
            //Right subtree
            root.right=createBST(nums,mid+1,end); 
    
            return root;
        }
        
        static class Info{
            boolean isBst;
            int min;
            int max;
            int size;
            public Info(boolean isBst,int min,int max,int size){
                this.isBst=isBst;
                this.min=min;
                this.max=max;
                this.size=size;
            }
        }
    public static Info largestBST(TreeNode root){
        if(root==null){
            return new Info(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        Info leftbst=largestBST(root.left);
        Info rightbst=largestBST(root.right);
        int size=leftbst.size+rightbst.size+1;
        int min=Math.min(root.data,Math.min(leftbst.min,rightbst.min));
        int max=Math.max(root.data,Math.max(leftbst.max,rightbst.max));
        // check is Node is vaild for bst
        if(root.data<=leftbst.max || root.data>=rightbst.min){
            return new Info(false,min,max,size);
        }
        //check subtree is bst
        if(leftbst.isBst &&rightbst.isBst ){
             maxBSt= Math.max(size,maxBSt);
            return  new Info(true,min,max,size);
        }
        //neither is Node is Valid or subtree for bst
         return new Info(false,min,max,size);
    }

    public static void main(String[] args) {
        int[] arr = {5,1,3,4,2,7};
		TreeNode r = null;
		for (int i = 0; i < arr.length; i++) {
			r = insert(r, arr[i]);
           root = r;
		}
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(9);
        //inOrder(r);
       // r=new TreeNode(2);
      // System.out.println(isPresent(root));
      //System.out.println(inOrderStack(r));
     //System.out.println( isBinarySearchTree(r));
    //  TreeNode temp =deleteNode(root, 4);
    //printRange(root, 4, 7);
    // inOrder(root);
    // System.out.println();
    //  inOrder(createMirror(root));  
     System.out.println();
        largestBST(root);
        System.out.println(maxBSt);
        System.out.println(isValidBST(root, null, null));
    }
}
