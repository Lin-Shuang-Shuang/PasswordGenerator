public class Main {
    public static void main(String[] args) {

        PasswordGenerator pass = new PasswordGenerator(new Requirement(5, true, true));
        System.out.println(pass.getPassword());
    }
}