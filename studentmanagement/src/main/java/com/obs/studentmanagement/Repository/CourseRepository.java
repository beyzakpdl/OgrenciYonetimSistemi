package com.obs.studentmanagement.Repository;

import com.obs.studentmanagement.entity.Course;
import com.obs.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    // JpaRepository, Course nesneleri üzerinde CRUD (Create, Read, Update, Delete) işlemlerini sağlar
    // CourseRepository, Course sınıfı için veri erişim operasyonlarını yönetir ve Long türünde bir ID kullanır
}
