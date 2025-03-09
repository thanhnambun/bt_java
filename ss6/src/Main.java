import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        /*
            1 nhập số phần tử của mảng và khai báo số ngueeen n phần tử
            2 nhập giá trị và chỉ số pần tử chèn vào mảng
            ********
            b1 nhập số phần tử khai báo mảng nhập giá trị phần tử

         */
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int [] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("arr[%d]: ", i);
            arr[i] = sc.nextInt();
        }
        int[]newArr ;
        System.out.println("nhập vào giá trị phaanf tử cần chèn ");
        int value = Integer.parseInt(sc.nextLine());
        System.out.println("nhập vào chỉ số cần chèn ");
        int index = Integer.parseInt(sc.nextLine());
        if(index < 0 ){
            newArr=new int[index+1];
            for (int i = 1; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            System.err.println("không tồn tại chỉ sôs " +index);
        } else if (index < arr.length ) {
             newArr = new int[arr.length +1];
            for (int i = 1; i < newArr.length; i++) {
                if(i<=index){
                    newArr[i] = arr[i];
                } else if (i==index) {
                    newArr[i] = value;
                }else {
                    newArr[i] = arr[i-1];
                }
            }
        }else {
            newArr=new int[index+1];
            for (int i = 1; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            newArr[index] = value;
        }
        for (int element : newArr) {
            System.out.print(element + " ");
        }
    }
}