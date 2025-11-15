package ru.vsu.cs.oop25.g11.voronov_p_a.quad_tree;

import java.util.Comparator;
import java.util.function.Function;

public class QuadTree<T> {

    public QuadTree(Comparator<String> stringComparator, Comparator<String> stringComparator1) {

    }

    protected class QTreeNode {
        public T value;
        public QTreeNode left_down;
        public QTreeNode left_up;
        public QTreeNode right_down;
        public QTreeNode right_up;

        public QTreeNode(T value, QTreeNode left_down, QTreeNode right_down, QTreeNode left_up, QTreeNode right_up) {
            this.value = value;
            this.left_down = left_down;
            this.left_up = left_up;
            this.right_down = right_down;
            this.right_up = right_up;
        }

        public QTreeNode(T value) {
            this(value, null, null, null, null);
        }

        public QTreeNode getQTreeNode(T t) {
            if (root == null) {
                return null;
            } else if (t.equals(root.value)) {
                return root;
            } else {
                QTreeNode cur = root;
                while (cur.value != null && cur.value != t) {
                    if (byX.compare(t, cur.value) < 0) {
                        if (byY.compare(t, cur.value) >= 0) {
                            cur = cur.left_up;
                        } else if (byY.compare(t, cur.value) < 0) {
                            cur = cur.left_down;
                        }
                    } else if (byX.compare(t, cur.value) >= 0) {
                        if (byY.compare(t, cur.value) >= 0) {
                            cur = cur.right_up;
                        } else if (byY.compare(t, cur.value) < 0) {
                            cur = cur.right_down;
                        }
                    }
                }
                if (cur.value == null) {
                    return null;
                } else {
                    return cur;
                }
            }
        }

        public void setValue(T t) {
            QTreeNode newQNode = new QTreeNode(t);
            if (root == null) {
                root = newQNode;
            } else {
                QTreeNode cur = root;
                while (cur.value != null) {
                    if (byX.compare(t, cur.value) < 0) {
                        if (byY.compare(t, cur.value) >= 0) {
                            cur = cur.left_up;
                        } else if (byY.compare(t, cur.value) < 0) {
                            cur = cur.left_down;
                        }
                    } else if (byX.compare(t, cur.value) >= 0) {
                        if (byY.compare(t, cur.value) >= 0) {
                            cur = cur.right_up;
                        } else if (byY.compare(t, cur.value) < 0) {
                            cur = cur.right_down;
                        }
                    }
                    cur = newQNode;
                }
            }
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

    public T getValue(QTreeNode qtn) {
        return qtn.value;
    }

    public boolean deleteValue() {

        return false;
    }

//    protected Function<String, T> fromStrFunc;
//    protected Function<T, String> toStrFunc;


    private Comparator<T> byX;
    private Comparator<T> byY;

//    public QuadTree( Comparator<T> x, Comparator<T> y, Function<String, T> fromStrFunc, Function<T, String> toStrFunc) {
//        this.fromStrFunc = fromStrFunc;
//        this.toStrFunc = toStrFunc;
//
//
//    }
//
//    public QuadTree(Function<String, T> fromStrFunc) {
//        this(fromStrFunc, Object::toString);
//    }
//
//    public QuadTree() {
//        this(null);
//    }

    public QTreeNode getRoot() {
        return root;
    }

    public void clear() {
        root = null;
    }

//    private T fromStr(String s) throws Exception {
//        s = s.trim();
//        if (s.length() > 0 && s.charAt(0) == '"') {
//            s = s.substring(1);
//        }
//        if (s.length() > 0 && s.charAt(s.length() - 1) == '"') {
//            s = s.substring(0, s.length() - 1);
//        }
//        if (fromStrFunc == null) {
//            throw new Exception("Не определена функция конвертации строки в T");
//        }
//        return fromStrFunc.apply(s);
//    }
//
//    private static class IndexWrapper {
//        public int index = 0;
//    }
//
//    private void skipSpaces(String bracketStr, IndexWrapper iw) {
//        while (iw.index < bracketStr.length() && Character.isWhitespace(bracketStr.charAt(iw.index))) {
//            iw.index++;
//        }
//    }
//
//    private T readValue(String bracketStr, IndexWrapper iw) throws Exception {
//        // пропуcкаем возможные пробелы
//        skipSpaces(bracketStr, iw);
//        if (iw.index >= bracketStr.length()) {
//            return null;
//        }
//        int from = iw.index;
//        boolean quote = bracketStr.charAt(iw.index) == '"';
//        if (quote) {
//            iw.index++;
//        }
//        while (iw.index < bracketStr.length() && (
//                quote && bracketStr.charAt(iw.index) != '"' ||
//                        !quote && !Character.isWhitespace(bracketStr.charAt(iw.index)) && "(),".indexOf(bracketStr.charAt(iw.index)) < 0
//        )) {
//            iw.index++;
//        }
//        if (quote && bracketStr.charAt(iw.index) == '"') {
//            iw.index++;
//        }
//        String valueStr = bracketStr.substring(from, iw.index);
//        T value = fromStr(valueStr);
//        skipSpaces(bracketStr, iw);
//        return value;
//    }
//
//    private QTreeNode fromBracketStr(String bracketStr, IndexWrapper iw) throws Exception {
//        T parentValue = readValue(bracketStr, iw);
//        QTreeNode parentNode = new QTreeNode(parentValue);
//        if (bracketStr.charAt(iw.index) == '(') {
//            iw.index++;
//            skipSpaces(bracketStr, iw);
//            if (bracketStr.charAt(iw.index) != ',') {
//                parentNode.left = fromBracketStr(bracketStr, iw);
//                skipSpaces(bracketStr, iw);
//            }
//            if (bracketStr.charAt(iw.index) == ',') {
//                iw.index++;
//                skipSpaces(bracketStr, iw);
//            }
//            if (bracketStr.charAt(iw.index) != ')') {
//                parentNode.right = fromBracketStr(bracketStr, iw);
//                skipSpaces(bracketStr, iw);
//            }
//            if (bracketStr.charAt(iw.index) != ')') {
//                throw new Exception(String.format("Ожидалось ')' [%d]", iw.index));
//            }
//            iw.index++;
//        }
//
//        return parentNode;
//    }
//
//    public void fromBracketNotation(String bracketStr) throws Exception {
//        IndexWrapper iw = new IndexWrapper();
//        QTreeNode root = fromBracketStr(bracketStr, iw);
//        if (iw.index < bracketStr.length()) {
//            throw new Exception(String.format("Ожидался конец строки [%d]", iw.index));
//        }
//        this.root = root;
//    }
}