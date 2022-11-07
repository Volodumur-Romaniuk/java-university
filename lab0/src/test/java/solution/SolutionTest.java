package solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    private Solution solution = new Solution();
    @Test
    void sumMul() {
        var SumMul = new SumMul(3,2);
        assertEquals(SumMul.sum, solution.sumMul(12).sum);
    }

    @Test
    void falselySumMul() {
        var SumMul = new SumMul(4,1);
        assertEquals(SumMul.sum, solution.sumMul(12).sum);
    }
    @Test
    void betweenAC() {
        assertEquals(true, solution.betweenAC(1,2,3));
    }

    @Test
    void notBetweenAC() {
        assertEquals(false, solution.betweenAC(2,1,3));
    }
    @Test
    void indexSmaller() {
        assertEquals(1,solution.indexSmaller(5,10));
    }
    @Test
    void indexBigger() {
        assertEquals(2,solution.indexSmaller(5,10));
    }

    @Test
    void findBodyWeightKg() {
        assertEquals(1,solution.findBodyWeightKg(1,1));
    }
    @Test
    void falselyFindBodyWeightKg() {
        assertEquals(2,solution.findBodyWeightKg(1,1));
    }

    @Test
    void arrayBetweenAB() {
        assertEquals(6,solution.arrayBetweenAB(1,3));
    }
    @Test
    void falselyArrayBetweenAB() {
        assertEquals(4,solution.arrayBetweenAB(1,3));
    }

    @Test
    void smallestKexcelN() {
        assertEquals(3,solution.smallestKexcelN(5));
    }

    @Test
    void reverseArray() {
        assertArrayEquals(new int[]{1,2,3},solution.reverseArray(new int[]{3,2,1}));
    }

    @Test
    void arrayKRow() {
        assertArrayEquals(new int[]{4,5,6},solution.arrayKRow(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        },1));
    }
}