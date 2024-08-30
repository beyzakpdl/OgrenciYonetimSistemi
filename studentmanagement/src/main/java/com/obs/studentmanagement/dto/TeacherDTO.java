package com.obs.studentmanagement.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TeacherDTO {
    private long teacherId;
    private String teacherName;
    private String mail;
    private String phone;



    /**
     * Parametrelerle TeacherDTO nesnesini başlatan constructor.
     *
     * @param teacherId Öğretmenin ID'si.
     * @param teacherName Öğretmenin adı.
     * @param mail Öğretmenin e-posta adresi.
     * @param phone Öğretmenin telefon numarası.
     */


    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId; // düzeltildi
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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