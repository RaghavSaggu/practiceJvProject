package exceptionHandling;

public class FinallyMythsBreaking {
    public static void main(String[] args) {
        try {
            System.out.println("We all know finally will always work whether exception occurs or not, finally will execute always!!!");
            System.out.println("I was wrong, how can it execute if system crashed or somebody just bombed my system");
            System.out.println("or lets suppose aeroplanes blackbox written in JAVA and aeroplane crashed");
            System.out.println("or Car's software written in JAVA and car crashed");
            // let's break the myth, to do so mark the flag true
            boolean mythBreakerFlag = true;
            if(mythBreakerFlag) {
                System.out.println("LOL");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("This is never gonna happen till I write a throw statement in my try block");
        } finally {
            System.out.println("--- and I know I am gonna execute always until any mishapping not happened written in try block");
        }
    }
}
