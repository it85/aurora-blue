package common.collection.queue;

/**
 * A simple queue which offers concurrent READ and WRITE access.
 *
 * @param <T> the type to be stored
 */
public interface FastQueue<T> {

    boolean add(T t);

    boolean offer(T t);

    T remove();

    T poll();

    T element();

    T peek();
}