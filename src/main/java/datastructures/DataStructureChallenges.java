package datastructures;

import datastructures.tree.Node;

import java.util.*;

public class DataStructureChallenges {

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;
        final int numberOfArrays = arr.size();

        for (int i = 0; i < numberOfArrays - 2; i++) {

            for (int j = 0; j < numberOfArrays - 2; j++) {
                int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
                        + arr.get(i + 1).get(j + 1) +
                        arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }

        }


        return maxSum;

    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        List<Integer> rotatedList = new ArrayList<>();
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            rotatedList.add(arr.get((i + d) % size));
        }
        return rotatedList;
    }

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {

        Map<String, Integer> mapOfStrings = new HashMap<>(stringList.size());

        for (String inputString : stringList) {
            if (mapOfStrings.containsKey(inputString)) {
                Integer count = mapOfStrings.get(inputString);
                count += 1;
                mapOfStrings.put(inputString, count);
            } else {
                mapOfStrings.put(inputString, 1);
            }
        }

        List<Integer> result = new LinkedList<>();

        for (String query : queries) {
            result.add(mapOfStrings.getOrDefault(query, 0));
        }

        return result;

    }

    public static int height(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());

        int max = (leftHeight == rightHeight) ? leftHeight : (leftHeight > rightHeight) ? leftHeight : rightHeight;
        return max + 1;
    }

    public static void topView(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.getData() + " ");
        topView(root.getRight());
    }

    public List<Integer> reverseArray(List<Integer> a) {
        Collections.reverse(a);
        return a;
    }

    public long arrayManipulation(int n, List<List<Integer>> queries) {

        List<Integer> array = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            array.add(0);
        }

        for (List<Integer> query : queries) {
            int startIndex = query.get(0) - 1;
            int endIndex = query.get(1);
            int increasedValue = query.get(2);

            for (int i = startIndex; i < endIndex; i++) {
                array.set(i, array.get(i) + increasedValue);
            }
        }

        return array.stream().max(Integer::compareTo).get();
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.getData() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData() + " ");


    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrder(root.getRight());
    }

    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final Node node = queue.poll();

            System.out.print(node.getData() + " ");

            if (node.getLeft() != null)
                queue.add(node.getLeft());

            if (node.getRight() != null)
                queue.add(node.getRight());


        }
    }


    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data, null, null);
        } else {
            Node cur;
            if (data <= root.getData()) {
                cur = insert(root.getLeft(), data);
                root.setLeft(cur);
            } else {
                cur = insert(root.getRight(), data);
                root.setRight(cur);
            }
            return root;
        }
    }
}
