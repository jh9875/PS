문자열 반복
===

문제 링크 : https://www.acmicpc.net/problem/2675

<br>

### 풀이

문자열을 반복해서 출력하는 기본적인 문제이다.

문자열을 반복문으로 돌면서 문제의 입력으로 받은 R번 만큼 반복하면서 출력하면 된다.

여기서 파이썬에서 사용할 수 있는 팁은 str과 int를 곱하면 str이 int 수 만큼 반복된다는 것이다.

```Python
def print_string_repeatedly(r: int, s: str):
    result = list()

    for ch in s:
        result.append(ch * r)

    return ''.join(result)
```