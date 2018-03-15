package exercises.files;

import java.io.*;

public class ReadWrite {

    public static final String DIRECTORY_PATH = ReadWrite.class.getResource("").getPath() + "ORDERS" + File.separator;

    public static void main(String[] args) {
        MyClass myClass = new MyClass("hello", 1, "kayan");

        System.out.println("path:" + DIRECTORY_PATH);




        File file2 = new File(DIRECTORY_PATH);
        file2.mkdir();

        try (
                OutputStream fileOutputStream = new FileOutputStream(DIRECTORY_PATH + "newFile" + System.currentTimeMillis() + ".txt");
                OutputStream buffer = new BufferedOutputStream(fileOutputStream);
                ObjectOutput output = new ObjectOutputStream(buffer);
        ) {
            System.out.println("my class before: " + myClass);
            output.writeObject(myClass);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        File fileDir = new File(DIRECTORY_PATH);
        File[] files = fileDir.listFiles();
        for (File file : files) {
            readFile(file);
        }

    }

    private static void readFile(File file) {
        try (
                InputStream fileInput = new FileInputStream(file);
                InputStream buffer = new BufferedInputStream(fileInput);
                ObjectInput input = new ObjectInputStream(buffer);
        ) {
            try {
                MyClass myClassFromFile = (MyClass) input.readObject();
                System.out.println("my class after: " + myClassFromFile);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}

class MyClass implements Serializable {
    transient String description;
    int id;
    String name;

    MyClass(String description, int id, String name) {
        this.description = description;
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    String getDescription() {
        return description;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }
}
