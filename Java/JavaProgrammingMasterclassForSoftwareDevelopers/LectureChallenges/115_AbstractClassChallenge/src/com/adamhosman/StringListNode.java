package com.adamhosman;

public class StringListNode extends ListNode {

    public StringListNode(ListNode previousNode, Object value, ListNode nextNode) {
        super(previousNode, value, nextNode);
    }

    @Override
    public int compareTo(ListNode otherListNode) {
        String otherValue = (String) otherListNode.getValue();
        String thisValue = (String) getValue();

        if (thisValue.equals(otherValue))
            return 0;
        if (thisValue.compareTo(otherValue) > 0)
            return 1;
        return -1;
    }
}
