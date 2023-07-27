class CheckedException extends Exception {
    public CheckedException(String message) {
        super(message);
    }
}
class UncheckedException extends RuntimeException {
    public UncheckedException(String message) {
        super(message);
    }
}
public class Main {
    public static void main(String[] args) {
        try {
            throwCheckedException();
        } catch (CheckedException e) {
            System.out.println("Проверяемое исключение: " + e.getMessage());
        }

        try {
            throwUncheckedException();
        } catch (UncheckedException e) {
            System.out.println("Непроверяемое исключение: " + e.getMessage());
        }
    }
    public static void throwCheckedException() throws CheckedException {
        throw new CheckedException("Проверяемое исключение");
    }
    public static void throwUncheckedException() {
        throw new UncheckedException("Непроверяемое исключение");
    }
}