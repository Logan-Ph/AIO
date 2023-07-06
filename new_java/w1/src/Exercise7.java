public class Exercise7 {
    public static void main(String[] args) {
        System.out.printf("%5s %15s%n", "Miles","Kilometers");
        for (int i=1; i<11; i++){
            System.out.printf("%3d %14.2f %n",i,i*1.609);
        }

        System.out.println();
        System.out.printf("%5s %10s%n", "Kilometers","Miles");
        for (int i=20; i<66; i+=5){
            System.out.printf("%3d %17.2f %n",i,i/1.609);
        }
    }
}
