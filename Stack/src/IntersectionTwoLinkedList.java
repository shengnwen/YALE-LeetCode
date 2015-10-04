
//  Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }


public class IntersectionTwoLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        if (pA == null || pB == null) {
            return null;
        }
        while(pA != null && pB != null && pA != pB) {
            pA = pA.next;
            pB = pB.next;
            
            if (pA == pB) {
                return pA;
            }
            if (pA == null) {
                pA = headB;
            }
            if (pB == null) {
                pB = headA;
            }
        }
        return pA;
    }
}
