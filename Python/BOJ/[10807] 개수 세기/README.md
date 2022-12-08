개수 세기
===

문제 링크 : https://www.acmicpc.net/problem/10807

<br>

### 풀이

수를 세기위해서 dict를 사용할 수 있다.

나는 java에 익숙해서 Map을 사용하며 contains() 메소드를 이용해서 확인하고,
put(), get() 메소드 등을 이용해서 하곤 했었다.

파이썬에선 다음과 같이 할 수 있다.

```Python

for num in number_list:
    if num in num_count:
        num_count[num] += 1
    else:
        num_count[num] = 1

v = int(input())

if v in num_count:
    print(num_count[v])
else:
    print(0)

```

처음엔 인터넷에 contains 비슷한 메소드가 있는지 찾아보다가 has_key()라는 메소드를 찾았다. 근데 파이참에서 써보려는데 자동완성이 되지 않았다.

그래도 써봤는데 알고보니 deprecated 됐다고 알려주면서 in을 대신 사용하라고 알려줬다.

참 친절하게 잘 만든 것 같았다.