// Maximum size subset with given sum
// Find the size of the maximum size subset whose sum is equal to the given sum.
// Examples:  
// Input : set[] = {2, 3, 5, 7, 10, 15},
// sum  = 10
// Output : 3
// The largest sized subset with sum 10 is {2, 3, 5}
// Input : set[] = {1, 2, 3, 4, 5} 
// sum = 4
// Output : 2

class MaxSubsetSum {

    static int isSubsetSum(int set[], int n, int sum) {

        boolean subset[][] = new boolean[sum + 1][n + 1];
        int count[][] = new int[sum + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
            count[0][i] = 0;
        }

        for (int i = 1; i <= sum; i++) {
            subset[i][0] = false;
            count[i][0] = -1;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                count[i][j] = count[i][j - 1];
                if (i >= set[j - 1]) {
                    subset[i][j] = subset[i][j] ||
                            subset[i - set[j - 1]][j - 1];

                    if (subset[i][j])
                        count[i][j] = Math.max(count[i][j - 1],
                                count[i - set[j - 1]][j - 1] + 1);
                }
            }
        }

        return count[sum][n];
    }

    public static void main(String args[]) {
        int set[] = { 2, 3, 5, 10 };
        int sum = 20;
        int n = set.length;
        System.out.println(isSubsetSum(set, n, sum));
    }
}
