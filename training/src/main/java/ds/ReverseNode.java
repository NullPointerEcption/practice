package ds;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

/**
 * @author wangyufei
 * @date 2018/10/7
 * @description 反向打印单向链表
 */
public class ReverseNode {

    private Node nodeRoot = new Node(1);

    @Before
    public void testBefore() {
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);

        nodeRoot.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        System.out.println("初始化node顺序：");
        //soutNode();
    }

    public void soutNode() {
        while (nodeRoot != null) {
            System.out.print(nodeRoot.getData() + "\t");
            nodeRoot = nodeRoot.getNext();
        }
    }

    @Test
    public void testReversePrint1() {
        Stack<Node> nodeStack = new Stack<>();
        while (nodeRoot != null) {
            nodeStack.push(nodeRoot);
            nodeRoot = nodeRoot.getNext();
        }

        System.out.println("-------------");
        while (!nodeStack.empty()) {
            System.out.println(nodeStack.pop().getData());
        }
    }
}
