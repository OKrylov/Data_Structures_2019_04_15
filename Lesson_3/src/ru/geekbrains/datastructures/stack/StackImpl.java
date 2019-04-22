package ru.geekbrains.datastructures.stack;

public class StackImpl<E> implements Stack<E> {

    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public StackImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }

    @Override
    public void push(E value) {
        try {
            this.data[size++] = value;
        } catch (IndexOutOfBoundsException e) {
            throw new StackOverloadException();
        }
    }

    @Override
    public E pop() {
        try {
            return data[--size];
        } catch (IndexOutOfBoundsException e) {
            throw new StackOverloadException();
        }
    }

    @Override
    public E peek() {
        try {
            return data[size - 1];
        } catch (IndexOutOfBoundsException e) {
            throw new StackOverloadException();
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public int getSize() {
        return size;
    }
}
