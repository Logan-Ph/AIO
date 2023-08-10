import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        String Culine,MoiLine;
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Scanner DienNuocCu = new Scanner(new File("src/DienNuocCu"));
        Scanner DienNuocMoi = new Scanner(new File("src/DienNuocMoi"));
        int i =1;
        while (DienNuocCu.hasNext()){
            Culine = DienNuocCu.nextLine();
            MoiLine = DienNuocMoi.nextLine();
            StringTokenizer dienNuocMoi = new StringTokenizer(MoiLine, " ");
            StringTokenizer dienNuocCu = new StringTokenizer(Culine, " ");
            int dien_moi = Integer.parseInt(dienNuocMoi.nextToken());
            int dien_cu = Integer.parseInt(dienNuocCu.nextToken());
            int nuoc_moi = Integer.parseInt(dienNuocMoi.nextToken());
            int nuoc_cu = Integer.parseInt(dienNuocCu.nextToken());

            System.out.printf("P%d (%d/%d/%d)%n",i,getDate(localDate),getMonth(localDate),getYear(localDate));
            System.out.printf("     ĐIỆN: %d - %d = %d x %.1f = %s%n",dien_moi,dien_cu,dien_moi-dien_cu,3.5,String.format("%,d,000",getMoneyElectricity(dien_moi,dien_cu)));
            System.out.printf("     NƯỚC: %d - %d = %d x %d = %s%n", nuoc_moi, nuoc_cu,nuoc_moi-nuoc_cu,25,String.format("%,d,000",getMoneyWater(nuoc_moi,nuoc_cu)));
            System.out.printf("     RÁC: %d%n",getMoneyGarbage());
            System.out.printf("     TRỌ: %s%n",String.format("%,d,000",getRoomMoney(i)));
            System.out.printf("     TỔNG: %s%n",String.format("%,d,000",getMoneyElectricity(dien_moi,dien_cu)+getMoneyWater(nuoc_moi,nuoc_cu)+getRoomMoney(i)+getMoneyGarbage()));
            i++;
        }
        DienNuocCu.close();
        DienNuocMoi.close();
    }

    static int getRoomMoney(int n){
        if ((n == 1) || (n==2)){
            return 3500;
        }
        else {
            return 2300;
        }
    }

    static int getMoneyGarbage(){
        return 40;
    }

    static int getMoneyElectricity(int New, int Old){
        return (int) ((New-Old)*3.5);
    }

    static int getMoneyWater(int New, int Old){
        return (New-Old)*25;
    }

    static int getDate(LocalDate localDate){
        return localDate.getDayOfMonth();
    }

    static int getMonth(LocalDate localDate){
        return localDate.getMonthValue();
    }

    static int getYear(LocalDate localDate){
        return localDate.getYear();
    }
}
