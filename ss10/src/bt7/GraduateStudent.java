package bt7;

import java.util.Scanner;

public class GraduateStudent extends Student {
    private String researchTopic;
    private String supervisorName;

    public GraduateStudent() {}

    public GraduateStudent(double gpa, String id, String name, String researchTopic, String supervisorName) {
        super(gpa, id, name);
        this.researchTopic = researchTopic;
        this.supervisorName = supervisorName;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        if (researchTopic == null) {
            System.out.println("lỗi");
        }else {
            this.researchTopic = researchTopic;
        }
    }

    public String getSupervisorName() {

        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        if (supervisorName == null) {
            System.out.println("lỗi");
        }else {
            this.supervisorName = supervisorName;
        }
    }

    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("đề tài nghiên cứu: "+researchTopic);
        System.out.println("tên giảng viên hướng dẫn: "+supervisorName);
    }

    public void inputdata (Scanner sc){
        System.out.println("vuilongfgf nhập tên sinh viên ");
        this.setGpa(sc.nextDouble());
    }

}
