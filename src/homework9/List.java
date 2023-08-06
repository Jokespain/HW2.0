package homework9;
import java.util.Arrays;
public interface List<T> {
    void add(T value);
    void add(T value, int index);
    void addAll(List<T> list);
    T get(int index);
    void set(T value, int index);
    T remove(int index);
    T remove(T t);
    int size();
    boolean isEmpty();
}
class MyArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;
    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T value) {
        ensureCapacity(size + 1);
        array[size] = value;
        size++;
    }
    public void add(T value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }
    public void addAll(List<T> list) {
        int listSize = list.size();
        ensureCapacity(size + listSize);
        for (int i = 0; i < listSize; i++) {
            array[size + i] = list.get(i);
        }
        size += listSize;
    }
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }
    public void set(T value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedElement = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
        return removedElement;
    }
    public T remove(T t) {
        int index = indexOf(t);
        if (index >= 0) {
            return remove(index);
        }
        return null;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    private void ensureCapacity(int minCapacity) {
        int currentCapacity = array.length;
        if (minCapacity > currentCapacity) {
            int newCapacity = currentCapacity + (currentCapacity >> 1);  // Increase capacity by 50%
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            array = Arrays.copyOf(array, newCapacity);
        }
    }
    private int indexOf(T t) {
        if (t == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (t.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        System.out.println("List size: " + myList.size());
        System.out.println("List elements: " + Arrays.toString(myList.array));
        myList.add(4, 1);
        System.out.println("List size: " + myList.size());
        System.out.println("List elements: " + Arrays.toString(myList.array));
        myList.addAll(myList);
        System.out.println("List size: " + myList.size());
        System.out.println("List elements: " + Arrays.toString(myList.array));
        System.out.println("Element at index 2: " + myList.get(2));
        myList.set(5, 0);
        System.out.println("List elements: " + Arrays.toString(myList.array));
        System.out.println("Removed element: " + myList.remove(3));
    }
}