package com.obs.studentmanagement.dto;

public class TeacherSaveDTO {
    private String teacherName;
    private String mail;
    private String phone;

    /**
     * Parametrelerle TeacherSaveDTO nesnesini başlatan constructor.
     *
     * @param teacherName Öğretmenin adı.
     * @param mail Öğretmenin e-posta adresi.
     * @param phone Öğretmenin telefon numarası.
     */
    public TeacherSaveDTO(String teacherName, String mail, String phone) {
        this.teacherName = teacherName;
        this.mail = mail;
        this.phone = phone;
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
