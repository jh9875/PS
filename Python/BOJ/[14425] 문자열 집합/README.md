문자열 집합
===

문제 링크 : https://www.acmicpc.net/problem/114425

<br>

### 풀이

처음엔 그냥 생각나는대로 풀어봤다.

N개의 문자열 만큼 저장해 둔 다음 M개의 문자열들이 있는지 확인하는 방법이었다.

```Python
import sys

word_list = []

ans = 0
N, M = map(int, sys.stdin.readline().rstrip().split())

for _ in range(N):
    word_list.append(sys.stdin.readline().rstrip())

for _ in range(M):
    word = sys.stdin.readline().rstrip()
    if word in word_list:
        ans += 1

print(ans)

```

근데.. 결과가 조금 이상하게 시간이 많이 걸렸다.. 무엇이 문젤까..

근데..? list를 set으로 바꾸기만 했는데 결과가 완전히 달라졌다. 시간이 거의 10배 이상 빨라진것이다.

```Python
import sys

word_set = set()

ans = 0
N, M = map(int, sys.stdin.readline().rstrip().split())

for _ in range(N):
    word_set.add(sys.stdin.readline().rstrip())

for _ in range(M):
    word = sys.stdin.readline().rstrip()
    if word in word_set:
        ans += 1

print(ans)

```

생각해보면 단순하다..

각 자료구조에서 원소를 찾는데 시간 복잡도를 생각해보면 쉬울것이다.

set의 경우 원소를 찾을 때 해시테이블 형태로 찾기 때문에 in을 이용해서 찾을 때 빨리 찾을 수 있다.

그래서 set의 시간 복잡도는 O(1) 이다.

반면 list의 경우 어떤 원소를 찾기 위해서 list를 모두 뒤져야 하기 때문에 N개의 원소가 있다면

시간 복잡도가 O(N)이 될것이다.

그러니... 당연히 set이 빠를 수 밖에..

컴퓨터 공학을 배우면 당연히 알아야 되는것을 몰랐다니..