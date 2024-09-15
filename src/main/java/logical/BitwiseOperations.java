package logical;

public class BitwiseOperations {
    public static void main(String[] args) {
        // Sample values for a and b
        boolean a = true; // or false
        boolean b = false; // or true

        // Convert boolean values to integer for bitwise operations
        int intA = a ? 1 : 0;
        int intB = b ? 1 : 0;

        // Compute the expression (~a & b) | (a & ~b)
        int result = ((~intA & intB) | (intA & ~intB)) & 1; // & 1 to ensure result is 0 or 1

        // Print the result as boolean
        System.out.println("Result: " + (result == 1));
    }
}
