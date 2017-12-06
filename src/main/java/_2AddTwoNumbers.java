/**
 * Created by Chong AiZhen on 17-12-4,下午1:43.
 */

/*
You are given two non-empty linked lists representing（代表） two non-negative（非负） integers.
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume（假设） the two numbers do not contain any leading zero（即这两个数字的首位不为0）, except the number 0 itself.

Example：

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 */
public class _2AddTwoNumbers {

    public static void main(String[] args){
        // TODO: 17-12-4
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
}

//单链表的定义
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
