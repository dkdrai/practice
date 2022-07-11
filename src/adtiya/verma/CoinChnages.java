package adtiya.verma;



// A Naive recursive JAVA program to find minimum of coins
// to make a given change V
class coin
{
    // m is size of coins array (number of different coins)
    static int minCoins( int m, int V)
    {

        if (V == 0){
             return 0;
        }
        int sol = 0;
        for(int i =m; i>0; i--){
            sol = sol + minCoins(m-1, V-m)+1;
        }
        return sol;
    }
    public static void main(String args[])
    {

        System.out.println("Minimum coins required is "+ minCoins(5,8) );
    }
}/* This code is contributed by Rajat Mishra */
