import math


def get_sieve_of_eratosthenes_list(max_value: int):
    prime_number_list = [True for _ in range(max_value + 1)]
    prime_number_list[1] = False

    sqrt = int(math.sqrt(max_value))
    for num in range(2, sqrt + 1):
        if prime_number_list[num]:
            multiply = 2
            while num * multiply <= max_value:
                prime_number_list[num * multiply] = False
                multiply += 1

    return prime_number_list


if __name__ == '__main__':
    min_value_input = int(input())
    max_value_input = int(input())

    prime_number_list_result = get_sieve_of_eratosthenes_list(max_value_input)

    prime_number_sum = 0
    min_prime_number = 0

    for index in range(min_value_input, max_value_input + 1):
        if prime_number_list_result[index]:
            if not min_prime_number:
                min_prime_number = index
            prime_number_sum += index

    if prime_number_sum:
        print(prime_number_sum)
        print(min_prime_number)
    else:
        print(-1)
