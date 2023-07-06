public class testRmitStudent {
    public static void main(String[] args) {
        RMITStudent s1 = new RMITStudent("Sang");
        s1.updateCourse("2201",20);
        s1.updateCourse("2201",50);
        System.out.println(s1);

    }
}
