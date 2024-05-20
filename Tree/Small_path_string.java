public class Small_path_string {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
           left =null;right=null;
        }
    }
  
    private static void dfs(TreeNode root,StringBuilder path,StringBuilder smallest){{
        if(root==null)return ;
        path.append((char)('a'+root.val));
        if(root.left==null && root.right==null){
            String curr=path.reverse().toString();
            // curr smaller than smallest string change by curr String
            if(smallest.length()==0 || curr.compareTo(smallest.toString())<0){
                smallest.setLength(0);
                smallest.append(curr);
            }
            path.reverse();
        }
        dfs(root.left, path,smallest);
        
       dfs(root.right, path,smallest);
       // delete last character
       path.setLength(path.length()-1);
        
    }
       
    }
    public static String smallestFromLeaf(TreeNode root) {
        if(root==null)return "";
       StringBuilder smallestStr = new StringBuilder();
       dfs(root, new StringBuilder(),smallestStr);
       return smallestStr.toString();
    }


    
    public static void main(String[] args) {
        TreeNode root=new TreeNode(25);
        root.left=new TreeNode(1);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(1);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(1);
        System.out.println(smallestFromLeaf(root));

    }
    
}
