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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.common.truth.ComparableSubject;
import jdk.jshell.spi.ExecutionControl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Comparator;
import java.util.NoSuchElementException;

@RunWith(JUnit4.class)
public class LinkListTest {

  @Test
  public void linkList_toStringIsEmptyList_whenListEmpty() {
    // ARRANGE
    LinkList empty = new LinkList();

    // ACT
    String value = empty.toString();

    // ASSERT
    assertThat(value).isEqualTo("[]");
  }

  @Test
  public void linkList_toStringIsSingleItem_whenListContainsOneItem() {
    // ARRANGE
    LinkList<Integer> list = new LinkList<Integer>();
    list.addFirst(1);

    // ACT
    String value = list.toString();

    // ASSERT
    assertThat(value).isEqualTo("[1]");
  }

  @Test
  public void linkList_toStringIsTwoThenOne_whenListHasOneThenTwoAdded() {
    // ARRANGE
    LinkList<Integer> list = new LinkList<Integer>();
    list.addFirst(1);
    list.addFirst(2);

    // ACT
    String value = list.toString();

    // ASSERT
    assertThat(value).isEqualTo("[2,1]");
  }

  @Test
  public void linkListFromEmptyArr() {
    //ARRANGE
    //ACT
    Integer[] is = new Integer[] {};
    LinkList<Integer> ll = LinkList.create(is);
    String s = ll.toString();
    //ASSERT
    assertThat(s).isEqualTo("[]");
  }

  @Test
  public void linkListFromNonEmptyArr() {
    //ARRANGE
    //ACT
    Integer[] is = new Integer[] {1,2,3,4};
    LinkList<Integer> ll = LinkList.create(is);
    String s = ll.toString();
    //ASSERT
    assertThat(s).isEqualTo("[1,2,3,4]");
  }

  @Test
  public void removeFirstIsNull() {
    //ARRANGE
    LinkList<Float> ll = new LinkList();
    //ACT
    //ASSERT
    assertThrows(NoSuchElementException.class,() -> ll.removeFirst());
  }

  @Test
  public void removeFirstIsntNull() {
    //ARRANGE
    LinkList<Integer> ll = LinkList.create(new Integer[] {1,2,3,4});
    //ACT
    Integer oldHead = ll.removeFirst();
    //ASSERT
    assertThat(oldHead).isEqualTo(1);
    assertThat(ll.toString()).isEqualTo("[2,3,4]");
  }

  @Test
  public void getOutOfBounds() {
    //ARRANGE
    LinkList<Integer> empty = new LinkList();
    LinkList ll = LinkList.create(new Integer[] {1,2,3,4});
    //ACT
    //ASSERT
    assertThrows(NoSuchElementException.class, () -> ll.get(-1));
    assertThrows(NoSuchElementException.class, () -> empty.get(0));
    assertThrows(NoSuchElementException.class, () -> ll.get(8));

  }

  @Test
  public void getInBounds() {
    //ARRANGE
    LinkList<Integer> ll = LinkList.create(new Integer[] {1,2,3,4});
    //ACT
    int i1 = ll.get(0);
    int i2 = ll.get(1);
    int i3 = ll.get(2);
    int i4 = ll.get(3);
    //ASSERT
    assertThat(i1).isEqualTo(1);
    assertThat(i2).isEqualTo(2);
    assertThat(i3).isEqualTo(3);
    assertThat(i4).isEqualTo(4);

  }

  @Test
  public void lengthTest() {
    //ARRANGE
    LinkList<Integer> ll = LinkList.create(new Integer[] {1,2,3,4});
    LinkList<Float> empty = new LinkList<Float>();

    //ACT
    int llLength = ll.length();
    int emptyLength = empty.length();

    //ASSERT
    assertThat(llLength).isEqualTo(4);
    assertThat(emptyLength).isEqualTo(0);
  }

  @Test
  public void reverseTest() {
    //ARRANGE
    LinkList<Integer> ll = LinkList.create(new Integer[] {1,2,3,4});
    LinkList<Float> empty = new LinkList<Float>();
    //ACT
    ll.reverse();
    empty.reverse();
    //ASSERT
    assertThat(ll.toString()).isEqualTo("[4,3,2,1]");
    assertThat(empty.toString()).isEqualTo("[]");
  }
}
