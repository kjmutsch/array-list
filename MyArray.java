// Custom Array class using generics
class MyArray<T> {
    private T[] array;
    private int size;
    private int capacity;

    // Constructor to initialize the array with a given capacity
    @SuppressWarnings("unchecked")
    public MyArray(int capacity) {
      int minCapacity = 10;
      this.capacity = Math.max(capacity, minCapacity); // needs to be at least 10 or larger
      this.array = (T[]) new Object[this.capacity]; // created an array of objects and then cast it to a generic T
      this.size = 0;
    }

    // Add an element to the array
    public void add(T element) {
      if(size == capacity) resize();
      array[size] = element;
      size++;
    }

    // Get element at specified index
    public T get(int index) {
      if (index < 0 || index >= size) return null;
      return array[index];
    }

    // Remove element at specified index
    public void remove(int index) {
      if (index < 0 || index >= size) return;
      for (int i = index + 1; i < size; i++) {
        array[i - 1] = array[i]; 
      }
      array[size - 1] = null;
      size--;
    }

    // Find a specified element in the array
    public int find(T element) {
      for (int i = 0; i < size; i++) {
        if (array[i] === element) return i;
      }
      return null;
    }

    // Resize array as needed. This changes array capacity but keeps size and content of old array.
    @SuppressWarnings("unchecked")
    private void resize() {
      this.capacity *= 2;
      T[] newArray = (T[]) new Object[this.capacity]; // created an array of objects and then cast it to a generic T
      for (int i = 0; i < size; i++) {
          newArray[i] = array[i];
      }
      this.array = newArray;
    }

    // Get the current size of the array
    public int size() {
        return this.size;
    }

    // Check if the array is empty
    public boolean isEmpty() {
      return this.size === 0;
    }

    // Traverse and print the elements of the array
    public void print() {
      for(int i = 0; i < size; i++) {
        System.out.print(array[i] + "  ");
      }
      System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
      MyArray<String> stringArray = new MyArray<>(10);
      stringArray.add('Hi');
      stringArray.add('I');
      stringArray.add('Am');
      stringArray.add('TESTING!');
      stringArray.print();
      
      MyArray<Integer> intArray = new MyArray<>(10);
      System.out.println('Is array empty? ' + intArray.isEmpty());
      intArray.add(5);
      intArray.add(2);
      intArray.add(14);
      intArray.printArray();

      System.out.println('Element at index 1: ' + intArray.get(1));
      intArray.remove(1);
      intArray.print();

      System.out.println('Index of element 2 is: ' + intArray.find(2));
      System.out.println('Is array empty? ' + intArray.isEmpty());
    }
}
