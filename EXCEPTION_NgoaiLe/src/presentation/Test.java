package presentation;

import util.Validator;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validator.validateInt(sc);
        Validator.validateFloat(sc);
        Validator.validateDouble(sc);
        Validator.validateBoolean(sc);
        Validator.validateString(sc,3,50);
        Validator.validateEmail(sc,"vui lòng nhập email");
        Validator.validatePhone(sc,"vui lòng nhập  phone");
    }
}
