package ru.vsu.cs.oop25.g11.voronov_p_a.quad_tree;

import java.util.Comparator;

public class DemoApp {
    public static void main(String[] args) {
        class Point{double x; double y;}

//        QuadTree<Point> qt = new QuadTree<>(new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {
//                return o1.x ???? o2.x;
//            }
//        }, new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {
//                return o1.y ???? o2.y;
//            }
//        }) ;

        QuadTree<String> qs = new QuadTree<>(new Comparator<String>() {
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

    }
}