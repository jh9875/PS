최댓값
===

문제 링크 : https://www.acmicpc.net/problem/2562

<br>

### 풀이

처음 내가 풀어본 방식은 다음과 같다.

```Python
max_number = 0
numbers = list()

for i in range(9):
    n = int(sys.stdin.readline())
    numbers.append(n)
    if max_number < n:
        max_number = n

print(max_number)
print(numbers.index(max_number) + 1)
```

위와 같이 한 이유는 처음 입력 받을 때 한번의 루프에서 최댓 값을 구하면 시간이 더 줄어들 줄 알았다.

하지만 두 번째 제출이 더 짧은 시간을 기록했다. (거의 차이는 없다.)

```Python
numbers = list()

for i in range(9):
    numbers.append(int(sys.stdin.readline()))

print(max(numbers))
print(numbers.index(max(numbers)) + 1)
```

그냥 생각해 봤을 땐 한번의 반복문에서 입력을 받고, max()라는 함수가 어떻게 내부적으로 동작하는지 이해하진 못했지만

list를 순회하면서 찾을거라고 생각했다.

근데 두 번째가 더 빠르게 나왔다.

9개의 적은 수로만 비교해서 그런건지.. 잘 모르겠다.. ㅠㅠ