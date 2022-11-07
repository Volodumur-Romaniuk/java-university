package solution;

//Case7. Единицы массы пронумерованы следующим образом: 1 — килограмм, 2 — миллиграмм, 3 — грамм, 4 — тонна, 5 — центнер.
// Дан номер единицы массы (целое число в диапазоне 1–5) и масса тела в этих единицах (вещественное число). Найти массу тела в килограммах.
//For7. Даны два целых числа A и B (A < B). Найти сумму всех целых чисел от A до B включительно.
//While7*. Дано целое число N (> 0). Найти наименьшее целое положительное число K, квадрат которого превосходит N:
//K2 > N. Функцию извлечения квадратного корня не использовать.
//Array7*. Дан массив размера N. Вывести его элементы в обратном порядке.
//Matrix7*. Дана матрица размера M i N и целое число K (1 <= K <= M). Вывести элементы K-й строки данной матрицы.
public class Solution {
    /**
     * Given two-digit number
     * @param ab
     * @return sum && mul
     */
    public SumMul sumMul(int ab){
        SumMul res = new SumMul((ab/10)+ab%10,(ab/10)*(ab%10));
        return res;
    }

    /**
     * Three numbers A B C are given
     * @param a
     * @param b
     * @param c
     * @return a < b < c
     */
    public  boolean betweenAC(int a,int b,int c){
        return b > a && b < c;
    }

    /**
     * Two numbers A B are given
     * @param a
     * @param b
     * @return less than A B
     */
    public int indexSmaller(int a, int b){
        return a < b ? 1 : 2;
    }

    /**
     * Units of mass are numbered as folows: 1 - kg, 2 - miligram, 3 - gram 4-ton, 5 centner
     * @param n
     * @param m
     * @return data in kg
     */
    public static double findBodyWeightKg(int n,int m){
        switch (n){
            case 1:
                return m;
            case 2:
                return m / 1000000.0;
            case 3:
                return m / 1000.0;
            case 4:
                return m * 1000;
            case 5:
                return m * 100;
            default: return 0;
        }
    }

    /**
     * Given two numbers A and B
     * @param a
     * @param b
     * @return numbers between [a,b]
     */
    public int arrayBetweenAB(int a, int b){
        int sum = 0;

        if(a < b){
            for(int i=a;i<=b;i++){
                sum+=i;
            }
        } else if (a > b) {
            for(int i=a;i>=b;i--){
                sum+=i;
            }
        }
        else sum = a+b;

        return sum;
    }

    /**
     * Given n
     * @param n
     * @return first number^2 > n
     */
    public int smallestKexcelN( int n){
        int k = 1;
        while (k*k <= n) {
            k++;
        }
        return k;
    }

    /**
     * Given array
     * @param A
     * @return reverse array
     */
    public  int[] reverseArray(int A[]){
         int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[A.length-1-i] = A[i];
        }

        return res;
    }

    /**
     * Given matrix
     * @param A
     * @param k
     * @return k-th row
     */
    public  int[] arrayKRow(int A[][], int k){
        int[] res = new int[A.length];
        
        for (int j = 0; j < A[0].length; ++j){
            res[j] = A[k][j];
        }

        return res;
    }


}
