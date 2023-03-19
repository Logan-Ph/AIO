from datetime import date
today = date.today()
phong = input("phòng mấy")

def tổng_tiền_điện():
    điện_mới = int(input("Điện mới: "))
    điện_cũ = int(input("Điện cũ: "))
    tiền_điện = int((điện_mới - điện_cũ)*3.5)
    số_điện = điện_mới - điện_cũ
    return tiền_điện, điện_cũ, điện_mới, số_điện

def tổng_tiền_nước():
    nước_mới = int(input("Nước mới: "))
    nước_cũ = int(input("Nước cũ: "))
    số_nước = nước_mới - nước_cũ
    tiền_nước = int((nước_mới - nước_cũ)*20)
    return nước_mới,nước_cũ,tiền_nước,số_nước

def tổng_tất_cả(tiền_điện, tiền_nước):
    tiền_trọ = int(input("Tiền trọ: "))
    rác = int(40)
    tổng = int((tiền_điện + tiền_nước + rác + tiền_trọ))
    tổng = str(tổng)
    tiền_trọ = str(tiền_trọ)
    tong_1 = tổng[0:1]
    tong_2 = tổng[1:]
    tong_1 = str(tong_1)
    tong_2 = str(tong_2)
    tiền_trọ_1 = tiền_trọ[:1]
    tiền_trọ_2 = tiền_trọ[1:]
    return tiền_trọ,rác,tổng,tong_1,tong_2,tiền_trọ_1,tiền_trọ_2


def main():
    tiền_điện, điện_cũ, điện_mới,số_điện = tổng_tiền_điện() 
    nước_mới,nước_cũ,tiền_nước,số_nước = tổng_tiền_nước()  
    tiền_trọ,rác,tổng,tong_1,tong_2,tiền_trọ_1,tiền_trọ_2 = tổng_tất_cả(tiền_điện,tiền_nước)
    if tiền_điện >= 1000:
        tiền_điện = str(tiền_điện)
        tiền_điện_1 = tiền_điện[0:1]
        tiền_điện_2 = tiền_điện[1:]
        print("P{0} (10/{1}/{2})".format(phong,today.month,today.year))
        print("ĐIỆN: " + str(điện_mới)+' - ' + str(điện_cũ) + ' = ' + str(số_điện) + ' x 3.5 = ' + str(tiền_điện_1) + '.' + str(tiền_điện_2) + '.000đ' )
        print("NƯỚC: "+ str(nước_mới) + ' - ' + str(nước_cũ) + ' = ' + str(số_nước) + ' x 20 = ' + str(tiền_nước) + '.000đ' )
        print("RÁC:  " + str(rác) +'.000đ')
        print('TRỌ:  ' + str(tiền_trọ_1) + '.' + str(tiền_trọ_2) + '.000đ')
        print('TỔNG: ' + str(tong_1) + '.' + str(tong_2),end= '.000đ')
    else:
        tiền_điện = str(tiền_điện)
        print("P{0} (10/{1}/{2})".format(phong,today.month,today.year))
        print("ĐIỆN: " + str(điện_mới)+' - ' + str(điện_cũ) + ' = ' + str(số_điện) + ' x 3.5 = ' + str(tiền_điện) + '.000đ' )
        print("NƯỚC: "+ str(nước_mới) + ' - ' + str(nước_cũ) + ' = ' + str(số_nước) + ' x 20 = ' + str(tiền_nước) + '.000đ' )
        print("RÁC:  " + str(rác) + '.000đ')
        print("TRỌ:  " + str(tiền_trọ_1) + '.' + str(tiền_trọ_2) + '.000đ')
        print("TỔNG: " + str(tong_1) + '.' + str(tong_2),end= '.000đ')

main()
