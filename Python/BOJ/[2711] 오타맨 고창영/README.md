오타맨 고창영
===

문제 링크 : https://www.acmicpc.net/problem/2711

<br>

### 풀이

문자열의 인덱스가 주어지고, 주어진 문자열에서 해당 인덱스에 있는 문자만 제거하고 출력하는 문제이다.

내가 사용한 방법은 주어진 문자열을 해당 인덱스를 제외한 두 부분으로 자르고 다시 붙이는 방법을 해봤다.

```Python
index_str, string = sys.stdin.readline().rstrip().split()
index = int(index_str) - 1

ans.append(string[0: index] + string[index + 1: len(string)])

```


