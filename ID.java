import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ID {
    public static int getNewID() {
        File idFile = new File("UserID.ser");

        try {
            if (idFile.length() == 0) {
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("UserID.ser"))) {
                    objectOutputStream.writeObject(1);
                }
                return 1;
            }
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(idFile))) {
                int lastUserID = (int) objectInputStream.readObject();
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("UserID.ser"))) {
                    objectOutputStream.writeObject(lastUserID + 1);
                }
                return lastUserID + 1;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
