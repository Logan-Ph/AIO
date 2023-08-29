import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Club {
    private String name;
    private long budget;
    private ArrayList<Player> players = new ArrayList<>();

    public Club(String name, long budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Player player) {
        player.setClub(this);
        this.players.add(player);
    }

    public long getBudget() {
        return budget;
    }
    
    public String getValueAblePlayer(){
        ArrayList<Player> players1 = this.getPlayers();
        Collections.sort(players1);
        return players1.get(players1.size()-1).getName();

    }
    
    public static void printClubDetails(Club club){
        System.out.println("Club name: "+ club.getName());
        System.out.println("Total Budget: "+ club.getBudget());
        System.out.println("Number of Players: "+club.getPlayers().size());
        System.out.println("The most valuable player: "+club.getValueAblePlayer());
    }

    public static void printAllPlayerDetails(Club club){
        Date currentDate = new Date();
        SimpleDateFormat mf = new SimpleDateFormat("MM");
        SimpleDateFormat yf = new SimpleDateFormat("y");


        for (Player player: club.getPlayers()){
            System.out.println("Player Name: "+ player.getName());
            System.out.printf("Market Price: %d$%n", player.getMarket());
            System.out.println("Age: "+ (Integer.parseInt(yf.format(currentDate)) - player.getYearDob()));
            if (Integer.parseInt(yf.format(currentDate)) - player.getYearContract() == 0){
                System.out.printf("Contract Length: %d month(s) %n", player.getMonthContract() - Integer.parseInt(mf.format(currentDate)));
            } else if (player.getMonthContract() - Integer.parseInt(mf.format(currentDate))<0) {
                System.out.printf("Contract Length: %d month(s) %n", 12 + player.getMonthContract() - Integer.parseInt(mf.format(currentDate)));
            } else {
                System.out.printf("Contract Length: %d year(s) %d month(s) %n" ,player.getYearContract() - Integer.parseInt(yf.format(currentDate)),player.getMonthContract() - Integer.parseInt(mf.format(currentDate)));
            }
            System.out.println();
        }
    }

    public static void listPotentialPlayer(Club club){
        ArrayList<Player> players1 = club.getPlayers();
        Collections.sort(players1);
        Date currentDate = new Date();
        SimpleDateFormat mf = new SimpleDateFormat("MM");
        SimpleDateFormat yf = new SimpleDateFormat("y");
        for (Player player: players1){
            System.out.println("Player Name: "+ player.getName());
            System.out.println("Market Price: "+ player.getMarket());
            System.out.println("Age: "+ (Integer.parseInt(yf.format(currentDate)) - player.getYearDob()));
            if (Integer.parseInt(yf.format(currentDate)) - player.getYearContract() == 0){
                System.out.println("Contract Length: "+ (player.getMonthContract() - Integer.parseInt(mf.format(currentDate))));
            }else {
                System.out.printf("Contract Length: %d year(s) %d month(s) %n" ,player.getYearContract() - Integer.parseInt(yf.format(currentDate)),player.getMonthContract() - Integer.parseInt(mf.format(currentDate)));
            }
        }
    }
}
