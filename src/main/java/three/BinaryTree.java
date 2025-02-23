/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package three;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Aleksandr_Berestov
 */
class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }


    // Method to insert nodes in the tree (for simplicity, we insert in BST manner)
    public void insertSorted(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }


    // Method to perform an in-order traversal of the tree
    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    public List<Integer> inOrderTraversal(Node node, List<Integer> values) {
        if (node != null) {
            inOrderTraversal(node.left, values);
            values.add(node.value);
            inOrderTraversal(node.right, values);
        }
        return values;
    }
}
