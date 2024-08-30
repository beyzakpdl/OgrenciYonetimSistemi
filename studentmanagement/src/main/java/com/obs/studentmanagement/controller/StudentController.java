package com.obs.studentmanagement.controller;

import com.obs.studentmanagement.dto.StudentDTO;
import com.obs.studentmanagement.dto.StudentSaveDTO;
import com.obs.studentmanagement.dto.StudentUpdateDTO;
import com.obs.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Yeni bir öğrenciyi kaydetmek için endpoint.
     *
     * @param studentSaveDTO Kaydedilecek öğrenci bilgilerini içeren DTO.
     * @return Kaydedilen öğrenci bilgileri ve HTTP 201 (Created) durum kodu ile ResponseEntity döner.
     */
    @PostMapping("/saveStudent")
    public ResponseEntity<StudentSaveDTO> saveStudent(@RequestBody StudentSaveDTO studentSaveDTO) {
        // Öğrenciyi ekle ve başarıyla kaydedildiğini belirten bilgileri döndür
        StudentSaveDTO studentName = studentService.addStudent(studentSaveDTO);
        return new ResponseEntity<>(studentName, HttpStatus.CREATED);
    }

    /**
     * Tüm öğrencileri almak için endpoint.
     *
     * @return Tüm öğrencilerin bilgilerini içeren bir liste ve HTTP 200 (OK) durum kodu ile ResponseEntity döner.
     */
    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        // Tüm öğrencileri al ve yanıt olarak döndür
        List<StudentDTO> allStudents = studentService.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }

    /**
     * Var olan bir öğrenciyi güncellemek için endpoint.
     *
     * @param studentUpdateDTO Güncellenecek öğrenci bilgilerini içeren DTO.
     * @return Güncellenmiş öğrencinin adı ile yanıt döner.
     */
    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO) {
        // Öğrenciyi güncelle ve güncellenmiş öğrencinin adını döndür
        String studentName = studentService.updateStudent(studentUpdateDTO);
        return studentName;
    }

    /**
     * Belirli bir öğrenciyi silmek için endpoint.
     *
     * @param id Silinecek öğrencinin ID'si.
     * @return Silme işlemi tamamlandığında bir onay mesajı döner.
     */
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id) {
        // Öğrenciyi sil ve silindiğine dair bir onay mesajı döndür
        boolean deleteStudent = studentService.deleteStudent(id);
        return "Öğrenci silindi";
    }
}