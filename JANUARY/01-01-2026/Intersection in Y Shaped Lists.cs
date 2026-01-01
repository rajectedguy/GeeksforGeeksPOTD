/*
class Node {
    public int data;
    public Node next;

    public Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        Node a = head1, b = head2;
        while (a != b) {
            a = (a != null) ? a.next : head2;
            b = (b != null) ? b.next : head1;
        }
        return a;
    }
}