package kr.ac.hansung.cse.controller;

import jakarta.validation.Valid;
import kr.ac.hansung.cse.model.School;
import kr.ac.hansung.cse.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("")
    public String home() {
        return "school/home";
    }

    // 학기별 총 학점 조회 (뷰에서 가져옴)
    @GetMapping("/credits")
    public String viewCredits(Model model) {
        List<Object[]> summary = schoolService.getCreditSummaryRaw();
        model.addAttribute("summary", summary);
        return "school/credits";
    }

    @GetMapping("/credits/detail")
    public String viewCreditsDetail(@RequestParam("year") int year,
                                    @RequestParam("semester") int semester,
                                    Model model) {
        List<School> courses = schoolService.getCoursesByYearSemester(year, semester);
        model.addAttribute("courses", courses);
        model.addAttribute("year", year);
        model.addAttribute("semester", semester);
        return "school/detail";
    }


    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("course", new School());
        return "school/register";
    }

    @PostMapping("/register")
    public String registerCourse(@Valid @ModelAttribute("course") School course,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "school/register"; // 오류 시 다시 폼으로
        }

        schoolService.registerCourse(course);
        return "redirect:/school/courses?year=" + course.getYear() + "&semester=" + course.getSemester();
    }


    @GetMapping("/courses")
    public String viewCourses(@RequestParam("year") int year, @RequestParam("semester") int semester, Model model) {
        List<School> courses = schoolService.getCoursesByYearSemester(year, semester);
        model.addAttribute("courses", courses);
        model.addAttribute("year", year);
        model.addAttribute("semester", semester);
        return "school/courses";
    }
}
