unit_digit_of_day = int(input())
unit_digit_of_car_numbers = list(map(int, input().split()))

ans = 0

for num in unit_digit_of_car_numbers:
    if unit_digit_of_day == num:
        ans += 1

print(ans)
