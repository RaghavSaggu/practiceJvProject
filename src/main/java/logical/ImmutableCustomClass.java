package logical;

public class ImmutableCustomClass {
    public static void main(String[] args) {
        MutableClazz mutableObj = new MutableClazz(10);
        ImmutableClazz immutableObj = new ImmutableClazz(1, "Raghav", mutableObj);
        System.out.println(immutableObj);
        immutableObj.getMutableObject().setId(100);
        System.out.println(immutableObj);
    }
}

final class ImmutableClazz {
    private final int id;
    private final String value;
    private final MutableClazz mutableObject;

    public ImmutableClazz(int id, String value, MutableClazz mutableClazz) {
        this.id = id;
        this.value = value;
        // always make a deep copy of mutable object members of immutable class
        MutableClazz objForDeepCopy = new MutableClazz(mutableClazz.getId());
        this.mutableObject = objForDeepCopy;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public MutableClazz getMutableObject() {
        // always return the deep copy of the object; never the original object
        return new MutableClazz(mutableObject.getId());
    }

    @Override
    public String toString() {
        return "ImmutableClazz{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", mutableObject=" + mutableObject +
                '}';
    }
}

class MutableClazz {
    private int id;

    public MutableClazz(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MutableClazz{" +
                "id=" + id +
                '}';
    }
}