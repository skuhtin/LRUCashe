class Node {
  private int value;
  private int key;
  private Node next;
  private Node prev;

  public int getValue() {
    return value;
  }

  public int getKey() {
    return key;
  }

  public Node getNext() {
    return next;
  }

  public Node getPrev() {
    return prev;
  }

  Node(int key, int value) {
    this.key = key;
    this.value = value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }
}