public class App {
  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.add(25);
    queue.add(26);
    queue.add(27);
    queue.add(28);
    queue.add(29);
    queue.add(30);

    System.out.println("Jumlah item: " + queue.getSize());

    queue.dequeue();
    queue.display();
    System.out.println("Jumlah item setelah mengeluarkan antrian pertama: " + queue.getSize());
  }
}
