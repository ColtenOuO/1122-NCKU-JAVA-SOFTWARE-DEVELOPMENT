package hw1;
import java.util.Scanner;
import java.math.BigDecimal;

public class HW1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextBigDecimal()) {
            BigDecimal num1 = scanner.nextBigDecimal();
            BigDecimal num2 = scanner.nextBigDecimal();
            BigDecimal sum = num1.add(num2);
            System.out.println(sum.toPlainString());
        }

        scanner.close();
    }
}
