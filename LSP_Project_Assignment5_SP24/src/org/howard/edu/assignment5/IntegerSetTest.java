package org.howard.edu.assignment5;

import static org.junit.jupiter.api.Assertions.*;

import org.howard.edu.lsp.assignment5.IntegerSet;
import org.junit.jupiter.api.*;

public class IntegerSetTest {

    private IntegerSet setA;
    private IntegerSet setB;

    @BeforeEach
    public void setUp() {
        setA = new IntegerSet();
        setB = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        setA.add(1);
        setA.add(2);
        setA.clear();
        assertTrue(setA.isEmpty());
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        setA.add(1);
        setA.add(2);
        assertEquals(2, setA.length());
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(1);
        assertTrue(setA.equals(setB));
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        setA.add(1);
        setA.add(2);
        assertTrue(setA.contains(1));
        assertFalse(setA.contains(3));
    }

    @Test
    @DisplayName("Test case for largest with non-empty set")
    public void testLargestNonEmpty() throws Exception {
        setA.add(1);
        setA.add(2);
        assertEquals(2, setA.largest());
    }

    @Test
    @DisplayName("Test case for largest with empty set")
    public void testLargestEmpty() {
        assertThrows(IntegerSetException.class, () -> {
            setA.largest();
        });
    }

    @Test
    @DisplayName("Test case for smallest with non-empty set")
    public void testSmallestNonEmpty() throws Exception {
        setA.add(1);
        setA.add(2);
        assertEquals(1, setA.smallest());
    }

    @Test
    @DisplayName("Test case for smallest with empty set")
    public void testSmallestEmpty() {
        assertThrows(IntegerSetException.class, () -> {
            setA.smallest();
        });
    }

    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        setA.add(1);
        assertTrue(setA.contains(1));
    }

    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        setA.add(1);
        setA.remove(1);
        assertFalse(setA.contains(1));
    }

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        setA.add(1);
        setB.add(2);
        setA.union(setB);
        assertTrue(setA.contains(1));
        assertTrue(setA.contains(2));
    }

    @Test
    @DisplayName("Test case for intersection")
    public void testIntersect() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        setA.intersect(setB);
        assertTrue(setA.contains(2));
        assertFalse(setA.contains(1));
    }

    @Test
    @DisplayName("Test case for difference")
    public void testDiff() {
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        setA.diff(setB);
        assertTrue(setA.contains(1));
        assertFalse(setA.contains(2));
    }

    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
        setA.add(1);
        setA.add(2);
        setA.complement(setB);
        assertTrue(setB.contains(3));
        assertTrue(setB.contains(4));
    }

    @Test
    @DisplayName("Test case for isEmpty with empty set")
    public void testIsEmptyEmpty() {
        assertTrue(setA.isEmpty());
    }

    @Test
    @DisplayName("Test case for isEmpty with non-empty set")
    public void testIsEmptyNonEmpty() {
        setA.add(1);
        assertFalse(setA.isEmpty());
    }

    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        setA.add(1);
        setA.add(2);
        assertEquals("[1, 2]", setA.toString());
    }
}
