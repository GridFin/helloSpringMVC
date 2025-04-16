package kr.ac.hansung.cse.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import kr.ac.hansung.cse.model.School;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SchoolDao {

    @PersistenceContext
    private EntityManager entityManager;

    // 전체 조회
    public List<School> getAllCourses() {
        return entityManager.createQuery("SELECT s FROM School s", School.class)
                .getResultList();
    }

    // 연도 + 학기별 조회
    public List<School> getCoursesByYearSemester(int year, int semester) {
        return entityManager.createQuery(
                        "SELECT s FROM School s WHERE s.year = :year AND s.semester = :semester", School.class)
                .setParameter("year", year)
                .setParameter("semester", semester)
                .getResultList();
    }

    // 삽입
    public void insert(School course) {
        entityManager.persist(course);
    }

    // 수정
    public void update(School course) {
        entityManager.merge(course);
    }

    // 삭제
    public void delete(String courseCode) {
        School course = entityManager.find(School.class, courseCode);
        if (course != null) {
            entityManager.remove(course);
        }
    }

    // 단일 조회
    public School getCourse(String courseCode) {
        return entityManager.find(School.class, courseCode);
    }
}