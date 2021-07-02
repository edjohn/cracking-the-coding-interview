public boolean isSubstringRotation(String original_phrase, String comparison_phrase)
{
    if (original_phrase.length() != comparison_phrase.length())
    {
        return false;
    }

    String extended_phrase = original_phrase + original_phrase;
    return isSubstring(comparison_phrase, extended_phrase);
}

public boolean isSubstring(String original_string, String target_string)
{
    return target_string.contains(original_string);
}