/*
 * Copyright 2022 Ben Philps <bp413@cam.ac.uk>, Andrew Rice <acr31@cam.ac.uk>, E.C. Worth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.ecw66.linkedlists;

import java.util.NoSuchElementException;

public class LinkList<T extends Comparable<T>> implements OopList<T> {

    private static class Node<T extends Comparable<T>> {
        private final T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        Node(T value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            if (next == null) {
                return String.valueOf(value);
            }
            return value + "," + next;
        }

        private T get(int i) {
            if (i == 0) {
                return value;
            } else if (next == null) {
                throw new NoSuchElementException();
            } else {
                return next.get(i - 1);
            }
        }

        private int length() {
            if (next == null) {
                return 1;
            } else {
                return 1 + next.length();
            }
        }
    }

    private Node<T> head;

    LinkList() {
        this.head = null;
    }

    public void addFirst(T element) {
        if (head == null) {
            head = new Node<T>(element);
        } else {
            head = new Node<T>(element, head);
        }
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            T temp = head.value;
            head = head.next;
            return temp;
        }
    }

    @Override
    public String toString() {
        return String.format("[%s]", head == null ? "" : head.toString());
    }

    public static <G extends Comparable<G>> LinkList<G> create(G[] elements) {
        LinkList<G> ll = new LinkList<G>();
        for (int i = elements.length - 1; i >= 0; --i) {
            ll.addFirst(elements[i]);
        }
        return ll;
    }

    public T get(int i) {
        if (i < 0 || head == null) {
            throw new NoSuchElementException();
        } else {
            return head.get(i);
        }
    }

    public int length() {
        if (head == null) {
            return 0;
        } else {
            return head.length();
        }
    }

    @Override
    public void reverse() {
        if (head != null) {
            Node<T> previous = null;
            Node<T> current = null;
            Node<T> next = head;
            while (next != null) {
                previous = current;
                current = next;
                next = current.next;
                current.next = previous;
            }
            head = current;
        }
    }

    public void reorderLowHigh() {
        if (length() >= 1) {
            Node<T> current1 = head;
            Node<T> current2 = head.next;
            Node<T> previous;
            if (current1.value.compareTo(current2.value) <= 0) {
                previous = current1;
                current1 = current2;
                current2 = current1.next;
            } else {
                head = current2;
                previous = current2;
                current2 = previous.next;
            }
            int sign = -1;
            while (current2 != null) {
                if(current1.value.compareTo(current2.value) * sign <= 0) {
                    previous.next = current1;
                    previous = current1;
                    current1 = current2;
                    current2 = current1.next;
                } else {
                    previous.next = current2;
                    previous = current2;
                    current2 = previous.next;
                }
                sign *= -1;
            }
            previous.next = current1;
            current1.next = null;
        }
    }
}
