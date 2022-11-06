def d(n: int):
    result = n
    result += sum(map(int, list(str(n))))
    return result


if __name__ == '__main__':
    all_numbers = set(range(1, 10001))
    dn_set = set()

    for i in range(1, 10001):
        dn = d(i)
        dn_set.add(dn)

    self_numbers = all_numbers.difference(dn_set)

    print('\n'.join(map(str, sorted(self_numbers))))
