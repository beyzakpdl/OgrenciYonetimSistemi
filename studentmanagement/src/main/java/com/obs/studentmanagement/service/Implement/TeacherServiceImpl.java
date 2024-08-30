package com.obs.studentmanagement.service.Implement;

import com.obs.studentmanagement.Repository.StudentRepository;
import com.obs.studentmanagement.Repository.TeacherRepository;
import com.obs.studentmanagement.dto.*;
import com.obs.studentmanagement.entity.Student;
import com.obs.studentmanagement.entity.Teacher;
import com.obs.studentmanagement.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepo;

    // Yeni bir öğretmen ekler
    // TeacherSaveDTO'dan öğretmen bilgilerini alır, yeni bir Teacher nesnesi oluşturur ve veritabanına kaydeder
    // Kaydedilen öğretmen bilgilerini içeren DTO'yu geri döner
    @Override
    public TeacherSaveDTO addTeacher(TeacherSaveDTO teacherSaveDTO) {
        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherSaveDTO.getTeacherName());
        teacher.setMail(teacherSaveDTO.getMail());
        teacher.setPhone(teacherSaveDTO.getPhone());
        teacherRepo.save(teacher);
        return teacherSaveDTO;
    }

    // Tüm öğretmenleri getirir
    // Veritabanından tüm öğretmenleri alır, TeacherDTO listesine dönüştürür ve geri döner
    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> getTeachers = teacherRepo.findAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();

        for (Teacher teacher : getTeachers) {
            TeacherDTO teacherDTO = new TeacherDTO(teacher.getTeacherId(),
                    teacher.getTeacherName(),
                    teacher.getMail(),
                    teacher.getPhone());
            teacherDTOList.add(teacherDTO);
        }

        return teacherDTOList;
    }

    // Mevcut bir öğretmenin bilgilerini günceller
    // Eğer öğretmen mevcutsa, bilgileri günceller ve veritabanına kaydeder
    // Güncellenen öğretmenin ismini döner
    // Öğretmen mevcut değilse "Invalid Id" mesajını yazdırır
    @Override
    public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {
        if (teacherRepo.existsById(teacherUpdateDTO.getTeacherId())) {
            Teacher teacher = teacherRepo.getById(teacherUpdateDTO.getTeacherId());

            teacher.setTeacherName(teacherUpdateDTO.getTeacherName());
            teacher.setMail(teacherUpdateDTO.getMail());
            teacher.setPhone(teacherUpdateDTO.getPhone());
            teacherRepo.save(teacher);
            return teacher.getTeacherName();
        } else {
            System.out.println("Invalid Id");
        }
        return "";
    }

    // Verilen ID'ye sahip öğretmeni siler
    // Eğer öğretmen mevcutsa, veritabanından siler
    // Öğretmen mevcut değilse "Invalid Id" mesajını yazdırır
    @Override
    public boolean deleteTeacher(long id) {
        if (teacherRepo.existsById(id)) {
            teacherRepo.deleteById(id);
            return true; // Öğretmen başarılı bir şekilde silindi
        } else {
            System.out.println("Invalid Id");
            return false; // Öğretmen bulunamadı
        }
    }
}
