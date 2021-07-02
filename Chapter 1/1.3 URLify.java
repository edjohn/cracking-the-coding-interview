void convertToUrl(char[] string, int length)
{
    int space_count = countOfChar(string, ' ');
    int url_index = length - 1 + spaceCount * 2;

    for (int original_string_index = length - 1; original_string_index >= 0; original_string_index--)
    {
        if (string[original_string_index] == ' ')
        {
            string[url_index] = '0';
            string[url_index-1] = '2';
            string[url_index-2] = '%';
            url_index -= 3;
        }
        else
        {
            string[url_index] = string[original_string_index];
            url_index--;
        }
    }
}


int countOfChar(int target, char[] string)
{
    int count = 0;
    for (int i = 0; i < string.length; i++)
    {
        if (string[i] == target)
        {
            count++;
        }
    }
    return count;
}