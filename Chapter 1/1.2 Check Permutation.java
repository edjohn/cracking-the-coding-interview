public Boolean isPermutation(String original_string, String comparison_phrase)
{
    if (original_string.length() != comparison_phrase.length())
    {
        return false;
    }

    int ascii_character_count = 128;
    int[] letter_frequencies = new int[ascii_character_count];
    for (int i = 0; i < original_string.length(); i++)
    {
        letter_frequencies[original_string.charAt(i)]++;
    }
    for (int i = 0; i < comparison_string.length(); i++)
    {
        letter_frequencies[comparison_string.charAt(i)]--;
        if (letter_frequencies[comparison_string.charAt(i)] < 0)
        {
            return false;
        }
    }
    return true;
}