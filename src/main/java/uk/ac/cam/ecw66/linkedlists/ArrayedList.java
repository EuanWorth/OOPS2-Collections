package uk.ac.cam.ecw66.linkedlists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayedList<T> implements OopList<T> {
    Object[] arr;
    int length;

    ArrayedList() {
        arr = new Object[1];
        length = 0;
    }

    ArrayedList(int iniLength) {
        if (iniLength > 0) {
            length = 0;
            arr = new Object[iniLength];
        } else if (iniLength == 0) {
            length = 0;
            arr = new Object[1];
        } else {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public void addFirst(T element) {
        Object[] oldArr = arr;
        Object[] newArr;
        if (this.length == arr.length) {
            newArr = new Object[length * 2];
        } else {
            newArr = new Object[arr.length];
        }
        newArr[0] = element;
        for (int i = 0; i < length; ++i) {
            newArr[i + 1] = oldArr[i];
        }
        arr = newArr;
        length++;
    }

    @Override
    public T removeFirst() {
        if (length != 0) {
            T oldHead = (T) arr[0];
            for (int i = 0; i < length - 1; ++i) {
                arr[i] = arr[i + 1];
            }
            length--;
            return oldHead;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public T get(int i) {
        if (0 <= i && i < length) {
            return (T) arr[i];
        } else {
            throw new NoSuchElementException();
        }
    }

    public void set(T element, int i) {
        if (0 <= i && i < length) {
            arr[i] = element;
        } else if (i == length && arr.length > length) {
            arr[i] = element;
            length++;
        } else if (i == length) {
            Object[] newArr = new Object[length * 2];
            for (int j = 0; j < length; ++j) {
                newArr[j] = arr[j];
            }
            newArr[length] = element;
            length++;
            arr = newArr;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public static <G> ArrayedList<G> create(G[] elements) {
        if (elements.length != 0) {
            ArrayedList<G> arrayedList = new ArrayedList<G>(elements.length * 2);
            for (int i = 0; i < elements.length; ++i) {
                arrayedList.set(elements[i], i);
            }
            return arrayedList;
        } else {
            return new ArrayedList<G>();
        }
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder("[");
        if (length != 0) {
            for (int i = 0; i < length - 1; ++i) {
                outputString.append(String.valueOf(arr[i])).append(",");
            }
            outputString.append(String.valueOf(arr[length - 1]));
        }
        outputString.append("]");
        return outputString.toString();
    }
}
