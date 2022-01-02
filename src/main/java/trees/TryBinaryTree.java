package trees;
class TreeNode  
{ 
    int data; 
    TreeNode left, right; 
   
    TreeNode(int item)  
    { 
        data = item; 
        left = right = null; 
    } 
} 
public class TryBinaryTree  
{ 
    TreeNode root1, root2; 
   
    /* Given two trees, return true if they are 
       structurally identical */
    boolean identicalTrees(TreeNode a, TreeNode b)  
    { 
        /*1. both empty */
        if (a == null && b == null) 
            return true; 
              
        /* 2. both non-empty -> compare them */
        if (a != null && b != null)  
            return (a.data == b.data 
                    && identicalTrees(a.left, b.left) 
                    && identicalTrees(a.right, b.right)); 
   
        /* 3. one empty, one not -> false */
        return false; 
    } 
   
    /* Driver program to test identicalTrees() function */
    public static void main(String[] args)  
    { 
        TryBinaryTree tree = new TryBinaryTree(); 
   
        tree.root1 = new TreeNode(1); 
        tree.root1.left = new TreeNode(2); 
        tree.root1.right = new TreeNode(3); 
        tree.root1.left.left = new TreeNode(4); 
        tree.root1.left.right = new TreeNode(5); 
   
        tree.root2 = new TreeNode(1); 
        tree.root2.left = new TreeNode(2); 
        tree.root2.right = new TreeNode(3); 
        tree.root2.left.left = new TreeNode(4); 
        tree.root2.left.right = new TreeNode(5); 
   
        if (tree.identicalTrees(tree.root1, tree.root2)) 
            System.out.println("Both trees are identical"); 
        else
            System.out.println("Trees are not identical"); 
   
    } 
} 