
package prefix_postfix;

public class StackLinkedList {
  private Node top;

  // Menambahkan elemen ke atas stack
  public void push(String data) {
    Node newNode = new Node(data);
    newNode.next = top;
    top = newNode;
  }

  // Menghapus dan mengembalikan elemen paling atas dari stack
  public String pop() {
    if (isEmpty())
      throw new RuntimeException("Stack kosong");
    String data = top.data;
    top = top.next; // Geser top ke node berikutnya
    return data;
  }

  // Melihat elemen paling atas tanpa menghapus
  public String peek() {
    if (isEmpty())
      return null;
    return top.data;
  }

  // Mengecek apakah stack kosong
  public boolean isEmpty() {
    return top == null;
  }
}
