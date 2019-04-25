package ru.geekbrains.datastructures.linkedlist.twoside;

import ru.geekbrains.datastructures.queue.Queue;

public class LinkedQueueImpl<E> implements Queue<E> {

    private TwoSideLinlkedList<E> data;

    public LinkedQueueImpl() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public void insert(E value) {
        data.insertRight(value);
    }

    @Override
    public E remove() {
        return data.removeLeft();
    }

    @Override
    public E peek() {
        return data.getFirstElement();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int getSize() {
        return data.getSize();
    }
}
