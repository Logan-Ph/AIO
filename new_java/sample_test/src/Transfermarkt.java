import java.text.ParseException;
import java.util.ArrayList;

public class Transfermarkt {
    public static void main(String[] args) throws ParseException {
        Club Tottenham = new Club("Tottenham", 250000000);
        Club PSG = new Club("PSG", 500000000);
        Club Manchester_City = new Club("Manchester City", 300000000);

        ArrayList<Club> clubs = new ArrayList<>();
        clubs.add(Tottenham);
        clubs.add(PSG);
        clubs.add(Manchester_City);

        Player Harry_Kane = new Player("Harry Kane", "28/07/1993", 100000000, true, "20/10/2023");
        Player Son_Heung_Min = new Player("Son Heung Min", "08/07/1992", 70000000, true, "20/10/2025");
        Player Richarlison = new Player("Richarlison", "19/05/1997", 56000000, false, "20/10/2024");
        Player Erling_Haaland = new Player("Erling Haaland", "21/07/2000", 300000000, true, "20/10/2025");
        Player Kevin_De_Bruyne = new Player("Kevin De Bruyne", "28/06/1991", 90000000, false, "20/05/2024");
        Player Jack_Grealish = new Player("Jack Grealish", "10/09/1995", 100000000, true, "03/08/2025");
        Player Kylian_Mbappe = new Player("Kylian Mbappe", "20/12/1998", 350000000, true, "01/07/2024");
        Player Neymar = new Player("Neymar", "05/02/1992", 80000000, true, "01/07/2024");
        Player Hakimi = new Player("Hakimi", "04/11/1998", 55000000, false, "03/08/2025");

        Tottenham.setPlayers(Harry_Kane);
        Tottenham.setPlayers(Son_Heung_Min);
        Tottenham.setPlayers(Richarlison);

        Manchester_City.setPlayers(Erling_Haaland);
        Manchester_City.setPlayers(Kevin_De_Bruyne);
        Manchester_City.setPlayers(Jack_Grealish);

        PSG.setPlayers(Kylian_Mbappe);
        PSG.setPlayers(Neymar);
        PSG.setPlayers(Hakimi);

//        Club.printClubDetails(Tottenham);
//        System.out.println();
//        Club.printClubDetails(Manchester_City);
//        System.out.println();
//        Club.printClubDetails(PSG);

        Club.printAllPlayerDetails(Tottenham);
        System.out.println();
        Club.printAllPlayerDetails(Manchester_City);
        System.out.println();
        Club.printAllPlayerDetails(PSG);

    }
}
