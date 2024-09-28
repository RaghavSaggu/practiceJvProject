package dataStructures;

public class LinkedListImpl {
    // Driver code
    public static void main(String[] args) {
        /* Start with the empty list. */
//        DoublyLinkedList list = new DoublyLinkedList();
        LinkedList list = new LinkedList();
        // Insert the values
        insertMultiple(list, 1, 2, 3, 4);
        // Print the LinkedList
        list.printList(list.getSize());
        list.insert(5, 4);
        list.printList(list.getSize());
//        if(list.reverseLinkedList()) {
//            list.printList(list.getSize());
//        }
        deleteElementInList(list, null, 5);
        list.printList(list.getSize());
        list.insertNodeAtPositionK(10, 2);
        list.printList(list.getSize());
    }

    public static void searchElementInList(LinkedList list, Integer nodeToSearch) {
        if (list.contains(nodeToSearch))
            System.out.println("List contains the value " + nodeToSearch);
        else
            System.out.println("List don't contains the value " + nodeToSearch);
    }

    public static boolean insertMultiple(LinkedList list, Integer... args) {
        try {
            if(args.length <= 0) {
                return false;
            }
            for(Integer arg: args) {
                list.insert(arg, null);
            }
            return true;
        } catch (Exception e) {
            System.out.println("something went wrong in driver class to insert multiple nodes at once");
            return false;
        }
    }

    public static boolean insertMultiple(DoublyLinkedList list, Integer... args) {
        try {
            if(args.length <= 0) {
                return false;
            }
            for(Integer arg: args) {
                list.insert(arg, null);
            }
            return true;
        } catch (Exception e) {
            System.out.println("something went wrong in driver class to insert multiple nodes at once");
            return false;
        }
    }

    public static void searchElementInList(DoublyLinkedList list, Integer nodeToSearch) {
        if (list.contains(nodeToSearch))
            System.out.println("List contains the value " + nodeToSearch);
        else
            System.out.println("List don't contains the value " + nodeToSearch);
    }

    public static void deleteElementInList(LinkedList list, Integer nodeToDelete, Integer nodePositionToDelete) {
        if(nodeToDelete == null && nodePositionToDelete == null) {
            System.out.println("No action given to work on");
            return;
        }
        if(nodeToDelete != null) {
            if (list.deleteNode(nodeToDelete))
                System.out.println("Deleted the value " + nodeToDelete);
            else
                System.out.println("List don't contains the value " + nodeToDelete);
        } else if (nodePositionToDelete != null) {
            if (list.deleteNodeAtPositionK(nodePositionToDelete))
                System.out.println("Deleted node at position " + nodePositionToDelete);
            else
                System.out.println("List don't contains the position " + nodePositionToDelete);
        }
    }

    public static void deleteElementInList(DoublyLinkedList list, Integer nodeToDelete, Integer nodePositionToDelete) {
        if(nodeToDelete == null && nodePositionToDelete == null) {
            System.out.println("No action given to work on");
            return;
        }
        if(nodeToDelete != null) {
            if (list.deleteNode(nodeToDelete))
                System.out.println("Deleted the value " + nodeToDelete);
            else
                System.out.println("List don't contains the value " + nodeToDelete);
        } else if (nodePositionToDelete != null) {
            if (list.deleteNodeAtPositionK(nodePositionToDelete))
                System.out.println("Deleted node at position " + nodePositionToDelete);
            else
                System.out.println("List don't contains the position " + nodePositionToDelete);
        }
    }
}
