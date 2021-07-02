boolean isOneAway(String original_string, target_string)
{
    if (original_string.length() == target_string.length())
    {
        return isOneReplaceAway(original_string, target_string);
    }
    if (original_string.length() == target_string.length() - 1)
    {
        return isOneInsertOrRemoveAway(original_string, target_string);
    }
    if (original_string.length() == target_string.length() + 1)
    {
        return isOneInsertOrRemoveAway(target_string, original_string);
    }
    return false;
}

boolean isOneReplaceAway(String original_string, target_string)
{
    boolean found_difference = false;
    for (int i = 0; i < original_string.length(); i++)
    {
        if (original_string.charAt(i) != target_string.charAt(i))
        {
            if (found_difference)
            {
                return false;
            }
            found_difference = true;
        }
    }
    return true;
}

boolean isOneInsertOrRemoveAway(String shorter_string, longer_string)
{
    int shorter_string_pointer = 0;
    int longer_string_pointer = 0;
    while (shorter_string_pointer < shorter_string.length() && longer_string_pointer < longer_string.length())
    {
        if (shorter_string.charAt(i) != longer_string.charAt(i))
        {
            if (shorter_string_pointer != longer_string_pointer)
            {
                return false;
            }
            shorter_string_pointer++;
        }
        else
        {
            shorter_string_pointer++;
            longer_string_pointer++;
        }
    }
}
