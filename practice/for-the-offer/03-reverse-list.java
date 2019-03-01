/**
*    剑指offer第三题，写了一个小时，真的丢脸！！！
*    这题以前做过的啊！！！！！！！！！！！！！！！！！
*    输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        // 边界检查
        if (listNode == null) {
            return list;
        }
        
        // head代表正在被处理的list节点
        // bridge为桥梁节点，因为要改变正在处理的节点的next
        // 所以必须让head先跳到下一个节点，bridge用来保存此时的要改变next的节点
        // prev代表上一个节点，用于被bridge连接
        // 整体过程可以形容为，head跑，bridge追，要追上的时候head继续跑
        // 此时bridge回头连接后方节点
        // 所以看起来就是，舔狗追女神，在要追悼女神的时候女神又跑了
        // 然后舔狗回头再看看自己的舔狗
        // 所以？这就是一条舔狗链？？？（手动狗头，逃！！！
        // 所以？最后女神null了，舔狗bridge回头和自己的舔狗在一起？？
        // 不！！！ 舔狗必须死！！！！
        ListNode head, bridge, prev;
        head = listNode;
        bridge = listNode;
        prev = null;
        while (head != null) {
            bridge = head;
            head = head.next;
            bridge.next = prev;
            prev = bridge;
        }   
        
        while (prev != null) {
            list.add(prev.val);
            prev = prev.next;
        }
        return list;
    }
}
