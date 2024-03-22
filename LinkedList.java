public class LinkedList {

    public static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    private Node head;

    public LinkedList() {
        head = null;
    }
// remove the node following the given node
    public void removeAfter(Node node) {
        Node temp = head, prev = null;

        if (temp != null && temp == node) {
            head = temp.next;
            return;
        }

        while (temp != null && temp != node) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null)
            return;

        prev.next = temp.next;
    }
// create a new linked list with the same sequence of items as the original linked list
    public Node copy() {
        Node current = head;
        Node newHead = null;
        Node newTail = null;

        while (current != null) {
            Node newNode = new Node(current.data);
            if (newHead == null) {
                newHead = newNode;
                newTail = newNode;
            } else {
                newTail.next = newNode;
                newTail = newNode;
            }
            current = current.next;
        }

        return newHead;
    }
// remove every node in the list whose data field is equal to the key
    public void removeDuplicate(String key) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data.equals(key)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
    }

    public String max() {
        Node current = head;
        String maxVal = null;

        if (current == null) {
            return "0"; // return 0 if the linked list is empty
        }

        maxVal = current.data;
        current = current.next;

        while (current != null) {
            if (current.data.compareTo(maxVal) > 0) {
                maxVal = current.data;
            }
            current = current.next;
        }

        return maxVal;
    }
// to test with string values
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node("Kendall");
        list.head.next = new Node("Nicole");
        list.head.next.next = new Node("Kayla");
        list.head.next.next.next = new Node("Heather");

        System.out.println("Original List:");
        printList(list.head);

        Node newList = list.copy();
        System.out.println("Copied List:");
        printList(newList);

        list.removeDuplicate("Nicole");
        System.out.println("After removing duplicates of 'Nicole':");
        printList(list.head);

        System.out.println("Maximum value: " + list.max());
    }

    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println();
    }
}