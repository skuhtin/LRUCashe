import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private Node head;
  private Node tail;
  private int capacity;
  private Map<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<Integer, Node>(capacity);
  }

  public void set(int key, int value) {
    Node node = new Node(key,value);
    if (map.size() < capacity || map.containsKey(key)) {
      if (map.containsKey(key)) {
        Node oldNode = map.get(key);
        cutNode(oldNode);
      }
      map.put(key, node);
      insertLastNode(node);
    } else {
      if (capacity == 0) {
        return;
      }
      Node firstNode = head;
      cutNode(firstNode);
      map.remove(firstNode.getKey());
      map.put(key, node);
      insertLastNode(node);
    }
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node currentNode = map.get(key);
      cutNode(currentNode);
      insertLastNode(currentNode);
      return currentNode.getValue();
    } else {
      return -1;
    }
  }

  private void cutNode(Node currentNode) {
    Node prev = currentNode.getPrev();
    Node next = currentNode.getNext();
    if (prev == null && next == null) {
      head = null;
      tail = null;
    }else if (prev == null) {
      next.setPrev(null);
      head = next;
    } else if (next == null) {
      tail = prev;
    } else {
      prev.setNext(next);
      next.setPrev(prev);
    }
  }

  private void insertLastNode(Node currentNode) {
    currentNode.setPrev(tail);
    if (currentNode.getPrev() != null) {
      Node prev = currentNode.getPrev();
      prev.setNext(currentNode);
    }
    if (map.size() == 1) {
      head = currentNode;
    }
    tail = currentNode;
    currentNode.setNext(null);
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("");
    if (head != null) {
      Node node = head;
      result.append(node.getValue()).append(" ");
      while (node.getNext() != null) {
        node = node.getNext();
        result.append(node.getValue()).append(" ");
      }
    }
    return result.toString();
  }
}
