'''class Sieunhan:
    suc_manh = 50
    def __init__(self,ten,vu_khi,mau_sac):
        self.ten = ten
        self.vu_khi = vu_khi
        self.mau_sac = mau_sac

    @classmethod
    def cap_nhat_suc_manh(cls,smanh):
        cls.suc_manh = smanh



sieunhanA = Sieunhan("sang","kiem","xanh")
sieunhanB = Sieunhan("tin","meo","hong")

print(sieunhanA.suc_manh)
print(sieunhanB.suc_manh)

Sieunhan.cap_nhat_suc_manh(40)

print(sieunhanA.suc_manh)
print(sieunhanB.suc_manh)
print(Sieunhan.suc_manh)


class Nhanvien:  
    tuoi = 25
    def printTuoi(cls):   
    print('Số tuổi là:', cls.tuoi)'''
n = int(input())
[print(n,'*', i, '= ',n*i) for i in range(1,6)]
