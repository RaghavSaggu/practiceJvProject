package collectionAndStreams;

@FunctionalInterface
public interface DemoFuncInterface {
    int calculateSquare(int x);

    default double calculateAreaOfCircle(int r) {
        return Math.PI * r * r;
    }
}
