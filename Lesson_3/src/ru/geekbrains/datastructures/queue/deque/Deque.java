package ru.geekbrains.datastructures.queue.deque;

import ru.geekbrains.datastructures.queue.Queue;

public interface Deque<E> extends Queue<E> {

    void insertLeft(E value);
    void insertRight(E value);

    E removeLeft();
    E removeRight();
}