public boolean checkPalindromePermutation(String string)
{
    int ascii_character_count = 128;
    int[] letters = new int[ascii_character_count];
    String lowercase_string = string.toLowerCase();

    for (int i = 0; i < string.length(); i++)
    {
        char letter = lowercase_string.charAt(i);
        if (letter == ' ')
        {
            continue;
        }
        letters[letter]++;
    }

    int odd_count = 0;
    for (int i = 0; i < ascii_character_count; i++)
    {
        if (letters[i] % 2 != 0)
        {
            odd_count += 1;
        }
        if (odd_count > 1)
        {
            return false;
        }
    }
    return true;
}