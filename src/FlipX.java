public class FlipX {

    public static void main(String ar[]) {
        char arr[] = {' ', '0', '0', '0', ' ', ' ', '0', '0', 'x', '0', '0', 'x'};
        int sol[] = flip(arr);
        System.out.println(sol[0]);
        System.out.println(sol[1]);
    }

    public  static int[]  flip(char arr[]) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                int start = i;
                int lcount = 0;
                while (arr[i] == '0') {
                    i++;
                    lcount++;
                }
                if (start - 1 >= 0) {
                    if (arr[start - 1] == 'x' && arr[i] == 'x') {
                        max = Math.max(max, lcount);
                    } else if (arr[start - 1] == ' ' && arr[i] == 'x') {
                        index = start-1;
                        max = Math.max(max, lcount);
                    } else if (arr[start - 1] == 'x' && arr[i] == ' ') {
                        index = i;
                        max = Math.max(max, lcount);
                    }
                }
            }
        }
        int sol[] = new int[2];
        sol[0] = index;
        sol[1] = max;
        return sol;
    }
}
