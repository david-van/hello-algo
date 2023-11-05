package utils;

/**
 * @author david_van
 * @date 2023/11/5 10:42
 */
public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}
