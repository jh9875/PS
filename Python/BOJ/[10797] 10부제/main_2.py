unit_digit_of_day = int(input())
unit_digit_of_car_numbers = list(map(int, input().split()))

ans = len([num for num in unit_digit_of_car_numbers if num == unit_digit_of_day])

print(ans)
