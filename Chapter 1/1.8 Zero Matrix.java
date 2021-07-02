public void zeroMatrix(int[][] matrix)
{
    int row_size = matrix.length;
    if (row_size == 0)
    {
        return;
    }
    int column_size = matrix[0].length;
    ArrayList<Integer> zero_rows = new ArrayList<Integer>();
    ArrayList<Integer> zero_columns = new ArrayList<Integer>();

    for (int i = 0; i < row_size; i++)
    {
        for (int j = 0; j < column_size; j++)
        {
            if (matrix[i][j] == 0)
            {
                zero_rows.add(i);
                zero_columns.add(j);
            }
        }
    }

    for (int row_index : zero_rows)
    {
        for (int i = 0; i < column_size; i++)
        {
            matrix[row_index][i] = 0;
        }
    }

    for (int column_index : zero_columns)
    {
        for (int i = 0; i < row_size; i++)
        {
            matrix[i][column_index] = 0;
        }
    }
}