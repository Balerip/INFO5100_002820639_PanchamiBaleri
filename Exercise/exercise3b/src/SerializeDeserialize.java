import java.io.*;

public class SerializeDeserialize {
    public static void serialize(Shape shape, String shapeFileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(shapeFileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(shape);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Shape deserialize(String shapeFileName) {
        try (FileInputStream fileInputStream = new FileInputStream(shapeFileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Shape) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
