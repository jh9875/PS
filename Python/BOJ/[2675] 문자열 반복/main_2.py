import sys


def print_string_repeatedly(r: int, s: str):
    result = list()

    for ch in s:
        result.append(ch * r)

    return ''.join(result)


T = int(sys.stdin.readline())
ans = list()

for i in range(T):
    R, S = sys.stdin.readline().split()
    ans.append(print_string_repeatedly(int(R), S))
print('\n'.join(ans))
