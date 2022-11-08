X보다 작은 수
===

문제 링크 : https://www.acmicpc.net/problem/10871

<br>

### 풀이

아주 기본적인 기능을 이용해서 풀이를 하면 다음과 같이 할 수 있다.

```Python
ans = []
n, x = map(int, input().split())

num_list = map(int, input().split())

for num in num_list:
    if num < x:
        ans.append(num)

print(' '.join(map(str, ans)))
```

그냥 반복문 하면서 거르는거다.

나는 Java에 익숙해서 가장 먼저 생각나는건 다음과 같이 List와 Stream을 이용하는 것이다.

```Java

List<Integer> list = ..

list.stream().filter(num -> num < x).collect(Collectors.toList())

```

그래서 파이썬에는 편리한 함수같은게 있나 찾아봤는데 filter라는 함수가 있었다.

아래와 같이 filter와 lambda 식을 이용하고 list()로 만들어 주면 됐다.

```Python
n, x = map(int, input().split())

num_list = map(int, input().split())

ans = list(filter(lambda num: num < x, num_list))

print(' '.join(map(str, ans)))

```