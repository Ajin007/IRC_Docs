import java.util.Scanner;

class BalException extends Exception {
    public BalException(String m) {
        super(m);
    }
}
public class Q2 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        double bal = x.nextDouble();
        double amt = x.nextDouble();
        try {
            if (bal < amt) {
                throw new BalException("Low balance");
            } else {
                System.out.println("Completed !");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
