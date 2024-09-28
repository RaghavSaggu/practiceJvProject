package dataStructures;

public class LinkedList {
    private Node head;
    private Node tail;
    private long size;

    public long getSize() {
        return size;
    }

    class Node {
        Integer value;
        Node next;

        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + value + "|->" + next + "}";
        }
    }

    public boolean insert(Integer value, Integer after) {
        try {
            if (value == null) {
                System.out.println("No operation required");
                return false;
            }
            Node newNode = new Node(value);
            if (after == null) {
                if (this.head == null) {
                    this.head = newNode;
                    this.tail = this.head;
                    this.size = 1;
                } else {
                    Node last = this.tail;
                    last.next = newNode;
                    this.tail = newNode;
                    this.size++;
                }
            } else {
                if (head == null) {
                    System.out.println("No element " + after + " found to insert after");
                    return false;
                } else {
                    Node afterNode = head;
                    while (afterNode.next != null && afterNode.value.compareTo(after) != 0) {
                        afterNode = afterNode.next;
                    }
                    newNode.next = afterNode.next;
                    afterNode.next = newNode;
                    this.size++;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error while inserting " + value);
            return false;
        }
    }

    public boolean insertNodeAtPositionK(Integer value, Integer K) {
        try {
            if (this.head == null || K == null || K <= 0 || K > this.size + 1) {
                System.out.println("No operation required");
                return false;
            }
            // 3 cases to consider; on head/tail/in-between
            Node newNode = new Node(value);
            int counter = 1;
            if (K == 1) {
                // found value at head only
                System.out.println("Inser node at head, adding...");
                newNode.next = head;
                head = newNode;
                this.size++;
                return true;
            }
            // else we need to travese list to find element
            Node currNode = this.head, prev = null;
            while (currNode != null) {
                if (counter == K) {
                    newNode.next = currNode;
                    if(prev != null)
                        prev.next = newNode;
                    this.size++;
                    return true;
                }
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error while deleting at position" + K);
            return false;
        }
    }

    public void printList(Long size) {
        try {
            if (this.head == null) {
                System.out.println("No node is there to print");
                return;
            }
            System.out.print("Linked List " + (size != null ? "(" + size + "): " : ": "));
            Node currNode = this.head;
            while (currNode != null) {
                System.out.print(currNode.value);
                if (currNode.next != null)
                    System.out.print(", ");
                currNode = currNode.next;
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error while printing");
        }
    }

    public boolean contains(Integer search) {
        try {
            if (this.head == null) {
                System.out.println("No operation required");
                return false;
            }
            Node currNode = this.head;
            while (currNode != null) {
                if (currNode.value.compareTo(search) == 0)
                    return true;
                currNode = currNode.next;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error while searching " + search);
            return false;
        }
    }

    public boolean deleteNode(Integer elementToDelete) {
        try {
            if (this.head == null || elementToDelete == null) {
                System.out.println("No operation required");
                return false;
            }
            // 3 cases to consider; on head/tail/in-between
            Node currNode = this.head, prevNode = null;
            if (currNode.value.compareTo(elementToDelete) == 0) {
                // found value at head only
                System.out.println("found value at head only, deleting...");
                this.head = this.head.next;
                this.size--;
                return true;
            }
            // else we need to travese list to find element
            while (currNode != null) {
                if (currNode.value.compareTo(elementToDelete) == 0) {
                    // find the element to delete
                    prevNode.next = currNode.next;
                    this.size--;
                    return true;
                }
                prevNode = currNode;
                currNode = currNode.next;
            }
//            if(currNode != null && currNode.value.compareTo(elementToDelete) == 0) {
//                prevNode.next = null;
//                this.size--;
//                return true;
//            }
            return false;
        } catch (Exception e) {
            System.out.println("Error while deleting " + elementToDelete);
            return false;
        }
    }

    public boolean deleteNodeAtPositionK(Integer K) {
        try {
            if (this.head == null || K == null || K <= 0 || K > this.size) {
                System.out.println("No operation required");
                return false;
            }
            // 3 cases to consider; on head/tail/in-between
            Node currNode = this.head, prevNode = null;
            int counter = 1;
            if (K == 1) {
                // found value at head only
                System.out.println("Head node to remove, deleting...");
                this.head = this.head.next;
                this.size--;
                return true;
            }
            // else we need to traverse list to find element
            while (currNode != null) {
                if (counter == K) {
                    // find the element to delete
                    prevNode.next = currNode.next;
                    this.size--;
                    return true;
                }
                prevNode = currNode;
                currNode = currNode.next;
                counter++;
            }
            // if element is last one then handle here
//            if(currNode != null && counter == K) {
//                prevNode.next = null;
//                this.size--;
//                return true;
//            }
            return false;
        } catch (Exception e) {
            System.out.println("Error while deleting at position" + K);
            return false;
        }
    }

    public boolean reverseLinkedList() {
        try {
            if(this.head == null) {
                System.out.println("No element in the list to reverse");
                return true;
            } else if (this.head.next == null) {
                System.out.println("No need to reverse the list");
                return true;
            }
            Node currNode = this.head, newHead = null, tempNode = null;
            while (currNode != null) {
                tempNode = currNode.next;   // backing up next to current
                currNode.next = newHead;
                newHead = currNode;
                currNode = tempNode; // used that backup to traverse to next
            }
            this.head = newHead;

            return true;
        } catch (Exception e) {
            System.out.println("Error while reversing the list");
            return false;
        }
    }
}
