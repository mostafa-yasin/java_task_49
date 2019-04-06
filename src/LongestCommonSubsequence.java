
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LongestCommonSubsequence {

   
    static void lcs(ArrayList south, ArrayList nourth) {
      int n=south.size();
      int m= nourth.size();
      
        int[][] C = new int[m + 1][n + 1];
        char[][] B = new char[m + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            C[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            C[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (south.get(i - 1) == nourth.get(j - 1)) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                    B[i][j] = 'D';
                } else if (C[i - 1][j] >= C[i][j - 1]) {
                    C[i][j] = C[i - 1][j];
                    B[i][j] = 'U';
                } else if (C[i - 1][j] <= C[i][j - 1]) {
                    C[i][j] = C[i][j - 1];
                    B[i][j] = 'L';
                }
            }
        }
        System.out.println("maximum number of bridges is "+C[m][n]);
        printLCS(B,south,south.size(),nourth.size());
    }

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        System.out.println("enter the number of city that less than or equal to 100");
        int x = read.nextInt();
        if (x > 100) {
            System.out.println("wrong number ");
        } else {

            ArrayList<Integer> nourth = new ArrayList();
            for (int i = 1; i <= x; i++) {
                nourth.add(i);
            }

            ArrayList<Integer> south = new ArrayList();
            for (int i = 1; i <= x; i++) {
                south.add(i);
            }
            Collections.shuffle(south);
            System.out.println(nourth);
            System.out.println(south);
                 lcs(south, nourth);
        }

    }

    public static void printLCS(char[][] B, ArrayList south, int i, int j) {
        if (i == 0 && j == 0) {
            return;
        }
        if (B[i][j] == 'D') {
            printLCS(B, south, i - 1, j - 1);
            System.out.print(south.get(i-1)+" ");
        } else if (B[i][j] == 'U') {
            printLCS(B, south, i - 1, j);
        } else {
            printLCS(B, south, i, j - 1);
        }
    }
}
