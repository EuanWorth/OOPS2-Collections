package uk.ac.cam.ecw66.linkedlists;

public interface OopList<T> {
    public void addFirst(T element);

    public T removeFirst();

    public static <G> OopList<G> create(G[]elements) {
        return null;
    }

    public T get(int i);

    public String toString();

    public int length();

    public void reverse();
}
