def d(n: int):
    result = n
    result += sum(map(int, list(str(n))))
    return result


if __name__ == '__main__':
    ans = list(range(1, 10001))

    for i in range(1, 10001):
        dn = d(i)
        if dn and (dn in ans):
            ans.remove(dn)

print('\n'.join(map(str, ans)))
