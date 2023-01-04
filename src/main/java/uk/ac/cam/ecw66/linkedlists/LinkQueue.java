package uk.ac.cam.ecw66.linkedlists;

import java.util.NoSuchElementException;

public class LinkQueue<T extends Comparable<T>> implements OopQueue<T> {
    LinkList<T> ForwardList;
    LinkList<T> ReverseList;

    LinkQueue() {
        ForwardList = new LinkList<T>();
        ReverseList = new LinkList<T>();
    }

    @Override
    public void push(T element) {
        ReverseList.addFirst(element);
        normalise();
    }

    private void normalise() {
        if (ForwardList.length() == 0) {
            ReverseList.reverse();
            ForwardList = ReverseList;
            ReverseList = new LinkList<T>();
        }
    }

    @Override
    public T pop() {
        normalise();
        T head = (T)ForwardList.removeFirst();
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            normalise();
            return head;
        }
    }

    @Override
    public T peek() {
        normalise();
        T head = (T)ForwardList.get(0);
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            return head;
        }
    }

    public static <G extends Comparable<G>> LinkQueue<G> create(G[] elements) {
        LinkQueue<G> newQueue = new LinkQueue<G>();
        newQueue.ForwardList = LinkList.create(elements);
        return newQueue;
    }
}
