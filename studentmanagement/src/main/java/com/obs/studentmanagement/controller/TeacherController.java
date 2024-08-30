package com.obs.studentmanagement.controller;

import com.obs.studentmanagement.dto.*;
import com.obs.studentmanagement.entity.Teacher;
import com.obs.studentmanagement.service.StudentService;
import com.obs.studentmanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * Yeni bir öğretmeni kaydetmek için endpoint.
     *
     * @param teacherSaveDTO Kaydedilecek öğretmen bilgilerini içeren DTO.
     * @return Kaydedilen öğretmen bilgileri ve HTTP 201 (Created) durum kodu ile ResponseEntity döner.
     */
    @PostMapping("/saveTeacher")
    public ResponseEntity<TeacherSaveDTO> saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO) {
        // Öğretmeni ekle ve başarıyla kaydedildiğini belirten bilgileri döndür
        TeacherSaveDTO teacherName = teacherService.addTeacher(teacherSaveDTO);
        return new ResponseEntity<>(teacherName, HttpStatus.CREATED);
    }

    /**
     * Tüm öğretmenleri almak için endpoint.
     *
     * @return Tüm öğretmenlerin bilgilerini içeren bir liste ve HTTP 200 (OK) durum kodu ile ResponseEntity döner.
     */
    @GetMapping("/getAllTeachers")
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        // Tüm öğretmenleri al ve yanıt olarak döndür
        List<TeacherDTO> allTeachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(allTeachers);  // HTTP 200 OK ile öğretmenler listesini döndürür
    }

    /**
     * Var olan bir öğretmeni güncellemek için endpoint.
     *
     * @param teacherUpdateDTO Güncellenecek öğretmen bilgilerini içeren DTO.
     * @return Güncellenmiş öğretmenin adı ile yanıt döner.
     */
    @PutMapping("/updateTeacher")
    public String updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO) {
        // Öğretmeni güncelle ve güncellenmiş öğretmenin adını döndür
        String teacherName = teacherService.updateTeacher(teacherUpdateDTO);
        return teacherName;
    }

    /**
     * Belirli bir öğretmeni silmek için endpoint.
     *
     * @param id Silinecek öğretmenin ID'si.
     * @return Silme işlemi tamamlandığında bir onay mesajı döner.
     */
    @DeleteMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable(value = "id") long id) {
        // Öğretmeni sil ve silindiğine dair bir onay mesajı döndür
        boolean deleteTeacher = teacherService.deleteTeacher(id);
        return "Öğretmen silindi";
    }
}