package validate;

import entity.ClassRoom;

import java.util.Optional;
import java.util.Scanner;

import static business.ClassRoomBussiness.classRoomList;

public class ClassRoomValidate {
    public static String validateClassRoomName(Scanner sc){
        while(true){
            String clString = ValueDator.validateString(sc,new StringRule(50,15),"vui lòng nhập tên lớp học");
            Optional<ClassRoom> classRoom = classRoomList.stream().filter(c->c.getClassRoomName().equals(clString)).findFirst();
            if(classRoom.isPresent()){
                return classRoom.get().getClassRoomName();
            }else {
                System.out.println("tên lớp học đã tồn tại");
            }
        }
    }
}
