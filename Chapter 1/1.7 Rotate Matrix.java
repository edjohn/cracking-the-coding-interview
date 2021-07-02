void rotateMatrix(int[][] matrix)
{
    int size = matrix.length;
    for (int layer = 0; layer < size / 2; layer++)
    {
        int first = layer;
        int last = size - 1 - layer;
        for (int i = first; i < last; i++)
        {
            int offset = i - first;
            int top = matrix[first][i];

            // top = left
            matrix[first][i] = matrix[last - offset][first];

            // left = bottom
            matrix[last-offset][first] = matrix[last][last - offset];

            // bottom = right
            matrix[last][last - offset] = matrix[first + offset][last];

            // right = top
            matrix[first + offset][last] = top;
        }
    }
}

void print_matrix(int[][] matrix)
{
    int size = matrix.length;

    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            System.out.printf("%d  ", matrix[i][j]);
        }
        System.out.println("\n");
    }
}

int[][] create_test_matrix(int size)
{
    int[][] test_matrix = new int[size][size];

    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            test_matrix[i][j] = i;
        }
    }

    return test_matrix;
}