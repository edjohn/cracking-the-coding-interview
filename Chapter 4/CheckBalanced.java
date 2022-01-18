class BalanceChecker {
    public boolean isBalanced(BinaryNode root)
    {
        if (root == null) return true;

        if (Math.abs(checkHeight(root.left) - checkHeight(root.right)) > 1)
        {
            return false;
        }
        else
        {
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }

    public int checkHeight(BinaryNode root)
    {
        if (root == null) return -1;
        return Math.max(checkHeight(root.left), checkHeight(root.right)) + 1;
    }
}
