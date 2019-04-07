def get_multiplication_persistence(num):
    num = str(num)
    multiplication_persistence = 0
    while num > 9:
        num = str(eval('*'.join(num)))
        multiplication_persistence += 1
    return multiplication_persistence

print(get_multiplication_persistence(277777788888899))
