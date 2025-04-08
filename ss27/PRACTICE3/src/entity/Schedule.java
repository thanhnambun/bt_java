package entity;

import validate.ValueDator;

import java.time.LocalDate;

import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

import static business.ClassRoomBussiness.classRoomList;

public class Schedule implements IApp {
    private static int scheduleIdSequence = 0;
    private int scheduleId;
    private int classroomId;
    private LocalDate startTime;
    private LocalDate endTime;

    public Schedule() {
        this.scheduleId = ++scheduleIdSequence;
    }

    public Schedule(int classroomId, LocalDate startTime, LocalDate endTime) {
        this.scheduleId = ++scheduleIdSequence;
        this.classroomId = classroomId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    @Override
    public void inputData(Scanner sc) {
        this.scheduleId = ++scheduleIdSequence;
        this.classroomId = inputClassRoomId(sc);
        this.startTime = inputStartTime(sc);
        this.endTime = inputEndTime(sc);
        while (!isEndTimeValid(startTime, endTime)) {
            System.out.println("Thời gian kết thúc không thể trước thời gian bắt đầu. Vui lòng nhập lại.");
            this.endTime = inputEndTime(sc);
        }
    }

    public int inputClassRoomId(Scanner sc) {
        System.out.println("Vui lòng chọn lớp học: ");
        do {
            classRoomList.forEach(c -> System.out.println("ID: " + c.getClassRoomId() + ", Tên lớp: " + c.getClassRoomName()));
            int choice = ValueDator.validateInteger(sc, "Nhập ID của lớp học: ", 0);
            OptionalInt index = IntStream.range(0, classRoomList.size())
                    .filter(x -> classRoomList.get(x).getClassRoomId() == choice)
                    .findFirst();
            if (index.isPresent()) {
                return classRoomList.get(index.getAsInt()).getClassRoomId();
            } else {
                System.out.println("Không có ID lớp học với mã: " + choice);
            }
        } while (true);
    }

    public LocalDate inputStartTime(Scanner sc) {
        System.out.println("Vui lòng nhập thời gian bắt đầu (yyyy-MM-dd): ");
        return ValueDator.validateDate("Vui lòng nhập ngày bắt đầu hợp lệ: ", sc);
    }

    public LocalDate inputEndTime(Scanner sc) {
        System.out.println("Vui lòng nhập thời gian kết thúc (yyyy-MM-dd): ");
        return ValueDator.validateDate("Vui lòng nhập ngày kết thúc hợp lệ: ", sc);
    }

    public boolean isEndTimeValid(LocalDate startTime, LocalDate endTime) {
        return !endTime.isBefore(startTime);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", classroomId=" + classroomId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
