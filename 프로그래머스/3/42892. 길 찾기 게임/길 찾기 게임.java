import java.util.*;

class Solution {
    
    List<Integer> preorder = new ArrayList<>();
    List<Integer> postorder = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        
        ArrayList<Node> nodes = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
        
        Collections.sort(nodes, (o1, o2) -> {
            if(o1.y == o2.y) return o1.x - o2.x;
            else return o2.y - o1.y;
        });
        
        Node root = nodes.get(0);
        
        for(int i = 1; i < nodes.size(); i++) {
            insert(root, nodes.get(i));
        }
        
        preorder(root);
        postorder(root);
        
        int[][] answer = new int[2][nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preorder.get(i);
            answer[1][i] = postorder.get(i);
        }
        return answer;
    }
    
    void insert(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else if(parent.x < child.x) {
            if(parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }
    
    void preorder(Node node) {
        if(node == null) return;
        
        preorder.add(node.num);
        preorder(node.left);
        preorder(node.right);
    }
    
    void postorder(Node node) {
        if(node == null) return;
        
        postorder(node.left);
        postorder(node.right);
        postorder.add(node.num);
    }
}

class Node {
    
    int x;
    int y;
    int num;
    Node left;
    Node right;
    
    public Node (int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}