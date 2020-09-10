/*

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        ListNode slow=head,fast=head,head2,t1,t2;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        head2=slow.next;
        slow.next=null;
        head2=reverse(head2); 
        ListNode head1 = head;
        while(head1!=null &&head2!=null){
            t1=head1.next;
            t2=head2.next;
            head1.next = head2;
            head2.next = t1;
            head1 = t1;
            head2 = t2;
        }
        //return head;
    }
    ListNode reverse(ListNode head){
        ListNode curr = head,prev=null,next=null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
