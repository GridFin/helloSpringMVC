package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.CreditSummaryDao;
import kr.ac.hansung.cse.dao.SchoolDao;
import kr.ac.hansung.cse.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    @Autowired
    private CreditSummaryDao creditSummaryDao;

    // 기존 로직 (수강 등록, 과목 조회 등)
    public List<School> getAllCourses() {
        return schoolDao.getAllCourses();
    }

    public List<School> getCoursesByYearSemester(int year, int semester) {
        return schoolDao.getCoursesByYearSemester(year, semester);
    }

    public void registerCourse(School course) {
        schoolDao.insert(course);
    }

    public void updateCourse(School course) {
        schoolDao.update(course);
    }

    public void deleteCourse(String courseCode) {
        schoolDao.delete(courseCode);
    }

    public School getCourse(String courseCode) {
        return schoolDao.getCourse(courseCode);
    }

    // ⬇️ 학기별 총 학점 (뷰 기반 조회)
    public List<Object[]> getCreditSummaryRaw() {
        return creditSummaryDao.getCreditSummaryRaw();
    }
}
