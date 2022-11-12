알파벳 찾기
===

문제 링크 : https://www.acmicpc.net/problem/10809

<br>

### 풀이

처음엔 문자를 받고 java의 indexof같은거랄 사용해서 찾으려는 생각을 했다.

python에는 find와 index라는 문자열 함수가 있었다.

둘 다 해당 문자열을 위치를 찾아주는 역할을 하는데 차이는 find는 해당 문자가 없을 경우 -1을 리턴하고, index는 에러를 발생시킨다.

그래서 문제에 적합한 find를 사용했고 문제를 풀었다.

```Python
from string import ascii_lowercase

ans = []
alphabet_list = list(ascii_lowercase)
word = input()

for alphabet in alphabet_list:
    ans.append(word.find(alphabet))

print(' '.join(map(str, ans)))

```

이렇게 하고 체출했는데 문제 시간이 생각보다 오래걸렸다.. 어디가 문제일까.?

그래서 다시 풀어봤다.

```Python
ans = []
start, end = ord('a'), ord('z')
word = input()

for i in range(start, end + 1):
    ans.append(word.find(chr(i)))

print(' '.join(map(str, ans)))

```

이렇게 풀었는데 시간이 나름 빠르게 나왔다.

흠.. ascii_lowercase라는 함수에서 시간이 걸린건지..