package Task.CodeHuffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 
 */
public class Huffman {

    class Node implements Comparable<Node> {
        final int sum;
        String code;

        void buildCode(String code){
            this.code = code;
        }

        public Node(int sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }
    }

    class InternalNode extends Node{
        Node left;
        Node right;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }
    }

    class LeafNode extends Node {
        char symbol;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }

        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
    }

    private void run() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("input.txt"));
        String s = scanner.next();
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        char[] sToArray = s.toCharArray();
        for (int i = 0; i < sToArray.length; i++) {
            char c = sToArray[i];
            if (count.containsKey(c)){
                count.put(c, count.get(c) + 1);
            }
            else count.put(c, 1);
        }
        Map<Character, Node> charNodes = new HashMap<>();


        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            LeafNode node = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), node);
            priorityQueue.add(node);
        }
        int sum = 0;
        while (priorityQueue.size() > 1){
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            priorityQueue.add(node);
        }
        if (count.size() == 1){
            sum = s.length();
        }
        System.out.println(count.size() + " " + sum);
        Node root = priorityQueue.poll();
        if (count.size() == 1){
            root.code = "0";
        } else {
            root.buildCode("");
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < sToArray.length; i++) {
            char c = sToArray[i];
            stringBuilder.append(charNodes.get(c).code);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new Huffman().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
