크로아티아 알파벳
===

문제 링크 : https://www.acmicpc.net/problem/2941

<br>

### 풀이

단어가 입력으로 주어졌을 때 크로아티아 알파벳에 맞춰서 알파벳 수를 세면 된다.

약간의 노가다를 해야한다.

다음과 같이 if elif 문으로 해결해봤다.

```Python
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
```