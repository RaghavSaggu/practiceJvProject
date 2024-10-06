package logical;

public class MaximumFrom3Nums {

    public static void main(String... args) throws InterruptedException {
        System.out.println(getMeMax(5, 4, 3));
    }

    static int getMeMax(int i, int j, int k) {
        return i > j ? (i > k ? i : (j > k ? j : k)) : (j > k ? j : k);
    }
}
