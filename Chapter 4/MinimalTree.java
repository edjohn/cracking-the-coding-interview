class MinimalTree 
{
    public BinaryNode createMinimalTree(int[] sortedArr)
    {
        return createMinimalTree(sortedArr, 0, sortedArr.length-1);

    }

    public BinaryNode createMinimalTree(int[] sortedArr, int start, int end)
    {
        if (end < start)
        {
            return null;
        }
        int middle = (start + end) / 2;
        BinaryNode node = new BinaryNode(sortedArr[middle]);
        node.left = createMinimalTree(sortedArr, start, middle - 1);
        node.right = createMinimalTree(sortedArr, middle + 1, end);

        return node;
    }

    public static void printTree(BinaryNode root)
    {
        if (root != null)
        {
            System.out.printf("Root is %d, ", root.data);
            if (root.left != null)
            {
                System.out.printf("Left branch is %d, ", root.left.data);
            }
            if (root.right != null)
            {
                System.out.printf("Right branch is %d.", root.right.data);
            }
            System.out.printf("\n");
            printTree(root.left);
            printTree(root.right);
        }
    }
}
