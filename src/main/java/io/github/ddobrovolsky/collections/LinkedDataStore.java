package io.github.ddobrovolsky.collections;

import io.github.ddobrovolsky.entities.Animal;
import io.github.ddobrovolsky.exception.LogicalException;

/**
 * DataStore implementation based on double linked list
 * <p>
 * Created by Dmitriy Dobrovolskiy on 01.06.2018.
 *
 * @see DataStore
 * @see Animal
 * @since *.*.*
 */
public class LinkedDataStore<E extends Animal> implements DataStore<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public boolean add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        return true;
    }

    public E remove(int id) {
        Node<E> toRemove = indexOf(id);
        if (toRemove == null) {
            throw new LogicalException("Element with id = " + id + " not found");
        }
        return unlink(toRemove);
    }

    private Node<E> indexOf(int id) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item.getId() == id)
                return x;
        }
        return null;
    }

    private E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    public void printAll() {
        for (Node<E> x = first; x != null; x = x.next) {
            System.out.println(x.item);
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
