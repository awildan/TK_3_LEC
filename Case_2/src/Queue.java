class Queue {
  private Node front, rear;
  private int size;

  public Queue() {
    this.front = this.rear = null;
    this.size = 0;
  }

  // Menambahkan elemen ke antrian
  public void add(int data) {
    Node newNode = new Node(data);

    if (rear == null) {
      front = rear = newNode;
    } else {
      rear.next = newNode;
      rear = newNode;
    }

    size++;
    System.out.println("Antrian Masuk: " + data);
  }

  // Menghapus elemen dari antrian (dequeue)
  public int dequeue() {
    if (front == null) {
      System.out.println("Antrian kosong!");
      return -1;
    }

    int value = front.data;
    front = front.next;

    if (front == null) {
      rear = null;
    }

    size--;
    System.out.println("Antrian Keluar: " + value);
    return value;
  }

  // Menampilkan isi antrian
  public void display() {
    if (front == null) {
      System.out.println("Antrian kosong.");
      return;
    }

    Node current = front;
    System.out.print("Isi Antrian: ");
    while (current != null) {
      System.out.print(current.data + " <- ");
      current = current.next;
    }
    System.out.println("null");
  }

  // Mengembalikan jumlah item dalam antrian
  public int getSize() {
    return size;
  }

  // Mengecek apakah antrian kosong
  public boolean isEmpty() {
    return size == 0;
  }
}
