import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Traversals {
  public static void main(String[] args) {
    Node<Integer> root = new Node<>(88);


    Node<Integer> child1 = new Node<>(17);
    Node<Integer> child2 = new Node<>(58);
    Node<Integer> child3 = new Node<>(33);

    root.children = new ArrayList<>();
    root.children.add(child1);
    root.children.add(child2);
    root.children.add(child3);

    Node<Integer> child1_1 = new Node<>(5);
    Node<Integer> child1_2 = new Node<>(99);
    child1.children = new ArrayList<>();
    child1.children.add(child1_1);
    child1.children.add(child1_2);


    Node<Integer> child2_1 = new Node<>(73);
    child2.children = new ArrayList<>();
    child2.children.add(child2_1);

    Node<Integer> child3_1 = new Node<>(24);
    Node<Integer> child3_2 = new Node<>(61);
    Node<Integer> child3_3 = new Node<>(12);
    child3.children = new ArrayList<>();
    child3.children.add(child3_1);
    child3.children.add(child3_2);
    child3.children.add(child3_3);


    Node<Integer> child3_1_1 = new Node<>(83);
    Node<Integer> child3_1_2 = new Node<>(6);
    child3_1.children = new ArrayList<>();
    child3_1.children.add(child3_1_1);
    child3_1.children.add(child3_1_2);

    // preorder(root);
    //System.out.println(max(root));

    Map<Integer, List<Integer>> tree = new HashMap<>();

    tree.put(33, List.of(24, 61, 12));
    tree.put(17, List.of(5, 99));
    tree.put(58, List.of(73));
    tree.put(24, List.of(83, 6));
    tree.put(88, List.of(17, 58, 33));
    tree.put(5, new ArrayList<>());
    tree.put(99, new ArrayList<>());
    tree.put(73, new ArrayList<>());
    tree.put(83, new ArrayList<>());
    tree.put(6, new ArrayList<>());
    tree.put(61, new ArrayList<>());
    tree.put(12, new ArrayList<>());
    
    preOrderMap(tree, 88);

  }

  static void preOrderMap(Map<Integer, List<Integer>> tree, int current) {
    // What if current isnt in our tree?
    if (!tree.containsKey(current)) {
      return;
    }
    // print current 
    System.out.println(current);
    // recurse its children
    List<Integer> children = tree.get(current);
    
    for(int child : children) {
      preOrderMap(tree, child);
    }
  }

  static void preorder(Node<?> node) {
    // if node is null, return 
    if (node == null) return;
    // print node value
    System.out.println(node.value);
    // // if node.children is null, return
    // if (node.children == null) return;
    for (Node<?> child : node.children)  {
      //  preorder (child)
      preorder(child);
    }
  }

  // returns the max value in the tree
  // if node is null, return Integer.MIN_VALUE
  static int max(Node<Integer> node) {
    // if node is null, return Integer.MIN_VALUE
    if (node == null) return Integer.MIN_VALUE;
    // biggest = node.value
    int biggest = node.value;
    // for each subtree in node.children
    for (Node<Integer> subtree : node.children) {
      int subtreeBiggest = max(subtree);
      // if max(subtree) > biggest
      if (subtreeBiggest > biggest) {
        // biggest = max(subtree)
        biggest = subtreeBiggest;
      }
    }
    // return biggest
    return biggest;
  }
}
