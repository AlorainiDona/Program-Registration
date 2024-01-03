
import java.util.ArrayList;
import java.util.List;

public class Node {

    int id;
    String name;
    double evaluation;
    Node left , right;
    int parent;
    List<Node> children;
    public Node(){};

    public Node(int id, String name, double evaluation) {
        this.id = id;
        this.name = name;
        this.evaluation = evaluation;
        children = new ArrayList<Node>();
    }

    @Override
    public String toString() {
        // return "Node [id=" + id + ", name=" + name + ", evaluation=" + evaluation + ", left=" + left + ", right="+ right + ", parent=" + parent + "]";

        return "id=" + id + ", name=" + name + ", evaluation=" + evaluation + ", left=" + left + ", right=" + right + ", parent=" + parent;
    }
    public Node search(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.id == val) {
            return root;
        }

        Node left = search(root.left, val);
        Node right = search(root.right, val);

        if (left != null) {
            return left;
        }
        else if (right != null) {
            return right;
        }
        else {
            return null;
        }
    }


}
