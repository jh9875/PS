짝수를 찾아라
===

문제 링크 : https://www.acmicpc.net/problem/3058

<br>

### 풀이

간단하게 짝수를 필터링하고, 합과 최솟값을 구하면 된다.

일단 입력받은 수에서 짝수를 필터링하기 위해서 filter라는 함수를 사용해봤다.

```Python
    number_list = list(map(int, sys.stdin.readline().rstrip().split(' ')))
    even_number_list = list(filter(lambda n: n % 2 == 0, number_list))
```

even_number_list를 저장할 때 filter(lambda, iterable) 식으로 넣어줬고, list로 받기 위해서 list() 함수를 사용해줬다.