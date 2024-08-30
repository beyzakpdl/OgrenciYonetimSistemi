package com.obs.studentmanagement.service.Implement;

import com.obs.studentmanagement.Repository.CourseRepository;
import com.obs.studentmanagement.Repository.StudentRepository;
import com.obs.studentmanagement.Repository.TeacherRepository;
import com.obs.studentmanagement.dto.CourseDetailsDTO;
import com.obs.studentmanagement.entity.Course;
import com.obs.studentmanagement.entity.Student;
import com.obs.studentmanagement.entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Kursu eklerken, duration değerinin geçerli olup olmadığını kontrol eder
    // Eğer duration sıfır veya daha küçükse, bir IllegalArgumentException fırlatır
    // Geçerli bir duration varsa, kursu veritabanına kaydeder
    public Course addCourse(Course course) {
        if (course.getDuration() <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero");
        }
        return courseRepository.save(course);
    }

    // Verilen kurs ID'sine öğretmen atar
    // Kurs veya öğretmen bulunamazsa RuntimeException fırlatır
    // Kursa zaten bir öğretmen atanmışsa, bir RuntimeException fırlatır
    public void assignTeacherToCourse(Long courseId, Long teacherId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        if (course.getTeacher() != null) {
            throw new RuntimeException("Course already has a teacher assigned");
        }

        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    // Verilen kurs ID'sine öğrenci kaydeder
    // Kurs veya öğrenci bulunamazsa RuntimeException fırlatır
    // Öğrenci zaten kursa kayıtlıysa, bir RuntimeException fırlatır
    public void enrollStudentInCourse(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (course.getStudents().contains(student)) {
            throw new RuntimeException("Student is already enrolled in this course");
        } else {
            course.getStudents().add(student);
            courseRepository.save(course);
        }
    }

    // Kurs detaylarını getirir
    // Eğer kurs bulunamazsa RuntimeException fırlatır
    // Kursa atanmış öğretmen varsa öğretmenin ismini, yoksa "No teacher assigned" döner
    // Kursa kayıtlı öğrenciler varsa, öğrencilerin isimlerini döner; yoksa "No students enrolled" döner
    public CourseDetailsDTO getCourseDetails(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        String teacherName = course.getTeacher() != null ? course.getTeacher().getTeacherName() : "No teacher assigned";

        List<String> studentNames = course.getStudents().isEmpty()
                ? Collections.singletonList("No students enrolled")
                : course.getStudents().stream()
                .map(Student::getStudentName)
                .collect(Collectors.toList());

        return new CourseDetailsDTO(course.getCourseName(), teacherName, studentNames, course.getDuration());
    }

    // Verilen ID'ye sahip kursu siler
    // Eğer kurs bulunamazsa, "Invalid Id" mesajını yazdırır
    public boolean deleteCourse(long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true; // Kurs başarılı bir şekilde silindi
        } else {
            System.out.println("Invalid Id");
            return false; // Kurs bulunamadı
        }
    }
}