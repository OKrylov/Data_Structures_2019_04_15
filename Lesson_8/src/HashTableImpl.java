public class HashTableImpl implements HashTable {

    private class Entry {
        private Item key;
        private int value;

        public Entry(Item key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Entry[] data;
    private int size;
    private int maxSize;

    public HashTableImpl(int maxSize) {
        this.data = new Entry[maxSize * 2];
        this.maxSize = maxSize;
    }

    private int hashFunc(int key) {
        return key % data.length;
    }

    @Override
    public boolean put(Item item, Integer cost) {
        if (size == maxSize) {
            return false;
        }

        int index = hashFunc(item.hashCode());
        while (data[index] != null) {
            index += getStep(item.hashCode());
            index %= data.length;
        }

        data[index] = new Entry(item, cost);
        size++;

        return true;
    }


    @Override
    public Integer get(Item item) {
        int index = indexOf(item);
        return index != -1 ? data[index].value : null;
    }

    @Override
    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index != -1) {
            data[index] = null;
            size--;
            return true;
        }

        return false;
    }

    protected int getStep(int key) {
        return 1;
    }
    private int indexOf(Item item) {
        int index = hashFunc(item.hashCode());
        int count = 0;

        while (data[index] != null && count < data.length) {
            Entry entry = data[index];
            if (entry.key.equals(item)) {
                return index;
            }
            index += getStep(item.hashCode());
            index %= data.length;
            count++;
        }

        return -1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(String.format("%d = [%s]", i, data[i]));
        }
        System.out.println("----------");
    }
}
