package uk.ac.cam.ecw66.linkedlists;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import jdk.jshell.spi.ExecutionControl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Comparator;
import java.util.NoSuchElementException;

@RunWith(JUnit4.class)
public class LinkQueueTest {
    @Test
    public void popInRange() {
        //ARRANGE
        LinkQueue<Integer> lq = LinkQueue.create(new Integer[]{1, 2});
        //ACT
        Integer l1 = lq.pop();
        Integer l2 = lq.pop();
        //ASSERT
        assertThat(l1).isEqualTo(1);
        assertThat(l2).isEqualTo(2);
    }

    @Test
    public void popOutOfRange() {
        //ARRANGE
        LinkQueue<Integer> lq = LinkQueue.create(new Integer[]{1});
        LinkQueue<Float> empty = new LinkQueue<Float>();
        //ACT
        Integer l1 = lq.pop();
        //ASSERT
        assertThrows(NoSuchElementException.class, lq::pop);
        assertThrows(NoSuchElementException.class, empty::pop);
    }

    @Test
    public void peekInRange() {
        //ARRANGE
        LinkQueue<Integer> lq = LinkQueue.create(new Integer[]{1, 2});
        //ACT
        Integer l1 = lq.peek();
        Integer l2 = lq.peek();
        //ASSERT
        assertThat(l1).isEqualTo(1);
        assertThat(l2).isEqualTo(1);
    }

    @Test
    public void peekOutOfRange() {
        //ARRANGE
        LinkQueue<Float> empty = new LinkQueue<Float>();
        //ACT
        //ASSERT
        assertThrows(NoSuchElementException.class, empty::peek);
    }

    @Test
    public void pushAndNormalise() {
        //ARRANGE
        LinkQueue<Integer> lq = new LinkQueue<Integer>();
        //ACT
        lq.push(1);
        lq.push(2);
        //ASSERT
        assertThat(lq.pop()).isEqualTo(1);
        assertThat(lq.peek()).isEqualTo(2);
    }

    @Test
    public void pushWithoutNormalise() {
        //ARRANGE
        LinkQueue<Integer> lq = LinkQueue.create(new Integer[]{1});
        //ACT
        lq.push(2);
        //ASSERT
        assertThat(lq.pop()).isEqualTo(1);
        assertThat(lq.pop()).isEqualTo(2);
        assertThrows(NoSuchElementException.class,lq::pop);
    }
}
