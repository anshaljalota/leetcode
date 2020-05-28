/*
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        if(!head)
            return head;
        ListNode* slow=head, *fast=head;
        while(fast&&fast->next){
            slow = slow->next;
            fast=fast->next->next;
        }
        return slow;
    }
};