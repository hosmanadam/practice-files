package com.adamhosman;

import java.util.ArrayList;

public interface NodeList {

    ListNode getRootNode();
    void setRootNode(ListNode listNode);
    Object get(int requiredIndex);
    boolean add(Object object);
    String toString();
    ArrayList toArrayListOfStrings();

    default ListNode getNode(int requiredIndex) {
        if (getRootNode() == null || requiredIndex < 0)
            return null;
        ListNode currentNode = getRootNode();
        int currentNodeIndex = 0;
        while (currentNodeIndex < requiredIndex) {
            currentNode = currentNode.getNextNode();
            if (currentNode == null)
                return null;
            currentNodeIndex++;
        }
        return currentNode;
    }

    default boolean addNode(ListNode newNode) {
        if (getRootNode() == null) {
            setRootNode(newNode);
            return true;
        }

        ListNode previousNode = null;
        ListNode nextNode = getRootNode();
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
            setRootNode(newNode);
        return linkNodes(previousNode, newNode, nextNode);
    }

    default boolean remove(int requiredIndex) {
        if (getRootNode() == null || requiredIndex < 0)
            return false;

        if (requiredIndex == 0) {
            setRootNode(getRootNode().getNextNode());
            return linkNodes(null, getRootNode());
        }

        ListNode previousNode = getRootNode();
        ListNode currentNode = getRootNode().getNextNode();
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
    
    default boolean addAll(Object[] objectArray) {
        boolean success = true;
        for (Object object : objectArray)
            if (!add(object))
                success = false;
        return success;
    }

    default boolean linkNodes(ListNode first, ListNode second) {
        if (first != null)
            first.setNextNode(second);
        if (second != null)
            second.setPreviousNode(first);
        return true;
    }

    default int size() {
        ListNode nextNode = getRootNode();
        int currentNodeCount = 0;
        while (nextNode != null) {
            nextNode = nextNode.getNextNode();
            currentNodeCount++;
        }
        return currentNodeCount;
    }

    default boolean linkNodes(ListNode previous, ListNode middle, ListNode next) {
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
