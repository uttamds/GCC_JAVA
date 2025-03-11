package gcc;

import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

public class ObjectReadWrite {
    public static void main(String[] args) {
        String filename = "person.dat";
        
        // Writing object to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            Person p = new Person("Alice", 25);
            oos.writeObject(p);
            System.out.println("Object written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Reading object from file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Person p = (Person) ois.readObject();
            System.out.println("Object read from file: " + p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
