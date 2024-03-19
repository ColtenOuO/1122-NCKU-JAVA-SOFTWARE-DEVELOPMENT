package hw2;
import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HW2 {
    public static long gcd(long a,long b) {
        while( b != 0 ) {
            long c = a % b;
            a = b;
            b = c;
        }

        return a;
    }
    public static void solve(String x,String y) {
        int idx1 = -1;
        int idx2 = -1;
        String str1_float = "";
        String str2_float = "";
        String str1_num = "";
        String str2_num = "";

        for(int i=0;i<x.length();i++) {
            if( x.charAt(i) == '.' ) {
                idx1 = i;
            }
            else if( idx1 == -1 ) str1_num += x.charAt(i);
            else if( idx1 != -1 ) {
                str1_float += (x.charAt(i));
            }
        }
        for(int i=0;i<y.length();i++) {
            if( y.charAt(i) == '.' ) {
                idx2 = i;
            }
            else if( idx2 == -1 ) str2_num += y.charAt(i);
            else if( idx2 != -1 ) {
                str2_float += (y.charAt(i));
            }
        }

        long lcm = ( ( x.length() - idx1 - 1 ) * ( y.length() - idx2 - 1 ) ) / gcd(x.length()-idx1-1,y.length()-idx2-1);
        lcm *= 2;
        long g1 = lcm / ( x.length() - idx1 - 1 );
        long g2 = lcm / ( y.length() - idx2 - 1 );
        str1_num += ".";
        str2_num += ".";

        for(int i=0;i<g1;i++) str1_num += str1_float;
        for(int i=0;i<g2;i++) str2_num += str2_float;

        BigDecimal number1 = new BigDecimal(str1_num);
        BigDecimal number2 = new BigDecimal(str2_num);

        BigDecimal number = number1.add(number2);
        BigDecimal result = number.setScale((int)(lcm/2), RoundingMode.DOWN);

        String s = result.toPlainString();
        String tmp = "";
        boolean check = false;
        for(int i=0;i<s.length();i++) {
            if( s.charAt(i) == '.' ) check = true;
            else if( check == true ) tmp += s.charAt(i);
        }

        String now = "";
        for(int i=0;i<tmp.length()-1;i++) {
            now += tmp.charAt(i);
            int index = 0;
            if( tmp.length() % now.length() != 0 ) continue;
            while( index != tmp.length() ) {
                if( tmp.indexOf(now,index) == -1 ) break;
                else index = tmp.indexOf(now,index) + now.length();
            }

            if( index == tmp.length() ) {
                String new_answer = Integer.toString(result.intValue());
                new_answer += ".";
                new_answer += now;
                result = new BigDecimal(new_answer);
                break;
            }
        }

        boolean nine_check = true;
        for(int i=s.length()-1;i>=0;i--) {
            if( s.charAt(i) == '.' ) break;
            if( s.charAt(i) != '9' ) nine_check = false;
        }

        if( nine_check == true ) System.out.println(result.intValue()+1);
        else System.out.println(result);
        return;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String x = scanner.next();
            String y = scanner.next();

            solve(x,y);
        }

        scanner.close();
    }
}
