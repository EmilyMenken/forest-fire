import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FireTest {
    @Test
    public void testTimeToBurnExample() {
        char[][] forest = {
            {'t','.','.','t','t','t','t','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 8;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testSingleTree() {
        char[][] forest = {
            {'.','.','.'},
            {'.','t','.'},
            {'.','.','.'}
        };

        int matchR = 1;
        int matchC = 1;

        int expected = 0;  // burns immediately
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }//end testSingleTree

    @Test
    public void testFarAwayTrees() {
        char[][] forest = {
            {'t','.','t'},
            {'.','.','.'},
            {'t','.','t'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 0;  //trees are too far to be burned
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }//end testFarAwayTrees

    @Test
    public void testTreesConnected() {
        char[][] forest = {
            {'t','t','t'},
            {'t','t','t'},
            {'t','t','t'}
        };

        int matchR = 1;
        int matchC = 1;

        int expected = 2;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }//end testTreesConnected

    @Test
    public void testOutOfBounds() {
        char[][] forest = {
            {'t','t','t'},
            {'t','t','t'},
            {'t','t','t'}
        };

        //out of bounds
        int matchR = -1;
        int matchC = 5;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Fire.timeToBurn(forest, matchR, matchC);
        });
    }//end testOutOfBounds

    @Test
    public void testNoFire() {
        char[][] forest = {
            {'t', 't', 't'},
            {'t', '.', 't'},
            {'t', 't', 't'}
        };

        int matchR = 1;
        int matchC = 1;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }//end testNoFire



}//end file
