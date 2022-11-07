package solution;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int [] arr = {1,3,5,6,75,81,7,4};
        int [][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Solution obj = new Solution();
        var res_sol1 = obj.sumMul(25);
        res_sol1.output();
        System.out.println("sol2= "+obj.betweenAC(1,2,3));
        System.out.println("sol3= "+obj.indexSmaller(2,1));
        System.out.println("sol4= "+obj.findBodyWeightKg(2,20));
        System.out.println("sol5= "+obj.arrayBetweenAB(3, 3));
        System.out.println("sol6= "+obj.smallestKexcelN(5));
        System.out.println("sol7= "+Arrays.toString(obj.reverseArray(arr)));
        System.out.println("sol8= "+Arrays.toString(obj.arrayKRow(matrix,2)));

    }
}
