import java.util.*;
public class Box {
    Random random = new Random();
    int width,height;
    private static String[][] container;

    public Box(int w, int h){
        this.width = w;
        this.height= h;
        container = new String[height][width];
    }
    public void Add(Particles p){
        container[p.y][p.x]= "*";
    }

    @Override
    public String toString(){
        for (int i =0; i<container.length;i++){
            for (int j=0; j<container[i].length;j++){
                double rand = random.nextDouble();
                if (container[i][j] != null){
                    moveRandom(rand,i,j);

                }
            }
        }

        for(int i=0; i<container.length; i++) {
            if (i==0){
                System.out.print(" ");
                for(int z=0; z<container[i].length;z++){
                    System.out.print("-");
                }
                System.out.println();
            }
            for(int j=0; j<container[i].length; j++) {
                if (j==0){
                    System.out.print("|");
                }
                if ( container[i][j] != null){
                    System.out.print(container[i][j]);
                }
                else{
                    System.out.print(" ");
                }
                if (j == container[i].length -1){
                    System.out.print("|");
                }
            }
            System.out.println();

            if (i==container.length-1){
                System.out.print(" ");
                for(int z=0; z<container[i].length;z++){
                    System.out.print("-");
                }
                System.out.println();
            }
        }
        return " ";
    }

    static void moveRandom(double rand, int i, int j){
        if((0<= rand)&&(rand<0.125)){
            if ((i-1>0)){
                container[i][j] = null;
                container[i-1][j] = "*";
            }
        } else if ((0.125<= rand)&&(rand<0.25)) {
            if ((i-1>0)&&(j+1<container[0].length)){
                container[i][j] = null;
                container[i-1][j+1] = "*";
            }
        }else if ((0.25<= rand)&&(rand<0.375)) {
            if ((j+1<container[0].length)){
                container[i][j] = null;
                container[i][j+1] = "*";
            }
        }else if ((0.375<= rand)&&(rand<0.5)) {
            if ((i+1<container.length)&&(j-1>0)){
                container[i][j] = null;
                container[i+1][j-1] = "*";
            }
        }else if ((0.5<= rand)&&(rand<0.625)) {
            if ((i+1<container.length)){
                container[i][j] = null;
                container[i+1][j] = "*";
            }
        }else if ((0.625<= rand)&&(rand<0.75)) {
            if ((i+1<container.length)&&(j-1>0)){
                container[i][j] = null;
                container[i+1][j-1] = "*";
            }
        }else if ((0.75<= rand)&&(rand<0.875)) {
            if ((j-1>0)){
                container[i][j] = null;
                container[i][j-1] = "*";
            }
        }else if ((0.875<= rand)&&(rand<1)) {
            if ((i-1>0)&&(j-1>0)){
                container[i][j] = null;
                container[i-1][j-1] = "*";
            }
        }
    }
}
