팰린드롬인지 확인하기
===

문제 링크 : https://www.acmicpc.net/problem/10988

<br>

### 풀이

문제 자체는 간단하다. 문자열이 뒤집어도 동일한지만 판단하면 되니까.

나는 가장 먼저 생각난 방법은 문자열의 인덱스를 검사하는 것이다.

처음 구현 했을 땐 다음과 같이 만들어봤다.

```Python
def is_palindrome(word: str):
    result = 1
    word_len = len(word)
    for i in range(word_len // 2):
        if word[i] != word[word_len - 1 - i]:
            result = 0
            break

    return result
```

문자열의 처음부터 반정도까지 대칭이 되는 문자가 동일한지 판단하고 결과에 따라 값을 반환한다.

여기서 장점은 문자열이 길어질수록 연산을 적게 할 수 있는 것 같다. (반밖에 검사 안하니까.)

그리고 파이썬에는 어떤 기능이 있는지 알아보려고 찾아봤다.

파이썬에는 리스트를 뒤집는 revered()라는 함수가 있는 것 같았다.

그리고 다음과 같이 만들어봤다.

```Python
def is_palindrome(word: str):
    reversed_word = ''.join(reversed(word))
    return 1 if word == reversed_word else 0
```

reversed는 리스트로 반환하기 때문에 join으로 문자열로 만들어줬다.