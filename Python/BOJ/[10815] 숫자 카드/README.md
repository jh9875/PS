숫자 카드
===

문제 링크 : https://www.acmicpc.net/problem/10815

<br>

### 풀이

숫자의 보유 여부를 판단하기 위해서 검색이 빠른 set을 사용해야된다.

상근이의 숫자는 있는지만 판단하면 되므로 다음과 같이 set에 저장해줬다.

```Python
card_number_set = set(sys.stdin.readline().rstrip().split(' '))
```

그 다음에 입력되는 m개의 숫자에 대해선 순서를 기억하고 있어야 하므로 list를 사용해야한다.

```Python
number_list = list(sys.stdin.readline().rstrip().split(' '))
```

그리고 다음과 같이 각 number_list에 대해서 이전에 저장한 card_number_set에 있으면 "1" 아니면 "0"을 출력하도록 해준다.