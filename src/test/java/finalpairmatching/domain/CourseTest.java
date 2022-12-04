package finalpairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CourseTest {

    @Test
    @DisplayName("존재하지 않는 코스일때 예외")
    void validateCourse() {

        assertThatThrownBy(() -> Course.findCourse("가운데엔드"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("존재하는 코스 확인")
    @CsvSource(value = {
            "백엔드,BACKEND",
            "프론트엔드,FRONTEND"
    })
    void returnCourse(String name, Course course) {
        assertThat(Course.findCourse(name)).isEqualTo(course);
    }

    @Test
    @DisplayName("코스 체크 확인")
    void checkCourse() {
        Course course = Course.findCourse("백엔드");

        assertThat(course.checkCourse("백엔드")).isTrue();
        assertThat(course.checkCourse("프론트엔드")).isFalse();
    }
}
