package com.adamhosman;

import java.util.ArrayList;

public class LinkedOrderedSetOfStrings implements NodeList {

    private StringListNode rootNode;

    public LinkedOrderedSetOfStrings() {
        this.rootNode = null;
    }

    public LinkedOrderedSetOfStrings(String[] initialItems) {
        this();
        addAll(initialItems);
    }

    @Override
    public ListNode getRootNode() {
        return rootNode;
    }

    @Override
    public void setRootNode(ListNode listNode) {
        rootNode = (StringListNode) listNode;
    }

    @Override
    public String get(int requiredIndex) {
        ListNode node = getNode(requiredIndex);
        return (node != null ? (String) node.getValue() : null);
    }

    @Override
    public boolean add(Object string) {
        StringListNode newNode = new StringListNode((String) string);
        return addNode(newNode);
    }

    @Override
    public String toString() {
        String contents = " {\n    " + String.join(",\n    ", toArrayListOfStrings()) + "\n}";
        return getClass().getSimpleName() + contents;
    }

    public ArrayList<String> toArrayListOfStrings() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; get(i) != null; i++) {
            arrayList.add(get(i));
        }
        return arrayList;
    }

}
