package Tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C01 {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public int getCount(ListNode node) {
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        return count;
    }


    public ListNode xorList (ListNode a, ListNode b) {
        // write code here
        if (a == null && b == null) {
            return null;
        }
        if (a == null) return reverseNode(b);
        if (b == null) return a;
        a = reverseNode(a);
        ListNode head = new ListNode(a.val == b.val ? 0 : 1);
        a = a.next;
        b = b.next;
        ListNode cur = head;
        while (a != null && b != null) {
            cur.next = new ListNode(a.val == b.val ? 0 : 1);
            a = a.next;
            b = b.next;
            cur = cur.next;
        }
        while (a != null) {
            cur.next = new ListNode(a.val);
            a = a.next;
            cur = cur.next;
        }
        while (b != null) {
            cur.next = new ListNode(b.val);
            b = b.next;
            cur = cur.next;
        }
        head = reverseNode(head);
        while (head != null && head.val == 0) {
            head = head.next;
            if (head == null) return new ListNode(0);
        }
        return head;

        // List<Integer> aList = new ArrayList<>();
        // List<Integer> bList = new ArrayList<>();
        // while (a != null) {
        //     aList.add(a.val);
        //     a = a.next;
        // }
        // while (b != null) {
        //     bList.add(b.val);
        //     b = b.next;
        // }
        // Collections.reverse(aList);
        // int len1 = aList.size();
        // int len2 = bList.size();
        // List<Integer> ans = new ArrayList<>();
        // for (int i = 0; i < Math.min(len1, len2); i++) {
        //     ans.add(aList.get(i) == bList.get(i) ? 0 : 1);
        // }
        // if (len1 > len2) {
        //     for (int i = len1 - len2; i < len1; i++) {
        //         ans.add(aList.get(i));
        //     }
        // }
        // if (len1 < len2) {
        //     for (int i = len2 - len1; i < len2; i++) {
        //         ans.add(bList.get(i));
        //     }
        // }
        // Collections.reverse(ans);
        // ListNode ret = new ListNode(0);
        // ListNode cur = ret;
        // int index = 0;
        // while (ans.get(index) == 0) {
        //     ++index;
        // }
        // for (int i = index; i < ans.size(); i++) {
        //     cur.next = new ListNode(ans.get(i));
        //     cur = cur.next;
        // }
        // return ret.next;
    }


    public ListNode reverseNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
