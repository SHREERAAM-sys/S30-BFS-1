/**

    L.c: 102. Binary Tree Level Order Traversal

    Approach: BFS - Breadth first search with DFS -depth first search

    Working:
        declare a resultant list of list

        traverse through the tree in dfs(root, level)
            check if root is null
                return;
            check if the list contained the level index arraylist
                if not create an ArrayList and add it to resultant
                add the value to the list
            dfs(root.left, level+1)
            dfs(root.right, level+1)
        return the result //which contains the BFS traversal of the tree


    Time Complexity: O(n)
    Space Complexity: O(h)
 */

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
class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if( root == null) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        dfs(root,0);

        return result;
    }

    private void dfs(TreeNode root, int level) {


        if(root == null){
            return;
        }

        if(level == result.size()) {
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
        }
        result.get(level).add(root.val);

        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }

}