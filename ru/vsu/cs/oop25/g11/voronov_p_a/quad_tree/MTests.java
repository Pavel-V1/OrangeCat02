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
        qt.getQTreeNode(new Point(2, 4));

    }
}
