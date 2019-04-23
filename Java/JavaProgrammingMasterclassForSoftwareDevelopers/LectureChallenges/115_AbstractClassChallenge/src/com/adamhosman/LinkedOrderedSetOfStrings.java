package com.adamhosman;

import java.util.ArrayList;

public class LinkedOrderedSetOfStrings {

    private StringListNode firstNode;

    public LinkedOrderedSetOfStrings() {
        this.firstNode = null;
    }

    public LinkedOrderedSetOfStrings(String[] initialItems) {
        this();
        addAll(initialItems);
    }

    public String get(int requiredIndex) {
        if (firstNode == null || requiredIndex < 0)
            return null;
        ListNode currentNode = firstNode;
        int currentNodeIndex = 0;
        while (currentNodeIndex < requiredIndex) {
            currentNode = currentNode.getNextNode();
            if (currentNode == null)
                return null;
            currentNodeIndex++;
        }
        return (String) currentNode.getValue();
    }

    public boolean add(String string) {
        StringListNode newNode = new StringListNode(string);
        if (firstNode == null) {
            firstNode = newNode;
            return true;
        }

        ListNode previousNode = null;
        ListNode nextNode = firstNode;
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
            firstNode = newNode;
        return linkNodes(previousNode, newNode, nextNode);
    }

    public void addAll(String[] stringArray) {
        for (String string : stringArray)
            add(string);
    }

    public boolean remove(int requiredIndex) {
        if (firstNode == null || requiredIndex < 0)
            return false;

        if (requiredIndex == 0) {
            firstNode = (StringListNode) firstNode.getNextNode();
            return linkNodes(null, firstNode);
        }

        ListNode previousNode = firstNode;
        ListNode currentNode = firstNode.getNextNode();
        int currentNodeIndex = 1;

        while (currentNodeIndex < requiredIndex) {
            if (currentNode == null)
                return false;
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
            currentNodeIndex++;
        }

        if (currentNode == null)
            return false;
        return linkNodes(previousNode, currentNode.getNextNode());
    }

    @Override
    public String toString() {
        String contents = " {\n    " + String.join(",\n    ", toArrayList()) + "\n}";
        return getClass().getSimpleName() + contents;
    }

    public ArrayList<String> toArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; get(i) != null; i++) {
            arrayList.add(get(i));
        }
        return arrayList;
    }

    public int size() {
        ListNode nextNode = firstNode;
        int currentNodeCount = 0;
        while (nextNode != null) {
            nextNode = nextNode.getNextNode();
            currentNodeCount++;
        }
        return currentNodeCount;
    }

    private boolean linkNodes(ListNode first, ListNode second) {
        if (first != null)
            first.setNextNode(second);
        if (second != null)
            second.setPreviousNode(first);
        return true;
    }

    private boolean linkNodes(ListNode previous, ListNode middle, ListNode next) {
        if (middle == null)
            return linkNodes(previous, next);
        if (previous != null)
            previous.setNextNode(middle);
        middle.setPreviousNode(previous);
        middle.setNextNode(next);
        if (next != null)
            next.setPreviousNode(middle);
        return true;
    }

}
