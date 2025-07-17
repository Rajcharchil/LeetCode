/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
  private int postIdx;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
            postIdx = postorder.length - 1;
            inorderMap = new HashMap<>();
                for (int i = 0; i < inorder.length; i++)
                    inorderMap.put(inorder[i], i);

                    return build(postorder, 0, inorder.length - 1);
            }
            
    private TreeNode build(int[] post, int inStart, int inEnd) {
                if (inStart > inEnd) return null;
                int rootVal = post[postIdx--];
                TreeNode root = new TreeNode(rootVal);
                int idx = inorderMap.get(rootVal);

                root.right = build(post, idx + 1, inEnd); 
                root.left = build(post, inStart, idx - 1);
                return root;

         }
}
