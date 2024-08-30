package com.obs.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Queue;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDetailsDTO {
    private String courseName;
    private String teacherNames;
    private List<String> studentNames;
    private int duration;

    /**
     * Parametrelerle CourseDetailsDTO nesnesini başlatan constructor.
     *
     * @param courseName Dersin adı.
     * @param teacherNames Öğretmenlerin adı (string olarak).
     * @param studentNames Öğrencilerin adlarının listesi.
     * @param duration Dersin süresi (dakika olarak).
     */
//    public CourseDetailsDTO(String courseName, String teacherNames, List<String> studentNames, int duration) {
//        this.courseName = courseName;
//        this.teacherNames = teacherNames;
//        this.studentNames = studentNames;
//        this.duration = duration;
//    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherNames() {
        return teacherNames;
    }

    public void setTeacherNames(String teacherNames) {
        this.teacherNames = teacherNames;
    }

    public List<String> getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(List<String> studentNames) {
        this.studentNames = studentNames;
    }
}