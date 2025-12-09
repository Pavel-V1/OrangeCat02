package ru.vsu.cs.oop25.g11.voronov_p_a.quad_tree;

import java.awt.*;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DemoApp {
    public static void main(String[] args) {
        class Point{double x; double y;}

        QuadTree<java.awt.Point> qt = new QuadTree<>(new Comparator<java.awt.Point>() {
            @Override
            public int compare(java.awt.Point o1, java.awt.Point o2) {
                return o1.x - o2.x;
            }
        }, new Comparator<java.awt.Point>() {
            @Override
            public int compare(java.awt.Point o1, java.awt.Point o2) {
                return o1.y - o2.y;
            }
        });

        qt.setValue(new java.awt.Point(2, 4));
        assertTrue(qt.deleteValue(new java.awt.Point(2, 4)));
        assertNull(qt.getQTreeNode(new java.awt.Point(2, 4)));
        assertNull(qt.root);
    }
}