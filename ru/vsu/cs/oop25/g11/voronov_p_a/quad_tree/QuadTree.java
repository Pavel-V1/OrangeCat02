package ru.vsu.cs.oop25.g11.voronov_p_a.quad_tree;

import java.util.Comparator;

public class QuadTree<T> {

    public QuadTree(Comparator<T> comparator1, Comparator<T> comparator2) {

    }

    protected class QTreeNode {
        public T value;
        public QTreeNode left_down;
        public QTreeNode left_up;
        public QTreeNode right_down;
        public QTreeNode right_up;

        public QTreeNode(T value, QTreeNode left_down, QTreeNode left_up, QTreeNode right_down, QTreeNode right_up) {
            this.value = value;
            this.left_down = left_down;
            this.left_up = left_up;
            this.right_down = right_down;
            this.right_up = right_up;
        }

        public QTreeNode(T value) {
            this(value, null, null, null, null);
        }

        public QTreeNode getLeft_back(QTreeNode q) {
            return q.left_down;
        }

        public QTreeNode getRight_back(QTreeNode q) {
            return q.right_down;
        }

        public QTreeNode getLeft_front(QTreeNode q) {
            return q.left_up;
        }

        public QTreeNode getRight_front(QTreeNode q) {
            return q.right_up;
        }
    }

    private Comparator<T> byX;
    private Comparator<T> byY;

    private QTreeNode findQTNode(QTreeNode qtNode, T t) {
        QTreeNode cur = qtNode;
        while (cur.value != t) {
            if (byX.compare(t, cur.value) >= 0) {
                if (byY.compare(t, cur.value) >= 0) {
                    if (cur.right_up != null) {
                        cur = cur.right_up;
                    } else {
                        break;
                    }
                } else {
                    if (cur.right_down != null) {
                        cur = cur.right_down;
                    } else {
                        break;
                    }
                }
            } else {
                if (byY.compare(t, cur.value) >= 0) {
                    if (cur.left_up != null) {
                        cur = cur.left_up;
                    } else {
                        break;
                    }
                } else {
                    if (cur.left_down != null) {
                        cur = cur.left_down;
                    } else {
                        break;
                    }
                }
            }
        }
        return cur;
    }

    public QTreeNode getQTreeNode(T t) {
        if (root == null) {
            return null;
        } else if (t.equals(root.value)) {
            return root;
        } else {
            QTreeNode cur = findQTNode(root, t);
            if (cur.value.equals(t)) {
                return cur;
            } else {
                return null;
            }
        }
    }

    public T getValue(QTreeNode q) {
        return q.value;
    }

    public void setValue(T t) {
        QTreeNode newQNode = new QTreeNode(t);
        if (root == null) {
            root = newQNode;
        } else {
            QTreeNode cur = findQTNode(root, t);
            if (!cur.value.equals(t)) {
                if (byX.compare(t, cur.value) >= 0) {
                    if (byY.compare(t, cur.value) >= 0) {
                        cur.right_up = newQNode;
                    } else {
                        cur.right_down = newQNode;
                    }
                } else {
                    if (byY.compare(t, cur.value) >= 0) {
                        cur.left_up = newQNode;
                    } else {
                        cur.left_down = newQNode;
                    }
                }
            }
//                else {
//                    cur.right_up = newQNode; // т.к. byX = 0 -> right и byY = 0 -> up
//                }
        }


    }

    public boolean deleteValue(T t) {
        QTreeNode cur = root;
        QTreeNode prev = null;
        while (cur.value != t) {
            prev = cur;
            if (byX.compare(t, cur.value) >= 0) {
                if (byY.compare(t, cur.value) >= 0) {
                    if (cur.right_up != null) {
                        cur = cur.right_up;
                    } else {
                        break;
                    }
                } else {
                    if (cur.right_down != null) {
                        cur = cur.right_down;
                    } else {
                        break;
                    }
                }
            } else {
                if (byY.compare(t, cur.value) >= 0) {
                    if (cur.left_up != null) {
                        cur = cur.left_up;
                    } else {
                        break;
                    }
                } else {
                    if (cur.left_down != null) {
                        cur = cur.left_down;
                    } else {
                        break;
                    }
                }
            }
        }
        if (prev.left_down.value == t) {
            prev.left_down = null;
            return true;
        } else if (prev.left_up.value == t) {
            prev.left_up = null;
            return true;
        } else if (prev.right_up.value == t) {
            prev.right_up = null;
            return true;
        } else if (prev.right_down.value == t) {
            prev.right_down = null;
            return true;
        } else {
            return false;
        }
    }

    protected QTreeNode root = null;



//    public T getMinHorizontal(QTreeNode qtn) {
//        if (root == null) {
//            return null;
//        } else {
//            QTreeNode cur = qtn;
//            while (cur.left != null) {
//                cur = cur.left;
//            }
//            return cur.value;
//        }
//    }
//
//    public T getMaxHorizontal(QTreeNode qtn) {
//        if (root == null) {
//            return null;
//        } else {
//            QTreeNode cur = qtn;
//            while (cur.right != null) {
//                cur = cur.right;
//            }
//            return cur.value;
//        }
//    }
//
//    public T getMinVertical(QTreeNode qtn) {
//        if (root == null) {
//            return null;
//        } else {
//            QTreeNode cur = qtn;
//            while (cur.back != null) {
//                cur = cur.back;
//            }
//            return cur.value;
//        }
//    }
//
//    public T getMaxVertical(QTreeNode qtn) {
//        if (root == null) {
//            return null;
//        } else {
//            QTreeNode cur = qtn;
//            while (cur.front != null) {
//                cur = cur.front;
//            }
//            return cur.value;
//        }
//    }
}