index = 0
with open("C:\\Users\\phamp\\code\\github\\code\\edited_vietnam.txt") as f:
    for line in f:
        for i in range(len(line.split(","))):
            if line.split(",")[i] == "" :
                print("missing value at line {} column {}".format(index,i))
        index+=1