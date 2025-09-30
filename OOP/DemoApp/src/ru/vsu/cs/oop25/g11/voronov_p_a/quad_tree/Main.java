package ru.vsu.cs.oop25.g11.voronov_p_a.quad_tree;

import ru.vsu.cs.oop25.g11.voronov_p_a.newnewnew.Animation;

public class Main {
    public static void main(String[] args) {
        QuadTree quadTree = new QuadTree();
        quadTree.print();
        quadTree.greeting("world, look at this");

        Animation animation = new Animation();
        animation.animationPush();
    }
}