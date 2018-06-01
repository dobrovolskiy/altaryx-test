package io.github.ddobrovolsky.collections;

/**
 * Interface for data store
 * Created by Dmitriy Dobrovolskiy on 01.06.2018.
 *
 * @since *.*.*
 */
interface DataStore<E> {
    boolean add(E e);

    E remove(int id);

    void printAll();
}
