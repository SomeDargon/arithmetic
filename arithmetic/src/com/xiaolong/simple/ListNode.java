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

    /**
     * 这个是遍历方法还有一张是递归方法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //这里很简单，如果那个为空，就返回对应的那个
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        //连接第一个头部
        ListNode oldList = l1, newList = l2, head, o;

        //这里是为了获取头结点， 那个小那个就放在前面
        if (oldList.val >= newList.val) {
            head = o = newList;
            newList = newList.next;
        } else {
            head = o = oldList;
            oldList = oldList.next;
        }
        while (oldList != null && newList != null) {
            if (oldList.val > newList.val) {
                //这注意一下.三个步骤
                //1.先把最小的那个，放到自定义链表o的下一个
                //2.然后保证o指向的是最后一个节点
                //3.最后把小的那个节点指向下一个
                o = o.next = newList;
                newList = newList.next;
            } else {
                o = o.next = oldList;
                oldList = oldList.next;
            }
        }


        //最后是遍历没有遍历完的，直接添加到后面去
        while (oldList != null) {
            o = o.next = oldList;
            oldList = oldList.next;
        }
        while (newList != null) {
            o = o.next = newList;
            newList = newList.next;
        }
        return head;
    }

    /**
     * 递归方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        //这里很简单，如果那个为空，就返回对应的那个
        if(l1==null) {return l2;}
        if(l2==null) {return l1;}
        //连接第一个头部
        ListNode oldList = l1, newList = l2 , head , o;
        //这里是为了获取头结点， 那个小那个就放在前面
        if(oldList.val >= newList.val){
            head = newList;
            newList = newList.next;
            head.next = mergeTwoLists1(oldList, newList);
        }else {
            head = oldList;
            oldList = oldList.next;
            head.next = mergeTwoLists1(oldList, newList);
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