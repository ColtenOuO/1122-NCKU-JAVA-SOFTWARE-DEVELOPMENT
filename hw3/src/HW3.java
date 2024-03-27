package hw3;
import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HW3 {
    public static class Point {
        private int vertical; // x
        private int horizontal; // y
        Point(int x,int y) {
            this.vertical = x;
            this.horizontal = y;
            return;
        }
        void Set(int x,int y) {
            this.vertical = x;
            this.horizontal = y;
            return;
        }
        void Move(int x,int y) {
            this.vertical += x;
            this.horizontal += y;
            return;
        }
        void Rotate() {
            int tmp_x = this.vertical;
            int tmp_y = this.horizontal;
            this.vertical = tmp_y;
            this.horizontal = tmp_x * -1;
            return;
        }
        int RetrieveVertical() {
            return this.vertical;
        }
        int RetrieveHorizontal() {
            return this.horizontal;
        }
        int calculateManhattanDistance(Point other) {
            
        }
        double ChebyshevDistance(Point other) {
            
        }
        void Output() {
            System.out.print(this.RetrieveVertical());
            System.out.print(' ');
            System.out.println(this.RetrieveHorizontal());
            return;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int main_x = scanner.nextInt();
        int main_y = scanner.nextInt();
        int other_x = scanner.nextInt();
        int other_y = scanner.nextInt();
        int move_x = scanner.nextInt();
        int move_y = scanner.nextInt();

        Point point = new Point(main_x,main_y);
        point.Output();
        point.Move(move_x,move_y);
        point.Output();
        for(int i=0;i<4;i++) {
            point.Rotate();
            point.Output();
        }

        System.out.println()
    }
}