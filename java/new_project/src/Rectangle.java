public class Rectangle {
    private int height;
    private int width;


    public Rectangle(int w, int h){
        height = h;
        width = w;
    }

    public void visualize(){

        for(int i=0; i<height; i++){
            if ((height < 0) || (width < 0)){
                break;
            }

            for(int j=0; j<width; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
