import sys


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


if __name__ == '__main__':
    ans = []
    t = int(sys.stdin.readline().rstrip())

    for _ in range(t):
        parenthesis_string = sys.stdin.readline().rstrip()
        if is_vps(parenthesis_string):
            ans.append("YES")
        else:
            ans.append("NO")

    print('\n'.join(ans))
