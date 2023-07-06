import java.util.*;
import java.io.*;
public class WeatherTest {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/vietnam-temperature-from-1901-2015.csv"));
        file.nextLine();
        double hottemp= -9999,coldtemp =9999,temp,avgtemp = 0;
        String country;
        ArrayList<Double> monthtemp = new ArrayList();
        for(int i =0; i<12; i++){
            monthtemp.add((double) 0);
        }
        int year,month,hotmonth = 0, hotyear = 0, coldmonth = 0, coldyear=0, count = 0;
        while (file.hasNext()){
            String line = file.nextLine();
            StringTokenizer read = new StringTokenizer(line, ",");
            if(read.countTokens()!=4){
                throw new IOException("Invalid input format!");
            }
            else {
                temp = Double.parseDouble(read.nextToken());
                year = Integer.parseInt(read.nextToken());
                month = Integer.parseInt(read.nextToken());
                country =read.nextToken();
                count++;
                avgtemp += temp;

                double newtemp = temp+monthtemp.get(month-1);
                monthtemp.set(month-1, newtemp);


                if (temp > hottemp){
                    hottemp = temp;
                    hotmonth = month;
                    hotyear = year;
                }

                if (temp< coldtemp){
                    coldtemp = temp;
                    coldmonth = month;
                    coldyear = year;
                }
            }
        }
        ArrayList<Double> newmonthttemp = new ArrayList(monthtemp);
        Collections.sort(newmonthttemp);

        System.out.printf("The overall average temp %.2f%n", avgtemp/count);
        System.out.println("The coldest temp is "+coldtemp + " at month " + coldmonth +  " "  + coldyear);
        System.out.println("The coldest temp is "+hottemp + " at month " + hotmonth+  " " + hotyear);
        System.out.println("The coldest month is "+ (monthtemp.indexOf(newmonthttemp.get(0))+1));
        System.out.println("The hottest month is "+ (monthtemp.indexOf(newmonthttemp.get(11))+1));
    }
}
