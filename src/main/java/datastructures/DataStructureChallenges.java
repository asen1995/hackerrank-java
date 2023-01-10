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

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {

        if (llist == null) {
            return new SinglyLinkedListNode(data);
        }

        SinglyLinkedListNode head = llist;
        SinglyLinkedListNode prev = null;
        int count = 0;
        while (count < position) {
            prev = llist;
            llist = llist.next;
            count++;
        }

        SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(data);
        singlyLinkedListNode.next = llist;
        prev.next = singlyLinkedListNode;

        return head;

    }

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {

        if (llist == null) {
            return null;
        }

        if (position == 0) {
            return llist.next;
        }

        SinglyLinkedListNode head = llist;

        int count = 0;

        SinglyLinkedListNode prev = null;

        while (count < position) {
            prev = llist;
            llist = llist.next;
            count++;
        }

        if (llist.next == null) {
            prev.next = null;
        } else {
            prev.next = llist.next;
        }

        return head;
    }

    public static void reversePrint(SinglyLinkedListNode llist) {

        if (llist == null) {
            return;
        }

        reversePrint(llist.next);
        System.out.println(llist.data);
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {

        if (llist == null) {
            return null;
        }

        SinglyLinkedListNode currentHead = llist;

        while (llist.next != null) {
            SinglyLinkedListNode currentNode = llist.next;
            llist.next = currentNode.next;

            currentNode.next = currentHead;
            currentHead = currentNode;

        }

        return currentHead;
    }

    public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        SinglyLinkedListNode head = null;
        SinglyLinkedListNode current = null;

        while (head1 != null && head2 != null) {

            if (head1.data < head2.data) {
                if (head == null) {
                    head = head1;
                    current = head1;
                } else {
                    current.next = head1;
                    current = current.next;
                }
                head1 = head1.next;
            } else {
                if (head == null) {
                    head = head2;
                    current = head2;
                } else {
                    current.next = head2;
                    current = current.next;
                }
                head2 = head2.next;
            }

        }

        if (head1 != null) {
            current.next = head1;
        }

        if (head2 != null) {
            current.next = head2;
        }

        return head;
    }

    public void topView(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.getData() + " ");
        topView(root.getRight());
    }

    public SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        if (head == null) {
            final SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(data);
            return singlyLinkedListNode;
        }

        if (head.next != null) {
            insertNodeAtTail(head.next, data);
        } else {
            head.next = new SinglyLinkedListNode(data);
        }
        return head;

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

    public SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {

        if (llist == null) {
            return new SinglyLinkedListNode(data);
        } else {
            SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(data);
            singlyLinkedListNode.next = llist;
            return singlyLinkedListNode;
        }

    }

    public boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        while (head1 != null && head2 != null) {

            if (head1 == null || head2 == null) {
                return false;
            }

            if (head1.data != head2.data) {
                return false;
            }

            head1 = head1.next;
            head2 = head2.next;

        }

        return true;
    }


    public int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // 141 -> 302 -> 164 -> 530 -> 474 -> NULL

        SinglyLinkedListNode current = llist;
        SinglyLinkedListNode tail = llist;


        for(int i = 0; i < positionFromTail ; i++){
            current = current.next;
        }

        while (current.next != null){
            tail = tail.next;
        }

        return tail.data;
    }
}
