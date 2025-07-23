class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;  // Edge case: null root

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> current = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                
                // Always add the current node's value
                current.add(node.val); 

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(current);
        }

        return result;
    }
}
