/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
   let slow = head;
    let fast = head;

    while (fast !== null && fast.next !== null) {
        slow = slow.next;          // move 1 step
        fast = fast.next.next;     // move 2 steps

        if (slow === fast) {
            return true;           // cycle detected
        }
    }

    return false;                  // no cycle
};
