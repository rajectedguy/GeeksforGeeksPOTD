/* Structure of linked list node
class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    Node compute(Node head) {
        
        if (head == null || head.next == null) return head;
        Node ptr = head;
        
        Deque<Node> dq = new ArrayDeque<>();
        while (ptr != null) {
            
            while (!dq.isEmpty() && dq.getLast().data < ptr.data) {
                dq.removeLast();
            }
            
            dq.addLast(ptr);
            ptr = ptr.next;
        }
        
        Node root = dq.removeFirst();
        ptr = root;
        
        while (!dq.isEmpty()) {
            Node next = dq.removeFirst();
            
            ptr.next = next;
            ptr = ptr.next;
        }
        return root;
    }
}