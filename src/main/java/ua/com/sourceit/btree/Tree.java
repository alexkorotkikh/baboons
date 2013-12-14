package ua.com.sourceit.btree;

public class Tree<E extends Comparable<E>> {
    private E data;
    private Tree<E> left;
    private Tree<E> right;

    public Tree(E data) {
        this.data = data;
    }

    public Tree(E data, Tree<E> left, Tree<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int depth() {
        if (left == null && right == null) {
            return 1;
        } else if (left == null) {
            return 1 + right.depth();
        } else if (right == null) {
            return 1 + left.depth();
        } else {
            int leftDepth = left.depth();
            int rightDepth = right.depth();
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }

    public void add(E el) {
        if (data.compareTo(el) == 0) {
            return;
        } else if (data.compareTo(el) > 0) {
            if (left == null) {
                left = new Tree<E>(el);
            } else {
                left.add(el);
            }
        } else {
            if (right == null) {
                right = new Tree<E>(el);
            } else {
                right.add(el);
            }
        }
    }

    public boolean contains(E el) {
        if (data.compareTo(el) == 0) {
            return true;
        } else if (data.compareTo(el) > 0) {
            if (left == null) {
                return false;
            } else {
                return left.contains(el);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(el);
            }
        }
    }
}