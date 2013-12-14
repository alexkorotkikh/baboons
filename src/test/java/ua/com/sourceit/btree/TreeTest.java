package ua.com.sourceit.btree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: alexkorotkikh
 * Date: 12/7/13
 * Time: 1:22 AM
 */
public class TreeTest {
    @Test
    public void testDepth_onlyRoot() throws Exception {
        //Given
        Tree<Integer> tree = new Tree<Integer>(1);

        //When
        int depth = tree.depth();

        //Then
        assertEquals(1, depth);
    }

    @Test
    public void testDepth_onlyLeft() throws Exception {
        Tree<Integer> tree = new Tree<Integer>(5);
        tree.add(3);

        int depth = tree.depth();

        assertEquals(2, depth);
    }

    @Test
    public void testDepth_onlyRight() throws Exception {
        Tree<Integer> tree = new Tree<Integer>(5);
        tree.add(8);

        int depth = tree.depth();

        assertEquals(2, depth);
    }

    @Test
    public void testDepth_twoSubtreesDifferentDepth() throws Exception {
        Tree<Integer> tree = new Tree<Integer>(5);
        tree.add(3);
        tree.add(8);
        tree.add(6);
        tree.add(9);

        int depth = tree.depth();

        assertEquals(3, depth);

    }
}