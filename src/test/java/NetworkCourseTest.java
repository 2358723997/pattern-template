import com.edu.gupao.vip.pattern.template.course.BigDataCourse;
import com.edu.gupao.vip.pattern.template.course.JavaCourse;

/**
 * NetworkCourse类
 * 模板会有一个或多个未实现方法，而且这几个未实现的方法有固定的执行顺序
 * @author wangjixue
 * @date 2019-07-21 22:33
 */
public abstract class NetworkCourseTest {

    public static void main(String[] args) {
        JavaCourse javaCourse = new JavaCourse();
        javaCourse.createCourse();
        System.err.println("-----------");
        BigDataCourse bigDataCourse = new BigDataCourse(true);
        bigDataCourse.createCourse();
    }
}
