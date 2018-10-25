public class ArrayList implements List {
    private Object arr[];
    private int size;
    private int nextIndex;

    ArrayList() {
        size = 0;
        arr = new Object[10];
    }

    @Override
    public void add(Object obj) {
        try {
            not_false(size + 1 < arr.length);
        } catch (Exception e) {
            grow_list();
        }
        arr[size] = obj;
        size++;
    }

    @Override
    public void add(int pos, Object obj) {
        try {
            not_false(pos < 0 && pos < size + 1);
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            not_false(pos != arr.length);
        } catch (Exception e) {
            grow_list();
        }
        for (int i = size; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = obj;
        size++;
    }

    @Override
    public Object get(int pos) {
        not_false(pos >= 0 && pos < size);
        return arr[pos];
    }

    @Override
    public Object remove(int pos) {
        not_false(pos >= 0 && pos < size);
        Object item = arr[pos];
        for (int i = pos+1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;
        return item;
    }

    @Override
    public int size() {
        return size;
    }

    private void grow_list() {
        Object newArr[] = new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    private void not_false(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
   }
}