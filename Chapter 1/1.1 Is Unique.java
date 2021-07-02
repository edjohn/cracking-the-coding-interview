boolean isUnique(String string)
{
    int ascii_character_count = 128;
    Boolean[] letterIsUsed = new Boolean[ascii_character_count];
    for (int i = 0; i < string.length(); i++)
    {
        letter = string.charAt(i);
        if (letterIsUsed[letter])
        {
            return false;
        }
        else
        {
            letterIsUsed[letter] = true;
        }
    }
    return true;
}