import java.util.*;
public class Add_one_row_at_depth {
     static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            public TreeNode(int val) {
                this.val = val;
               left =null;right=null;
            }
        }
       public static void preOrder(TreeNode root){
        if(root==null)return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
       }
       
       public static TreeNode dfs(TreeNode root,int val,int depth,int curr){
        
            if(root==null)return null;
            if(curr==depth-1){
                
                TreeNode lTemp = root.left;
                TreeNode rTemp = root.right;

                root.left = new TreeNode(val);
                root.right = new TreeNode(val);
                root.left.left = lTemp;
                root.right.right = rTemp;
        
                
                return root;
            }
            root.left=dfs(root.left, val, depth, curr+1);
            root.right=dfs(root.right, val, depth, curr+1);
            return root;

       }
       
        public static   TreeNode addOneRow(TreeNode root, int val, int depth) {
            if(root==null)return new TreeNode(val);
            if(depth==1){
                TreeNode newroot=new TreeNode(val);
                newroot.left=root; 
            }
            
            return dfs(root, val,depth,1);


        }
       
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(4);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(9);
        System.out.println("PreOrder");
        //preOrder(root);

        root=addOneRow(root, 6, 2);
        preOrder(root);
        System.out.println("compliation is sucessful");
    }
}
