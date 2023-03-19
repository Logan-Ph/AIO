<<<<<<< HEAD
n = int(input())
sum = 1
a = 0
def dot_pentagonal(n,a,sum):
    if n == a :
        return sum
    sum = sum + a*5
    return dot_pentagonal(n,a+1,sum)

ans = dot_pentagonal(n,a,sum)
=======
n = int(input())
sum = 1
a = 0
def dot_pentagonal(n,a,sum):
    if n == a :
        return sum
    sum = sum + a*5
    return dot_pentagonal(n,a+1,sum)

ans = dot_pentagonal(n,a,sum)
>>>>>>> 4e13fd0aac6f1f6baed4b618e165b4508beadcfa
print(ans)