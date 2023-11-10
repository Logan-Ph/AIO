import java.lang.reflect.Type;
import java.util.*;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hashtable<Integer, Integer> ar = new Hashtable<>();
        boolean run = true;

        String user = "2017 2019 2018 2019 2019 2020 2018 2018 2019 2018 2018 2017 2018 2018 2019 2018 2021 2021 2021 2022 2019 2019 2016 2016 2021 2020 2022 2020 2020 2020 2020 2020 2020 2020 2017 2020 2021 2023 2019 2021 2021 2020 2020 2020 2018 2021 2023 2020 2016 2022 2020 2021 2019 2019 2023 2013 2018 2021 2016 2021";
        String[] userAr = user.split(" ");
        try {
            for (String i : userAr) {
                int num = Integer.parseInt(i);
                ar.merge(num, 1, Integer::sum);
            }

        } catch (Exception e) {
            System.out.println("Invalid input please enter a again");
        }

        for(int i: ar.keySet()){
            System.out.println(i + ": " + ar.get(i));
        }
    }
}
