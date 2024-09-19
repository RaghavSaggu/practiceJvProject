package serializeDeserialize;

import java.io.*;

public class Demo {
    static boolean serialiseObjBeforeDeserialize;
    static String filePath = "C:\\Users\\Raghav\\Documents\\Java\\demoProject\\files\\serialzedObject.ser";

    public static void main(String[] args) {
        Demo runnerObject = new Demo();
        if (serialiseObjBeforeDeserialize) {
            SomeObjectForSerDesrDemo object = new SomeObjectForSerDesrDemo(1, "Raghav", "Engineer");
            runnerObject.saveObjectToFile(object, filePath);
        }

        SomeObjectForSerDesrDemo readObject = runnerObject.getObjectFromFile(filePath);
        System.out.println(readObject);
    }

    public void saveObjectToFile(SomeObjectForSerDesrDemo object, String pathForFile) {
        try (FileOutputStream fos = new FileOutputStream(pathForFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(object);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Unable to write object to file");
        }
    }

    public SomeObjectForSerDesrDemo getObjectFromFile(String pathToFile) {
        SomeObjectForSerDesrDemo object = null;
        try (FileInputStream fis = new FileInputStream(pathToFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            object = (SomeObjectForSerDesrDemo) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Unable to read object from file");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to cast object to the type required");
        }
        return object;
    }
}

class SomeObjectForSerDesrDemo implements Externalizable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String classification;

    private String something; // if I will use my own serialVersionUID, no effect will be made if I will crete new member in class

    public SomeObjectForSerDesrDemo() {
    }

    public SomeObjectForSerDesrDemo(Integer id, String name, String classification) {
        this.id = id;
        this.name = name;
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "SomeObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classification='" + classification + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeBytes(name);
        out.writeBytes("\n");
        out.writeBytes(classification);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = in.readLine();
        classification = in.readLine();
    }
}