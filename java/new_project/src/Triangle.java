public class Triangle {
    private int x , y, z;

    public Triangle(int s1, int s2, int s3){
        this.x = s1;
        this.y = s2;
        this.z = s3;
    }

    public void verify(){
        if ((x + y <=z) || (x + z <=y) || (y + z <=x)){
            System.out.println("Not Triangle");
        }
        else {
            if ((x==y) && (y ==z)){
                System.out.println("Equilateral Triangle");
            } else if ((x==y) || (x==z) || (y==z)) {
                System.out.println("Isosceles Triangle");
            }
            else {
                System.out.println("Scalene Triangle");
            }
        }
    }
}
