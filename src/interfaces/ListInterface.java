package interfaces;

public interface ListInterface {
    int size();
    void clear();
    boolean isEmpty();
    void add(Object value);
    void add(Object value, int index) throws IndexOutOfBoundsException;
    void set(Object value, int index) throws IndexOutOfBoundsException;
    Object get(int index);
    Object remove(int index);
    boolean contain(Object value);
}
