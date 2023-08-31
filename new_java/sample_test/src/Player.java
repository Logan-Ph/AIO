import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Player implements Comparable<Player> {
    private String name;
    private Date dob;
    private long market;
    private boolean onSold;
    private Date contract;
    private Club club;

    public Player() {
    }

    public Player(String name, String dob, long market, boolean onSold, String contract) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
        this.name = name;
        this.dob = df.parse(dob);
        this.market = market;
        this.onSold = onSold;
        this.contract = df.parse(contract);
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getName() {
        return name;
    }

    public Club getClub() {
        return club;
    }

    public int getMonthDob() {
        SimpleDateFormat df = new SimpleDateFormat("MM");
        return Integer.parseInt(df.format(this.dob));
    }

    public int getYearDob() {
        SimpleDateFormat df = new SimpleDateFormat("y");
        return Integer.parseInt(df.format(this.dob));
    }

    public long getMarket() {
        return market;
    }

    public int getMonthContract() {
        SimpleDateFormat df = new SimpleDateFormat("MM");
        return Integer.parseInt(df.format(this.contract));
    }

    public int getYearContract() {
        SimpleDateFormat df = new SimpleDateFormat("y");
        return Integer.parseInt(df.format(this.contract));
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", market=" + market +
                ", onSold=" + onSold +
                ", contract=" + contract +
                ", club=" + club +
                '}';
    }


    @Override
    public int compareTo(Player o) {
        return this.market>o.market?1:-1;
    }
}
