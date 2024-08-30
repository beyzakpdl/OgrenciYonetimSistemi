package com.obs.studentmanagement.dto;

public class TeacherUpdateDTO {
    private long teacherId;    // Düzeltildi: Küçük harfle başlamalı
    private String teacherName;
    private String mail;
    private String phone;

    /**
     * Parametrelerle TeacherUpdateDTO nesnesini başlatan constructor.
     *
     * @param teacherId Öğretmenin ID'si.
     * @param teacherName Öğretmenin adı.
     * @param mail Öğretmenin e-posta adresi.
     * @param phone Öğretmenin telefon numarası.
     */
    public TeacherUpdateDTO(long teacherId, String teacherName, String mail, String phone) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.mail = mail;
        this.phone = phone;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
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