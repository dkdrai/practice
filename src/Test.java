import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String args[]) {
        String b[] = {".v.", "...", "A.."};
        System.out.println(solution(b));
    }

    static boolean mat[][] = new boolean[501][501];
    static boolean vis[][] = new boolean[501][501];
    static int n, m;


    static boolean dfs(int x, int y) {

        if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y] || mat[x][y])
            return false;
        vis[x][y] = true;
        if (x == m - 1 && y == n - 1)
            return true;
        return dfs(x - 1, y) || dfs(x + 1, y) || dfs(x, y - 1) || dfs(x, y + 1);
    }


    static boolean solution(String[] B) {
        m = B.length;
        n = B[0].length();
        int x = 0;
        int y = 0;
        for (int i = 0; i < 501; i++) {
            for (int j = 0; j < 501; j++) {
                mat[i][j] = false;
                vis[i][j] = false;
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (B[i].charAt(j) == 'X')
                    mat[i][j] = true;
                else if (B[i].charAt(j) == '>')
                    for (int k = j; k < n; k++) {
                        if (B[i].charAt(k) == 'A')
                            return false;
                        if (B[i].charAt(k) != '.')
                            break;
                        mat[i][k] = true;
                    }
                else if (B[i].charAt(j) == '^')
                    for (int k = i; k >= 0; k--) {
                        if (B[k].charAt(j) == 'A')
                            return false;
                        if (B[k].charAt(j) != '.')
                            break;
                        mat[k][j] = true;
                    }
                else if (B[i].charAt(j) == '<')
                    for (int k = j; k >= 0; k--) {
                        if (B[i].charAt(j) == 'A')
                            return false;
                        if (B[i].charAt(j) != '.')
                            break;
                        mat[i][k] = true;
                    }
                else if (B[i].charAt(j) == '.')
                    continue;
                else if (B[i].charAt(j) == 'A') {
                    x = i;
                    y = j;
                    continue;
                } else
                    for (int k = i; k < m; k++) {
                        if (B[k].charAt(j) == 'A')
                            return false;
                        if (B[k].charAt(j) != '.')
                            break;
                        mat[k][j] = true;
                    }
            }
        return dfs(x, y);
    }


}

