public class Sum_root_to_leaf {
    static int Ans=0;
    static class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;
        public TreeNode(int val){
            this.val=val;
            left=null;
            right=null;
        }
    }
  
    public static void sumOfNode(TreeNode root,int[] a){
        if(root==null)return;
        if(root.left==null && root.right==null){
           a[0]+=root.val;
           Ans+=a[0];
           a[0]-=root.val;
           return;
        }
        a[0]+=root.val;
        a[0]*=10;
        sumOfNode(root.left, a);
        sumOfNode(root.right, a);
        a[0]/=10;
        a[0]-=root.val;
    }
    public static int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        
        int[]a={0};
        sumOfNode(root,a);
        return Ans;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(4);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(9);
        System.out.println(sumNumbers(root));
        
    }
}
