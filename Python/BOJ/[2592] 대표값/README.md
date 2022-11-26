대표값
===

문제 링크 : https://www.acmicpc.net/problem/2592

<br>

### 풀이

10개의 수 를 센 후 평균과 최빈값을 구하는 문제이다.

나는 이 문제를 보고 java에서 Map을 이용해서 수를 세는것을 생각했다.

그래서 python의 dict를 이용해보기로 했다.

그래서 다음과 같이 dict에 값을 넣어줬다.

```Python
count_dict = dict()

for _ in range(10):
    num = int(input())

    if num in count_dict:
        count_dict[num] += 1
    else:
        count_dict[num] = 1
```

이렇게 하면 각 수마다 횟수를 알 수 있다.

여기서 평균은 key와 value를 곱한 값의 합에 10을 나눠서 구할 수 있다.

합을 구하는 것은 map과 lambda를 이용해봤다.

```Python

print(sum(map(lambda x: x[0] * x[1], count_dict.items())) // 10)

```

위와같이 map을 사용하면 lambda에 적용된 함수를 각 dict.items()에 적용할 수 있다.

그리고 sum으로 합을 구한 후 갯수인 10으로 나눴다.

그리고 최빈값을 dict를 value의 정렬한 후 가장 value가 큰 값을 이용해서 찾을 수 있었다.

```Python

print(sorted(count_dict.items(), key=lambda x: x[1], reverse=True)[0][0])

```

일단 sorted를 이용했고 item()를 정렬 대상으로 했다. lambda에서 x[1]의 값(x[0] : key값, x[1] : value 값)을 이용해서 정렬한 다음 가장 첫번째 수의 key값을 출력하도록 했다.

