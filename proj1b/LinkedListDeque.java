public class LinkedListDeque<T> implements Deque<T> {
    /* 首先定义链表的结构
     */
    private class LinkedListNode {
        T item;
        LinkedListNode prev;
        LinkedListNode next;

        LinkedListNode(T item, LinkedListNode prev, LinkedListNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    private LinkedListNode sentinel;
    private int size;

    // 构造函数，构造整个LinkedListDeque
    public LinkedListDeque() {
        sentinel = new LinkedListNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        size = 0;
    }

    @Override
    public void addFirst(T item) {
        LinkedListNode newNode = new LinkedListNode(item, sentinel, sentinel.next);

        sentinel.next.prev = newNode;
        sentinel.next = newNode;

        size++;
    }

    @Override
    public void addLast(T item) {
        LinkedListNode newNode = new LinkedListNode(item, sentinel.prev, sentinel);

        sentinel.prev.next = newNode;
        sentinel.prev = newNode;

        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    // Prints the items in the deque from first to last, separated by a space.
    @Override
    public void printDeque() {
        LinkedListNode tempNode = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(tempNode.item + " ");
            // update
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    // Removes and returns the item at the front of the deque. If no such item exists, returns null.
    @Override
    public T removeFirst() {
        // check whether the Deque is null
        if (size == 0) {
            return null;
        } else {
            LinkedListNode tempNode = sentinel.next;

            sentinel.next = tempNode.next;
            tempNode.next.prev = sentinel;

            size--;
            return tempNode.item;
        }
    }

    @Override
    public T removeLast() {
        // check whether the Deque is null
        if (size == 0) {
            return null;
        } else {
            LinkedListNode tempNode = sentinel.prev;

            sentinel.prev = tempNode.prev;
            tempNode.prev.next = sentinel;

            size--;
            return tempNode.item;
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        LinkedListNode tempNode = sentinel.next;

        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }

        return tempNode.item;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(LinkedListNode node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
}
