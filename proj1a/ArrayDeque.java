public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int front;
    private int rear;
    private int arrayLength;

    private static final int ARRAY_SIZE = 8;

    // 构造函数
    public ArrayDeque() {
        items = (T[]) new Object[ARRAY_SIZE];
        size = 0;
        front = 0;
        rear = 0;
        arrayLength = ARRAY_SIZE;
    }


    // index计算工具
    private int minusOne(int index) {
        return (index - 1 + arrayLength) % arrayLength;
    }
    private int plusOne(int index) {
        return (index + 1) % arrayLength;
    }

    // 更新数组的大小
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];

        int index = front;
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(index + i) % arrayLength];
        }
        items = newItems;
        arrayLength = capacity;
        front = 0;
        rear = size;

    }

    public void addFirst(T item) {
        if (size + 1 == arrayLength) {
            resize(arrayLength * 2);
        }

        front = minusOne(front);
        items[front] = item;
        size++;
    }

    public void addLast(T item) {
        if (size + 1 == arrayLength) {
            resize(arrayLength * 2);
        }
        items[rear] = item;
        rear = plusOne(rear);
        size++;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int tempIndex = front;
        for (int i = 0; i < size; i++) {
            System.out.print(items[tempIndex] + " ");
            tempIndex = plusOne(tempIndex);
        }
        System.out.println();
    }

    public T removeFirst() {
        T tempValue = items[front];
        front = plusOne(front);
        size--;

        if ((size) < (arrayLength / 4)) {
            resize(arrayLength / 2);
        }

        return tempValue;
    }

    public T removeLast() {
        if ((size + 1) <= (arrayLength / 4)) {
            resize(arrayLength / 2);
        }
        rear = minusOne(rear);
        size--;
        return items[rear];
    }

    public T get(int index) {
        return (items[(front + index) % arrayLength]);
    }
}
