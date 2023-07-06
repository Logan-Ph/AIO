Seq1, Seq2 =[1, 2, 3], [1, 2, 4]
a =set()
for i in range(len(Seq1)):
    a.add(Seq1[i])
    a.add(Seq2[i])

print(True) if list(a) == Seq1 else print(False)
