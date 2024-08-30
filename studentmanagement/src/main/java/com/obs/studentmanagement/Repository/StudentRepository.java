package com.obs.studentmanagement.Repository;

import com.obs.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    // JpaRepository, Student nesneleri üzerinde CRUD (Create, Read, Update, Delete) işlemlerini sağlar
    // StudentRepository, Student sınıfı için veri erişim operasyonlarını yönetir ve Long türünde bir ID kullanır

}
