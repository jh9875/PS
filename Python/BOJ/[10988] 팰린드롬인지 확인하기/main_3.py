def is_palindrome(word: str):
    reversed_word = ''.join(reversed(word))
    return 1 if word == reversed_word else 0


input_word = input()
print(is_palindrome(input_word))
