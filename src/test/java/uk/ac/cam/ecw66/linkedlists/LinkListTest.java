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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
    LinkList list = new LinkList();
    list.addFirst(1);

    // ACT
    String value = list.toString();

    // ASSERT
    assertThat(value).isEqualTo("[1]");
  }

  @Test
  public void linkList_toStringIsTwoThenOne_whenListHasOneThenTwoAdded() {
    // ARRANGE
    LinkList list = new LinkList();
    list.addFirst(1);
    list.addFirst(2);

    // ACT
    String value = list.toString();

    // ASSERT
    assertThat(value).isEqualTo("[2,1]");
  }
}
