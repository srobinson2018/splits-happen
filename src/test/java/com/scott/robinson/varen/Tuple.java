package com.scott.robinson.varen;

/**
 * This is a helper class that exists to provide an immutable object for simple and scalable testing.
 *
 * @param <T> the first object in the Tuple
 * @param <R> the second object in the Tuple
 */
final class Tuple<T, R> {
    private final T first;
    private final R second;

    /**
     * Constructor which accepts all fields.
     */
    Tuple(final T first, final R second) {
        this.first = first;
        this.second = second;
    }

    T getFirst() {
        return first;
    }

    R getSecond() {
        return second;
    }
}