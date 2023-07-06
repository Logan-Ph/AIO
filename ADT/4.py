a1 = [-10, 50, -52, 99]
a2 = [-100, 50, -52, 99]

temp =[float('inf')]*2
contain = False

for i in range(0,len(a1)-1):
    for j in range(i+1,len(a1)):
        if a1[i] + a1[j] == 0:
            print(f"{a1[i]} , {a1[j]}")
            contain = True
            break
        else:
            if abs(a1[i] + a1[j]) < abs(sum(temp)):
                temp = [a1[i], a1[j]]

if not contain:
    print(temp)