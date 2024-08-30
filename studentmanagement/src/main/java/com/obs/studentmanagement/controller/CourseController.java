package com.obs.studentmanagement.controller;

import com.obs.studentmanagement.dto.CourseDetailsDTO;
import com.obs.studentmanagement.entity.Course;
import com.obs.studentmanagement.service.Implement.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    /**
     * Yeni bir ders eklemek için endpoint.
     *
     * @param course Eklenmek istenen ders nesnesi.
     * @return Başarı mesajı ve HTTP 201 (Created) durum kodu ile ResponseEntity döner.
     */
    @PostMapping("/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        // Dersi kaydet ve başarılı bir şekilde kaydedildiğine dair bir mesaj döndür
        Course savedCourse = courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ders başarılı bir şekilde kaydedildi");
    }

    /**
     * Belirli bir dersi belirli bir öğretmene atamak için endpoint.
     *
     * @param courseId Atanacak dersin ID'si.
     * @param teacherId Atanacak öğretmenin ID'si.
     * @return Başarı mesajı veya atama işlemi başarısız olursa hata mesajı döner.
     */
    @PostMapping("/{courseId}/assignTeacher/{teacherId}")
    public ResponseEntity<String> assignTeacher(@PathVariable Long courseId, @PathVariable Long teacherId) {
        try {
            // Öğretmeni dersi atama işlemini gerçekleştir ve başarılı bir şekilde atandığını belirten bir mesaj döndür
            courseService.assignTeacherToCourse(courseId, teacherId);
            String message = "Öğretmen ID " + teacherId + " başarıyla Ders ID " + courseId + " ile ilişkilendirildi";
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            // İşlem sırasında bir hata oluşursa hata mesajı ve HTTP 400 (Bad Request) durum kodu döndür
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Belirli bir dersi belirli bir öğrenciye kaydetmek için endpoint.
     *
     * @param courseId Kaydedilecek dersin ID'si.
     * @param studentId Kaydedilecek öğrencinin ID'si.
     * @return Başarı mesajı veya kayıt işlemi başarısız olursa hata mesajı döner.
     */
    @PostMapping("/{courseId}/enrollStudent/{studentId}")
    public ResponseEntity<String> enrollStudentInCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        try {
            // Öğrenciyi dersi kaydetme işlemini gerçekleştir ve başarılı bir şekilde kaydedildiğini belirten bir mesaj döndür
            courseService.enrollStudentInCourse(courseId, studentId);
            String message = "Öğrenci ID " + studentId + " başarıyla Ders ID " + courseId + " ile kaydedildi";
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            // İşlem sırasında bir hata oluşursa hata mesajı ve HTTP 400 (Bad Request) durum kodu döndür
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Belirli bir dersin detaylarını almak için endpoint.
     *
     * @param courseId Detayları alınacak dersin ID'si.
     * @return Ders detayları ve HTTP 200 (OK) durum kodu ile ResponseEntity döner.
     */
    @GetMapping("/{courseId}/details")
    public ResponseEntity<CourseDetailsDTO> getCourseDetails(@PathVariable Long courseId) {
        // Ders detaylarını al ve yanıt olarak döndür
        CourseDetailsDTO courseDetails = courseService.getCourseDetails(courseId);
        return ResponseEntity.ok(courseDetails);
    }

    /**
     * Belirli bir dersi silmek için endpoint.
     *
     * @param id Silinecek dersin ID'si.
     * @return Dersin silindiğini belirten bir onay mesajı döner.
     */
    @DeleteMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable(value = "id") long id) {
        // Dersi sil ve silindiğine dair bir onay mesajı döndür
        boolean deleteCourse = courseService.deleteCourse(id);
        return "Ders silindi";
    }

}
