package validate;

import entity.Course;

import java.util.Optional;
import java.util.Scanner;

import static business.CourseBussiness.courseList;

public class CourseValidate {
    public static String validateCourseName(Scanner sc){
        while(true){
            String cString = ValueDator.validateString(sc,new StringRule(5,0),"vui lòng nhập tên môn học");
            Optional<Course> course = courseList.stream().filter(c->c.getCourseName().equals(cString)).findFirst();
            if(course.isPresent()){
                return course.get().getCourseName();
            }else {
                System.out.println("tên môn học đã tồn tại");
            }
        }
    }
}
