package uk.ac.cam.ecw66.linkedlists;

public interface OopQueue<T> {
    public void push(T element);

    public T pop();

    public T peek();

    public static <G> OopQueue<G> create(G[] elements) {
        return null;
    }
}
