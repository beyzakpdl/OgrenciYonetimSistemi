package com.obs.studentmanagement.Repository;

import com.obs.studentmanagement.entity.Student;
import com.obs.studentmanagement.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    // JpaRepository, Teacher nesneleri üzerinde CRUD (Create, Read, Update, Delete) işlemlerini sağlar
    // TeacherRepository, Teacher sınıfı için veri erişim operasyonlarını yönetir ve Long türünde bir ID kullanır
}
