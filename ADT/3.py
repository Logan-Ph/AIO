arrival = [100,140,150,200,215,400]
departure = [110,300,220,230,315,600]

i = 1
j = 0

platform = 1
result=1

arrival.sort
departure.sort

while(i< len(arrival) and j < len(arrival)):
    if (arrival[i] <= departure[j]):
        platform +=1
        i+=1
    elif(arrival[i] > departure[j]):
        platform -=1
        j+=1
    
    if(platform > result):
        print(platform)
        result = platform

print(result)

