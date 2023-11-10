public class Problem1 {
    public static void main(String[] args) throws InvalidVaccineTypeException {
        Person p1 = new Person("Pham1",16);
        Person p2 = new Person("Pham2",25);
        Person p3 = new Person("Pham3",50);
        Person p4 = new Person("Pham4",70);

        Vaccine a = new TypeA("a", 10);
        Vaccine b = new TypeB("b", 10);
        Vaccine c = new TypeC("c", 10);
        Vaccine d = new TypeD("d", 10);

        p1.getVaccine(a);
//        p2.getVaccine(b);
//        p3.getVaccine(c);
        p4.getVaccine(d);
    }
    interface Vaccine {
        public boolean isTwoDoses();
        public int daysBetween();
    }

    static class Vaccine1Dose implements Vaccine{
        private String name;
        private double amount;

        public Vaccine1Dose(String name, double amount) {
            this.name = name;
            this.amount = amount;
        }

        @Override
        public boolean isTwoDoses() {
            return false;
        }

        @Override
        public int daysBetween() {
            return 0;
        }

        public String getName() {
            return name;
        }

        public double getAmount() {
            return amount;
        }
    }

    static class Vaccine2Dose implements Vaccine{
        private String name;
        private double amount;
        private int dayBetween;

        public Vaccine2Dose(String name, double amount, int dayBetween) {
            this.name = name;
            this.amount = amount;
            this.dayBetween = dayBetween;
        }

        @Override
        public boolean isTwoDoses() {
            return true;
        }

        @Override
        public int daysBetween() {
            return dayBetween;
        }

        public String getName() {
            return name;
        }

        public double getAmount() {
            return amount;
        }

        public int getDayBetween() {
            return dayBetween;
        }
    }

    static class TypeA extends Vaccine2Dose implements UsedByYoung {

        public TypeA(String name, double amount) {
            super(name, amount, 20);
        }

        @Override
        public String procedureForTheYoung() {
            return getName() + " is OK for the Young";
        }
    }

    static class TypeB extends Vaccine2Dose implements UsedByElderly{

        public TypeB(String name, double amount) {
            super(name, amount, 30);
        }
        @Override
        public String procedureForTheElderly() {
            return getName()+ " is OK for the Elderly";
        }
    }

    static class TypeC extends Vaccine1Dose implements UsedByYoung{

        public TypeC(String name, double amount) {
            super(name, amount);
        }

        @Override
        public String procedureForTheYoung() {
            return getName()+ " is OK for the Young";
        }
    }

    static class TypeD extends Vaccine1Dose implements UsedByElderly{

        public TypeD(String name, double amount) {
            super(name, amount);
        }

        @Override
        public String procedureForTheElderly() {
            return getName()+ " is OK for the Elderly";
        }
    }

    static class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void getVaccine(Vaccine vaccine) throws InvalidVaccineTypeException {
            if (age>=18 && age<= 65){
                throw new InvalidVaccineTypeException("Vaccine is not suitable");
            }else if (vaccine instanceof Vaccine2Dose){
                System.out.println( name + ", you will get after " + ((Vaccine2Dose) vaccine).getDayBetween() + " days");
            } else{
                System.out.println(name + ", you need only one dose");
            }
        }
    }

    interface UsedByYoung{
        String procedureForTheYoung();
    }

    interface UsedByElderly {
        String procedureForTheElderly();
    }

    static class InvalidVaccineTypeException extends Exception {
        public InvalidVaccineTypeException(String str) {
            super(str);
        }
    }

}


