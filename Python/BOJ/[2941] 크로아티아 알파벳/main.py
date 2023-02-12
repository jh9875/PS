def get_croatia_alphabet_number(english_word: str):
    result = 0
    index = 0
    length = len(english_word)

    while index < length:
        if english_word[index] == 'c' and index + 1 < length:
            if english_word[index + 1] == '=' or english_word[index + 1] == '-':
                index += 1
        elif english_word[index] == 'd':
            if index + 1 < length and english_word[index + 1] == '-':
                index += 1
            elif index + 2 < length and english_word[index + 1] == 'z' and english_word[index + 2] == '=':
                index += 2
        elif english_word[index] == 'l' and index + 1 < length and english_word[index + 1] == 'j':
            index += 1
        elif english_word[index] == 'n' and index + 1 < length and english_word[index + 1] == 'j':
            index += 1
        elif english_word[index] == 's' and index + 1 < length and english_word[index + 1] == '=':
            index += 1
        elif english_word[index] == 'z' and index + 1 < length and english_word[index + 1] == '=':
            index += 1

        index += 1
        result += 1

    return str(result)


if __name__ == '__main__':
    word = input()
    croatia_alphabet_count = get_croatia_alphabet_number(word)
    print(croatia_alphabet_count)
