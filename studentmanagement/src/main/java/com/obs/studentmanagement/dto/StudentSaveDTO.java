package com.obs.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentSaveDTO {
    private String studentName;
    private String mail;
    private String phone;

    /**
     * Parametrelerle StudentSaveDTO nesnesini başlatan constructor.
     *
     * @param studentName Öğrencinin adı.
     * @param mail Öğrencinin e-posta adresi.
     * @param phone Öğrencinin telefon numarası.
     */


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