package com.obs.studentmanagement.service;

import com.obs.studentmanagement.dto.StudentDTO;
import com.obs.studentmanagement.dto.StudentSaveDTO;
import com.obs.studentmanagement.dto.StudentUpdateDTO;

import java.util.List;

public interface StudentService {

    /**
     * Yeni bir öğrenci ekler.
     * @param studentSaveDTO Öğrenci bilgilerini içeren DTO.
     * @return Eklenen öğrencinin bilgilerini içeren DTO.
     */
    StudentSaveDTO addStudent(StudentSaveDTO studentSaveDTO);

    /**
     * Tüm öğrencileri getirir.
     * @return Öğrencilerin bilgilerini içeren DTO listesi.
     */
    List<StudentDTO> getAllStudents();

    /**
     * Var olan bir öğrenciyi günceller.
     * @param studentUpdateDTO Güncellenmiş öğrenci bilgilerini içeren DTO.
     * @return Güncellenen öğrencinin ismi.
     */
    String updateStudent(StudentUpdateDTO studentUpdateDTO);

    /**
     * Bir öğrenciyi siler.
     * @param id Silinecek öğrencinin ID'si.
     * @return Silme işleminin başarılı olup olmadığını belirten boolean değer.
     */
    boolean deleteStudent(long id);
}