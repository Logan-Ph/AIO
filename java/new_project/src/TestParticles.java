public class TestParticles {
    public static void main(String[] args) {

        Box b = new Box(18,6);

        Particles p1 = new Particles(b);
        Particles p2 = new Particles(b);
        Particles p3 = new Particles(b);
        Particles p4 = new Particles(b);
        Particles p5 = new Particles(b);
        Particles p6 = new Particles(b);
        Particles p7 = new Particles(b);
        Particles p8 = new Particles(b);


        b.Add(p1);
        b.Add(p2);
        b.Add(p3);
        b.Add(p4);
        b.Add(p5);
        b.Add(p6);
        b.Add(p7);
        b.Add(p8);

        System.out.println(b);
        System.out.println(b);
        System.out.println(b);
        System.out.println(b);
    }
}
