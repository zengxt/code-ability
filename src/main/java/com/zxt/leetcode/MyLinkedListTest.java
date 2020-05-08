package com.zxt.leetcode;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(12);
        linkedList.add(13);
        linkedList.add(14);

        linkedList.showList();
        linkedList.showListWithPre();

        linkedList.remove(12);
        linkedList.showList();
        linkedList.showListWithPre();
    }
}
