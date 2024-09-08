package others;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int num = 153;
        int sumOfCubesOfEachNumber = getSumOfCubesOfEachNumber(num);
        if (num == sumOfCubesOfEachNumber)
            System.out.println("Given number " + num + " is armstrong");
        else
            System.out.println("Given number " + num + " is NOT an armstrong");
    }

    private static int getSumOfCubesOfEachNumber(int num) {
        int sumOfCubesOfEachNumber = 0, temp = num;
        while (temp != 0) {
            int digit = temp % 10;
            sumOfCubesOfEachNumber += Math.pow(digit, 3);
            temp /= 10;
        }
        return sumOfCubesOfEachNumber;
    }
}
