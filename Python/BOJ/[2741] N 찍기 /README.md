N 찍기 
===

문제 링크 : https://www.acmicpc.net/problem/2741

<br>

### 풀이

처음 생각했을 땐 다음과 같은 풀이를 생각했다.

```Python
def print_one_to_n(n: int):
    numbers = list()

    for num in range(1, n + 1):
        numbers.append(num)

    print('\n'.join(map(str, numbers)))
```

굉장히 단순하게 했다.

근데 생각해보면 range라는 함수가 리스트를 만드는 함수인데.. 저렇게 for로 해서 append로 넣어서 하는게

매우 이상한 것 같다.

그래서 다음과 같이 수정해줬다.

```Python
def print_one_to_n(n: int):
    numbers = range(1, n + 1)
    print('\n'.join(map(str, numbers)))
```