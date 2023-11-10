import java.util.*;

public class Problem2 {
    static class Team implements Comparable<Team>{
        String name;
        HashMap<Team,Integer> wonAgainst;

        int point;

        public Team(String name) {
            this.name = name;
            wonAgainst = new HashMap<>();
        }

        public void win(Team team){
            point +=3;
            team.wonAgainst.putIfAbsent(team,0);
            this.wonAgainst.putIfAbsent(this,0);
            team.wonAgainst.putIfAbsent(this,0);
            this.wonAgainst.putIfAbsent(team,0);
            wonAgainst.merge(team, 1,Integer::sum);
        }

        public boolean timesWinAgainstTeam(Team team){
            return wonAgainst.get(team) > team.wonAgainst.get(this);
        }

        public void draw(Team team){
            point++;
            team.setPoint(team.getPoint()+1);
            team.wonAgainst.putIfAbsent(team,0);
            this.wonAgainst.putIfAbsent(this,0);
            team.wonAgainst.putIfAbsent(this,0);
            this.wonAgainst.putIfAbsent(team,0);
        }

        public void lose(Team team){
            team.setPoint(team.getPoint()+3);
            team.wonAgainst.putIfAbsent(this,0);
            this.wonAgainst.putIfAbsent(this,0);
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public int getPoint() {
            return point;
        }

        @Override
        public String toString() {
            return "Team{" +
                    "name='" + name + '\'' +
                    '}';
        }


        @Override
        public int compareTo(Team o) {
            return Integer.compare(o.getPoint(),this.getPoint());
        }
    }

    static class LeaderBoard{
        Team[] teams = new Team[4];
        private int i = 0;
        public LeaderBoard() {
        }

        public void add(Team team){
            teams[i++] = team;
        }

        public Team[] rank(){
            Arrays.sort(teams);
            return teams;
        }

        public Team[] realRank(){
            rank();
            for (int i=0; i<teams.length; i++){
                for (int j =i+1; j<teams.length;j++){
                    if (teams[i].point == teams[j].point && i>j){
                        if (teams[i].timesWinAgainstTeam(teams[j])){
                            Team temp = teams[j];
                            teams[j] = teams[i];
                            teams[i] = temp;
                        }
                    }
                    else if (teams[i].point == teams[j].point && j>i){
                        if (teams[j].timesWinAgainstTeam(teams[i])){
                            Team temp = teams[i];
                            teams[i] = teams[j];
                            teams[j] = temp;
                        }
                    }
                }
            }
            return teams;
        }
    }

    public static void main(String[] args) {
        Team a = new Team("a");
        Team b = new Team("b");
        Team c = new Team("c");
        Team d = new Team("d");

        a.win(b);
        a.win(c);
        a.win(c);
        a.win(c);

        b.win(a);
        b.win(a);
        b.win(c);
        b.win(c);

        d.win(a);
        c.win(d);
        LeaderBoard leader = new LeaderBoard();

        leader.add(c);

        leader.add(d);

        leader.add(a);

        leader.add(b);

        System.out.println(Arrays.toString(leader.rank()));
        System.out.println(Arrays.toString(leader.realRank()));
    }
}
