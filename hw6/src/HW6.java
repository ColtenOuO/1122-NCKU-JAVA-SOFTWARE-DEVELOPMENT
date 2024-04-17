import java.util.Scanner;
public class HW6 {
    public static int isWin(char[][] mp) {
        if( mp[1][1] == mp[1][2] && mp[1][2] == mp[1][3] && mp[1][1] == 'O' ) return 1;
        if( mp[1][1] == mp[1][2] && mp[1][2] == mp[1][3] && mp[1][1] == 'X' ) return 2;

        if( mp[2][1] == mp[2][2] && mp[2][2] == mp[2][3] && mp[2][1] == 'O' ) return 1;
        if( mp[2][1] == mp[2][2] && mp[2][2] == mp[2][3] && mp[2][1] == 'X' ) return 2;

        if( mp[3][1] == mp[3][2] && mp[3][2] == mp[3][3] && mp[3][1] == 'O' ) return 1;
        if( mp[3][1] == mp[3][2] && mp[3][2] == mp[3][3] && mp[3][1] == 'X' ) return 2;

        if( mp[1][1] == mp[2][1] && mp[2][1] == mp[3][1] && mp[1][1] == 'O' ) return 1;
        if( mp[1][1] == mp[2][1] && mp[2][1] == mp[3][1] && mp[1][1] == 'X' ) return 2;

        if( mp[1][1] == mp[2][1] && mp[2][1] == mp[3][1] && mp[1][1] == 'O' ) return 1;
        if( mp[1][1] == mp[2][1] && mp[2][1] == mp[3][1] && mp[1][1] == 'X' ) return 2;

        if( mp[1][2] == mp[2][2] && mp[2][2] == mp[3][2] && mp[1][2] == 'O' ) return 1;
        if( mp[1][2] == mp[2][2] && mp[2][2] == mp[3][2] && mp[1][2] == 'X' ) return 2;

        if( mp[1][3] == mp[2][3] && mp[2][3] == mp[3][3] && mp[1][3] == 'O' ) return 1;
        if( mp[1][3] == mp[2][3] && mp[2][3] == mp[3][3] && mp[1][3] == 'X' ) return 2;

        if( mp[1][1] == mp[2][2] && mp[2][2] == mp[3][3] && mp[1][1] == 'O' ) return 1;
        if( mp[1][1] == mp[2][2] && mp[2][2] == mp[3][3] && mp[1][1] == 'X' ) return 2;

        if( mp[1][3] == mp[2][2] && mp[2][2] == mp[3][1] && mp[1][3] == 'O' ) return 1;
        if( mp[1][3] == mp[2][2] && mp[2][2] == mp[3][1] && mp[1][3] == 'X' ) return 2;
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[][] mp = new char[4][4];
        boolean ok = true;
        int x = 0, o = 0,win = 0;
        for(int i=1;i<=9;i++) {
            int idx = 0;
            if( i % 3 == 0 ) idx = 1;
            int idx2 = 0;
            if(  i % 3 == 0 ) idx2 = 3;
            mp[i/3+1-idx][i%3+idx2] = s.charAt(i-1);
            if( s.charAt(i-1) == 'X' ) x++;
            else if( s.charAt(i-1) == 'O' ) o++;
        }

        if( o > x ) ok = false;
        if( Math.abs(o-x) > 1 ) ok = false;
        if( isWin(mp) == 2 && ( o >= x || x - 1 > o ) ) ok = false;
        if( isWin(mp) == 1 && ( x >= o || o - 1 > x ) ) ok = false; 
        if( ok == false ) System.out.println("invalid");
        else System.out.println("valid");
    }
}