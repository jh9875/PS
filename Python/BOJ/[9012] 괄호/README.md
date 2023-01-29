괄호
===

문제 링크 : https://www.acmicpc.net/problem/9012

<br>

### 풀이

파이썬에서는 stack을 list로 사용하고있다.
단순하게 push, pop 기능을 list의 append, pop으로 사용할 수 있다.

나는 다음과 같이 괄호 짝을 맞추는 것을 구현해봤다.

```Python
def is_vps(ps: str) -> bool:
    stack = []

    for ch in ps:
        if ch == '(':
            stack.append('(')
        elif ch == ')':
            if stack:
                stack.pop()
            else:
                stack.append(')')
                break
        else:
            break;

    if stack:
        return False
    else:
        return True
```