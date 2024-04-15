import java.util.Scanner;
public class HW5 {
    public static boolean ans = false;
    public static char[][] mp = new char[1001][1001];
    public static void solve(int x,int y,int n,int m,String tmp,String target) {
        if( tmp.length() > target.length() ) return;
        if( x == 0 || y == 0 || x > n || y > m ) return;
        String tmp2 = tmp; 
        tmp += mp[x][y];
        if( tmp.equals(target) == true ) {
            ans = true;
            return;
        }
        solve(x+1,y,n,m,tmp,target);
        solve(x-1,y,n,m,tmp,target);
        solve(x,y-1,n,m,tmp,target);
        solve(x,y+1,n,m,tmp,target);
        tmp = tmp2;
    }
    public static void main(String[] args) {
        String tmp = "";
        String target;
        int n,m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                mp[i][j] = scanner.next().charAt(0);
            }
        }

        target = scanner.nextLine();
        target = scanner.nextLine();
        for(int i=1;i<=n;i++) for(int j=1;j<=m;j++) solve(i,j,n,m,tmp,target);
        System.out.println(ans);
    }
}