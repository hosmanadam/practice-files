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
        rootNode = subtypeNode(listNode);
    }

    @Override
    public StringListNode subtypeNode(ListNode listNode) {
        return (StringListNode) listNode;
    }

    @Override
    public String get(int requiredIndex) {
        if (rootNode == null || requiredIndex < 0)
            return null;
        ListNode currentNode = rootNode;
        int currentNodeIndex = 0;
        while (currentNodeIndex < requiredIndex) {
            currentNode = currentNode.getNextNode();
            if (currentNode == null)
                return null;
            currentNodeIndex++;
        }
        return (String) currentNode.getValue();
    }

    @Override
    public boolean add(Object string) {
        StringListNode newNode = new StringListNode((String) string);
        if (rootNode == null) {
            rootNode = newNode;
            return true;
        }

        ListNode previousNode = null;
        ListNode nextNode = rootNode;
        boolean beforeFirst = true;
        do {
            if (newNode.compareTo(nextNode) == 0)
                return false;
            if (newNode.compareTo(nextNode) == -1)
                break;
            previousNode = nextNode;
            nextNode = nextNode.getNextNode();
            beforeFirst = false;
        } while (nextNode != null);

        if (beforeFirst)
            rootNode = newNode;
        return linkNodes(previousNode, newNode, nextNode);
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
