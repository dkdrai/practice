class Solution {

    public static void main(String args[]) {
        //String b[] = {"X.....>","..v..X.",".>..X..","A......"};
        String b[] = {"...Xv","AX..^",".XX.."};
        System.out.println(solution(b));
    }

    static int solutionOther(int N, int K) {
        int ans = 0;
        while (K >= 0) {
            if (N == 0) return -1; // No glasses left
            if (N >= K) {
                // K litres glass available, so just one more glass
                ans++;
                break;
            } else {
                // Take biggest glass, update N, and K accordingly
                ans++;
                K = K - N;
                N = N - 1;
            }
        }
        return ans;
    }
co
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
                        if (B[i].charAt(k) != '.')
                            break;
                        mat[i][k] = true;
                    }

                else if (B[i].charAt(j) == '^')
                    for (int k = i; k >= 0; k--) {
                        if (B[k].charAt(j) == 'A')
                        if (B[k].charAt(j) != '.')
                            break;
                        mat[k][j] = true;
                    }
                else if (B[i].charAt(j) == '<')
                    for (int k = j; k >= 0; k--) {
                        if (B[i].charAt(k) == 'A')
                        if (B[i].charAt(k) != '.')
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
                        if (B[k].charAt(j) != '.')
                            break;
                        mat[k][j] = true;
                    }
            }

        return dfs(x, y);
    }

}