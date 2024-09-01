package dataStrucures;

public class DoublyLinkedList {
    private Node head;
    private long size;

    public long getSize() {
        return size;
    }
    private void increaseSize() {
        this.size++;
    }
    private void decreaseSize() {
        this.size++;
    }


    class Node {
        Integer value;
        Node next;
        Node prev;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public boolean insert(Integer value, Integer after) {
        try {
            if (value == null) {
                System.out.println("No value found to insert");
                return false;
            }
            Node newNode = new Node(value);
            if(after == null){
                if (head == null) {
                    head = newNode;
                    this.increaseSize();
                } else {
                    Node last = head;
                    while (last.next != null) {
                        last = last.next;
                    }
                    newNode.prev = last;
                    last.next = newNode;
                    this.increaseSize();
                }
            } else {
                if (head == null) {
                    System.out.println("No element " + after + " found to insert after");
                    return false;
                } else {
                    Node last = head;
                    while (last.next != null && last.value.compareTo(after) != 0) {
                        last = last.next;
                    }
                    newNode.next = last.next;
                    newNode.prev = last;
                    last.next.prev = newNode;
                    last.next = newNode;
                    this.increaseSize();
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error while inserting");
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
                this.head.prev = newNode;
                newNode.next = this.head;
                this.head = newNode;
                this.increaseSize();
                return true;
            }
            // else we need to travese list to find element
            Node currNode = this.head;
            while (currNode.next != null) {
                if (counter == K) {
                    newNode.next = currNode.prev.next;
                    newNode.prev = currNode.prev;
                    currNode.prev.next = newNode;
                    currNode.prev = newNode;
                    this.increaseSize();
                    return true;
                }
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
            Node deletableNode = this.head;
            if (deletableNode.value.compareTo(elementToDelete) == 0) {
                // found value at head only
                System.out.println("found value at head only, deleting...");
                this.head = this.head.next;
                this.decreaseSize();
                return true;
            }
            // else we need to travese list to find element
            while (deletableNode.next != null) {
                if (deletableNode.value.compareTo(elementToDelete) == 0) {
                    // find the element to delete
                    deletableNode.prev.next = deletableNode.next;
                    deletableNode.next.prev = deletableNode.prev;
                    this.decreaseSize();
                    return true;
                }
                deletableNode = deletableNode.next;
            }

            if(deletableNode != null && deletableNode.value.compareTo(elementToDelete) == 0) {
                deletableNode.prev.next = null;
                deletableNode.prev = null;
                this.decreaseSize();
                return true;
            }
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
            Node currNode = this.head;
            int counter = 1;
            if (K == 1) {
                // found value at head only
                System.out.println("Head node to remove, deleting...");
                this.head = this.head.next;
                this.decreaseSize();
                return true;
            }
            // else we need to travese list to find element
            while (currNode.next != null) {
                if (counter == K) {
                    // find the element to delete
                    currNode.prev.next = currNode.next;
                    currNode.next.prev = currNode.prev;
                    this.decreaseSize();
                    return true;
                }
                currNode = currNode.next;
                counter++;
            }

            if(currNode != null && counter == K) {
                currNode.prev.next = null;
                currNode.prev = null;
                this.decreaseSize();
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error while deleting at position" + K);
            return false;
        }
    }
}
