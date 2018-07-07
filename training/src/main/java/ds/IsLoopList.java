package ds;

import java.util.Objects;

/**
 * @author Administrator
 * @version $Id: IsLoopList, v 0.1 2018/07/07 12:47 Administrator Exp$
 */
public class IsLoopList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2, node1);
        node1.setNext(node2);
        Node node3 = new Node(3, null);
        node2.setNext(node3);

        boolean b = isLoopList(node1);
        System.out.println(b);
    }

    /**
     * 判断一个链表是否有环 使用快慢指针 如果有环则最终一定会相遇 如果无换 则最终快的会走到头
     *
     * @param node 链表的头结点
     * @return
     */
    private static boolean isLoopList(Node node) {
        /**
         * 如果链表只有一个或者两个节点 并且无环
         */
        if (node.getNext() == null || node.getNext().getNext() == null) {
            return false;
        }

        //定义两个节点 一个走得快 一个走得慢
        Node slowNode = node.getNext();
        Node fastNode = node.getNext().getNext();

        while (slowNode != null || fastNode != null) {
            if (slowNode.equals(fastNode)) {
                return true;
            }
            slowNode = slowNode.getNext();

            if (fastNode.getNext() == null) return false;
            fastNode = fastNode.getNext().getNext();
        }

        return true;
    }

}

/**
 * 链表中的节点
 */
class Node {

    private Object data;
    private Node next;

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(data, node.data) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data, next);
    }
}
