class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // If root is null, or root is p/q
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in left and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If p and q are found on different sides
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side contains p or q
        if (left != null) {
            return left;
        }

        return right;
    }
}