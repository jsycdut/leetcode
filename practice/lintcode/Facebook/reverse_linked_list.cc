/*
 *Definition of ListNode
 *
 *class ListNode{
 *        public:
 *                int val;
 *                ListNode *next;
 *                ListNode(int val){
 *                        this->val = val;
 *                        this.next = NULL;
 *                }
 *}
 */

class Solution{
	public:
		ListNode* reverse(ListNode* head){
			ListNode* p = NULL;
			ListNode* last = NULL;
			while(head){
				p = head;
				head = head->next;
				p->next = last;
				last = p;
			}
			return p;
		}
};
