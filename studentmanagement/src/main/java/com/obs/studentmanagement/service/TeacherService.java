package com.obs.studentmanagement.service;

import com.obs.studentmanagement.dto.*;

import java.util.List;

public interface TeacherService {

    /**
     * Yeni bir öğretmen ekler.
     * @param teacherSaveDTO Öğretmen bilgilerini içeren DTO.
     * @return Eklenen öğretmenin bilgilerini içeren DTO.
     */
    TeacherSaveDTO addTeacher(TeacherSaveDTO teacherSaveDTO);

    /**
     * Tüm öğretmenleri getirir.
     * @return Öğretmenlerin bilgilerini içeren DTO listesi.
     */
    List<TeacherDTO> getAllTeachers();

    /**
     * Var olan bir öğretmeni günceller.
     * @param teacherUpdateDTO Güncellenmiş öğretmen bilgilerini içeren DTO.
     * @return Güncellenen öğretmenin ismi.
     */
    String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);

    /**
     * Bir öğretmeni siler.
     * @param id Silinecek öğretmenin ID'si.
     * @return Silme işleminin başarılı olup olmadığını belirten boolean değer.
     */
    boolean deleteTeacher(long id);
}