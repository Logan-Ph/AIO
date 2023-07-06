N = 5
a1 = [0, 1, 2, 3, 4]
a2 = [1, 2, 3, 4, 5]
a3 = [0, 1, 2, 4, 5]

for i in range(0,N+1):
    try:
        if a3[i] != i:
            print(i)
            break
    except:
        print(N)
