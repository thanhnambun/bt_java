package bt8;

public class InvalidPhoneNumberLengthException extends Exception {
    public InvalidPhoneNumberLengthException(String s) {
        super(s);
    }
    public static void validatePhoneNumber(String phone) throws InvalidPhoneNumberLengthException {
        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberLengthException("Số điện thoại phải gồm đúng 10 chữ số và không chứa ký tự đặc biệt!");
        }
    }
}
