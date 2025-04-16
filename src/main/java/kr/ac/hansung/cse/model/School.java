package kr.ac.hansung.cse.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="courses")
public class School {

    @NotNull(message = "수강년도는 필수입니다.")
    @Min(value = 2000, message = "2000년 이후만 입력 가능합니다.")
    private int year;              // 수강년도
    @NotNull(message = "학기는 필수입니다.")
    @Min(value = 1, message="학기는 1 또는 2만 입력 가능합니다.")
    @Max(value = 2, message="학기는 1 또는 2만 입력 가능합니다.")
    private int semester;          // 학기

    @Id
    @NotEmpty(message="교과코드를 입력해주세요")
    private String course_code;    // 교과코드 (기본키)

    @NotEmpty(message="교과목명을 입력해주세요")
    private String course_name;    // 교과목명
    @NotEmpty(message="교과구분을 입력해주세요")
    private String course_option;  // 교과구분
    @NotEmpty(message="담당교수를 입력해주세요")
    private String prof;           // 담당교수
    @NotNull(message="학점을 입력해주세요")
    @Min(value=1,message="학점은 1 이상이어야 합니다.")
    private int score;             // 학점

}
