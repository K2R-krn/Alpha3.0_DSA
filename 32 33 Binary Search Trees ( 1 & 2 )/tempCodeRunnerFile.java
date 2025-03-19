if (root.data > k1) {
        printInRange(root.left, k1, k2);
    }
    // Print the root's data if it's within the range
    else if (root.data >= k1 && root.data <= k2) {
        System.out.print(root.data + " ");
    }

    // Recur for right subtree if needed
    if (root.data < k2) {
        printInRange(root.right, k1, k2);
    }