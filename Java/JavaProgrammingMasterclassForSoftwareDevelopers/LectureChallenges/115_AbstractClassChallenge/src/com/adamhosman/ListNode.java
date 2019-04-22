package com.adamhosman;

public abstract class ListNode {

    private ListNode previousNode;
    private Object value;
    private ListNode nextNode;

    public ListNode(ListNode previousNode, Object value, ListNode nextNode) {
        this.previousNode = previousNode;
        this.value = value;
        this.nextNode = nextNode;
    }

    public ListNode getPreviousNode() {
        return previousNode;
    }

    public Object getValue() {
        return value;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setPreviousNode(ListNode previousNode) {
        this.previousNode = previousNode;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * @return 0 if equal, 1 if 'larger' than parameter, -1 if 'smaller' than parameter
     */
    public abstract int compareTo(ListNode otherListNode);

}
