package ru.vsu.cs.oop25.g11.voronov_p_a.quad_tree;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    public void testQuadTree() {
        QuadTree<String> qt = new QuadTree<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        assertNull(qt.root);
    }
}
