String compressString(String string)
{
    StringBuilder compressed_string_builder = new StringBuilder();
    int stringLength = string.length();
    int current_letter_count = 0;
    for (int i = 0; i < stringLength; i++)
    {
        current_letter_count++;
        if (i + 1 >= stringLength || string.charAt(i) != string.charAt(i+1))
        {
            compressed_string_builder.append(string.charAt(i));
            compressed_string_builder.append(current_letter_count);
            current_letter_count = 0;
        }
    }
    return compressed_string_builder.length() < string.length() ? compressed_string_builder.toString() : string;
}