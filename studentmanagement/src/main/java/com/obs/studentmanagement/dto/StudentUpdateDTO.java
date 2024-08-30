package com.obs.studentmanagement.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentUpdateDTO {
    private long studentId;
    private String studentName;
    private String mail;
    private String phone;

    /**
     * Parametrelerle StudentUpdateDTO nesnesini başlatan constructor.
     *
     * @param studentId Öğrencinin ID'si.
     * @param studentName Öğrencinin adı.
     * @param mail Öğrencinin e-posta adresi.
     * @param phone Öğrencinin telefon numarası.
     */
//    public StudentUpdateDTO(long studentId, String studentName, String mail, String phone) {
//        this.studentId = studentId;
//        this.studentName = studentName;
//        this.mail = mail;
//        this.phone = phone;
//    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
