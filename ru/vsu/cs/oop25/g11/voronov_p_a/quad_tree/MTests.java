package ru.vsu.cs.oop25.g11.voronov_p_a.quad_tree;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class MTests {
    @Test
    public void testQuadTree() {
        QuadTree<Point> qt = new QuadTree<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        }, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y - o2.y;
            }
        });

        assertNull(qt.root);
        qt.setValue(new Point(2, 4));
        assertEquals(qt.getQTreeNode(new Point(2, 4)), qt.root);
        assertFalse(qt.deleteValue(new Point(3, 2)));
        assertTrue(qt.deleteValue(new Point(2, 4)));
        assertNull(qt.getQTreeNode(new Point(2, 4)));
        assertNull(qt.root);
    }

    @Test
    public void testQuadTree2() {
        QuadTree<Point> qt = new QuadTree<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        }, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y - o2.y;
            }
        });

        qt.setValue(new Point(2, 4));
        qt.setValue(new Point(3, 2));
        assertTrue(qt.deleteValue(new Point(3, 2)));
        assertFalse(qt.deleteValue(new Point(3, 2)));
        assertTrue(qt.deleteValue(new Point(2, 4)));
        assertNull(qt.getQTreeNode(new Point(3, 2)));
        assertNull(qt.root);
        qt.setValue(new Point(2, 4));
        qt.setValue(new Point(5, 4));
        qt.setValue(new Point(2, 3));
        qt.clearTree();
        assertNull(qt.root);
    }
}
