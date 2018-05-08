package com.xiaolong.simple;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *      输入：1->2->4, 1->3->4
 *      输出：1->1->2->3->4->4
 */
public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

/**
 * 解析：做链表的时候需要一个头结点来找到链表的位置
 * 所以这里用head来表示头结点，o来表示中间添加的值。
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //这里很简单，如果那个为空，就返回对应的那个
        if(l1==null) {return l2;}
        if(l2==null) {return l1;}
        //连接第一个头部
        ListNode oldList = l1, newList = l2 , head , o;
        //这里是为了获取头结点， 那个小那个就放在前面
        if(oldList.val >= newList.val){
            head = newList;
            newList = newList.next;
            head.next = mergeTwoLists(oldList, newList);
        }else {
            head = oldList;
            oldList = oldList.next;
            head.next = mergeTwoLists(oldList, newList);
        }
        return head;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(1);
        l1.next.next = new ListNode(2);
        ListNode l2 = new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next = new ListNode(4);
        Solution s = new Solution();
        ListNode out = s.mergeTwoLists(l1, l2);
        while (out!=null){
            System.out.println(out.val);
            out = out.next;
        }
    }
}