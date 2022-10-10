public class Main {
    public static void main(String[] args) {
        Intern i1 = new Intern("123", "cool dude", 10000.32999, 8);
        System.out.println(i1);

        Company Arasaka = new Company();
        Arasaka.registerEmployee("rsa2048", "Josh", 1.0);

        Arasaka.registerEmployee("928130k", "Carlitos", 180001.1);

        Arasaka.registerEmployee("123", "cool dude", 10000.32999);


        System.out.println(Arasaka.sortBySalary());
        System.out.println(Arasaka.retrieve("rsa2048"));
    }
}