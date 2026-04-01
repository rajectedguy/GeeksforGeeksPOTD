/**
 * @param {Node} head1
 * @param {Node} head2
 * @returns {Node}
 */

/*
class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    intersectPoint(head1, head2) {
        let a = head1, b = head2;
        while (a !== b) {
            a = a ? a.next : head2;
            b = b ? b.next : head1;
        }
        return a;
    }
}