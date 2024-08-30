package com.obs.studentmanagement.service.Implement;

import com.obs.studentmanagement.dto.StudentDTO;
import com.obs.studentmanagement.dto.StudentSaveDTO;
import com.obs.studentmanagement.dto.StudentUpdateDTO;
import com.obs.studentmanagement.entity.Student;
import com.obs.studentmanagement.Repository.StudentRepository;
import com.obs.studentmanagement.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentServiceImplement implements StudentService {

    @Autowired
    private StudentRepository studentRepo;

    // Yeni bir öğrenci ekler
    // StudentSaveDTO'dan öğrenci bilgilerini alır, yeni bir Student nesnesi oluşturur ve veritabanına kaydeder
    // Kaydedilen öğrenci bilgilerini içeren DTO'yu geri döner
    @Override
    public StudentSaveDTO addStudent(StudentSaveDTO studentSaveDTO) {
        Student student = new Student();
        student.setStudentName(studentSaveDTO.getStudentName());
        student.setMail(studentSaveDTO.getMail());
        student.setPhone(studentSaveDTO.getPhone());
        studentRepo.save(student);
        return studentSaveDTO;
    }

    // Tüm öğrencileri getirir
    // Veritabanından tüm öğrencileri alır, StudentDTO listesine dönüştürür ve geri döner
    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> getStudents = studentRepo.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (Student student : getStudents) {
            StudentDTO studentDTO = new StudentDTO(student.getStudentId(),
                    student.getStudentName(),
                    student.getMail(),
                    student.getPhone());
            studentDTOList.add(studentDTO);
        }

        return studentDTOList;
    }

    // Mevcut bir öğrencinin bilgilerini günceller
    // Eğer öğrenci mevcutsa, bilgileri günceller ve veritabanına kaydeder
    // Güncellenen öğrencinin ismini döner
    // Öğrenci mevcut değilse "Invalid Id" mesajını yazdırır
    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {
        if (studentRepo.existsById(studentUpdateDTO.getStudentId())) {
            Student student = studentRepo.getById(studentUpdateDTO.getStudentId());

            student.setStudentName(studentUpdateDTO.getStudentName());
            student.setMail(studentUpdateDTO.getMail());
            student.setPhone(studentUpdateDTO.getPhone());
            studentRepo.save(student);
            return student.getStudentName();
        } else {
            System.out.println("Invalid Id");
        }
        return "";
    }

    // Verilen ID'ye sahip öğrenciyi siler
    // Eğer öğrenci mevcutsa, veritabanından siler
    // Öğrenci mevcut değilse "Invalid Id" mesajını yazdırır
    @Override
    public boolean deleteStudent(long id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return true; // Öğrenci başarılı bir şekilde silindi
        } else {
            System.out.println("Invalid Id");
            return false; // Öğrenci bulunamadı
        }
    }
}