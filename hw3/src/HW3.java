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
        public int calculateManhattanDistance(Point other) {
            return Math.abs(this.vertical - other.vertical) + Math.abs(this.horizontal - other.horizontal);
        }
        public double ChebyshevDistance(Point other) {
            return Math.max(Math.abs(this.vertical-other.vertical),Math.abs(this.horizontal-other.horizontal));
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
        Point other = new Point(other_x,other_y);
        point.Output();
        point.Move(move_x,move_y);
        point.Output();
        for(int i=0;i<4;i++) {
            point.Rotate();
            point.Output();
        }

        System.out.println(point.calculateManhattanDistance(other));
        System.out.println(point.ChebyshevDistance(other));
    }
}