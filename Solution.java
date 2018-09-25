
/* 
@author Chanon Panpila 
@email nonpanpila@gmail.com
FB: Chanon Panpila

--- solve by Matrix + Divide & Conquer ---
this version has been removed Console.log**

Editor : VSCODE 
*/

import java.lang.*;
import java.util.Arrays;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {

        // 0 to 20
        for (int i = 0; i < 11; i++) {
            System.out.println(solveRobotExercise(i));
        }

        // System.out.println(customFact(5, 1, 0));
        // System.out.println(customFact(4, 2, 1));
    }

    /*
     * @Matrix A is 2 x 3
     * 
     * @row 1 | a b c |
     * 
     * @row 2 | 0 a+b a+c |
     * 
     * @Matrix B is 2 x 3
     * 
     * @row 1 | -1 1 1 |
     * 
     * @row 2 | 0 -1 4 |
     * 
     * @operation summation of nPr(A) + iB where i=1;i<=a;i++
     */
    public static BigInteger solveRobotExercise(int n) {

        int a = (int) Math.floor(n / 5);
        int b = (int) Math.floor((n % 5) / 4);
        int c = b == 1 ? 0 : n - (int) a * 5;
        BigInteger result = new BigInteger("0");

        if (n == 0)
            return BigInteger.ZERO;

        else if (n < 4)
            return new BigInteger("1");

        else if (n == 4)
            return new BigInteger("2");

        int[][] A = { { a, b, c }, { 0, a + b, a + c } };

        BigInteger nPrA1 = M1(A[0][0], A[0][1], A[0][2]);

        result = result.add(nPrA1);

        BigInteger nPrA2 = M2(A[1][0], A[1][1], A[1][2]);

        result = result.add(nPrA2);

        result = result.add(BigInteger.valueOf(1));

        return result;
    }

    public static BigInteger M1(int a, int b, int c) {
        BigInteger nPrM1 = customFact(a, b, c);

        if (a == 1) {
            return nPrM1;
        }

        return M1(a - 1, b + 1, c + 1).add(nPrM1);
    }

    public static BigInteger M2(int a, int b, int c) {
        BigInteger nPrM2 = customFact(a, b, c);

        if (b == 1) {
            return nPrM2;
        }

        return M2(a, b - 1, c + 4).add(nPrM2);
    }

    /*
     * 1. sort divider a,b,c --> a <= b <= c
     */
    public static BigInteger customFact(int a, int b, int c) {
        int numerator = a + b + c;
        int[] arr = { a, b, c };
        Arrays.sort(arr);
        int maxDivider = arr[2];

        if (numerator == maxDivider)
            return new BigInteger("1");

        else {
            BigInteger BigNumerator = FactNtoMaxD(BigInteger.valueOf(numerator), BigInteger.valueOf(maxDivider));

            int subDivider = arr[1];

            if (arr[0] == 0) {
                BigInteger bigDivider = Fact(BigInteger.valueOf(subDivider));
                return BigNumerator.divide(bigDivider);
            }

            else if (arr[0] > 0 && arr[1] > 0) {
                int subtraction = arr[1] - arr[0];

                if (subtraction == 0) {
                    BigInteger sqrFact = FactSquare(BigInteger.valueOf(arr[0]));

                    return BigNumerator.divide(sqrFact);
                }

                /* fact x factSquare */
                else if (subtraction > 1) {
                    BigInteger nFact = FactNtoMaxD(BigInteger.valueOf(arr[1]), BigInteger.valueOf(arr[0]));
                    BigInteger sqrFact2 = FactSquare(BigInteger.valueOf(arr[0]));
                    BigInteger tempFF2 = nFact.multiply(sqrFact2);

                    return BigNumerator.divide(tempFF2);

                }
            }
        }

        return new BigInteger("1");
    }

    public static BigInteger FactSquare(BigInteger n) {

        if (n.compareTo(new BigInteger("2")) == -1) {
            return new BigInteger("1");
        }

        BigInteger a = new BigInteger("1");
        BigInteger c = n.subtract(a);

        return FactSquare(c).multiply(n.pow(2));
    }

    public static BigInteger Fact(BigInteger n) {

        if (n.compareTo(new BigInteger("2")) == -1) {
            return new BigInteger("1");
        }

        BigInteger a = new BigInteger("1");
        BigInteger c = n.subtract(a);

        return n.multiply(Fact(c));
    }

    public static BigInteger FactNtoMaxD(BigInteger n, BigInteger maxD) {

        BigInteger one = new BigInteger("1");

        if (n.compareTo(maxD) == 1) {
            BigInteger t = n.subtract(one);
            return FactNtoMaxD(t, maxD).multiply(n);
        }

        if (n.compareTo(new BigInteger("2")) == -1) {
            return one;
        }

        return one;
    }

}
