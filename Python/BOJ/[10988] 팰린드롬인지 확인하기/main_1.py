def is_palindrome(word: str):
    result = 1
    word_len = len(word)
    for i in range(word_len // 2):
        if word[i] != word[word_len - 1 - i]:
            result = 0
            break

    return result


input_word = input()
print(is_palindrome(input_word))
