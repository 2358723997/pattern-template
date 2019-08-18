import com.edu.gupao.vip.pattern.template.jdbc.dao.MemberDao;

import javax.sql.DataSource;
import java.util.List;

/**
 * MemberDaoTest类
 *
 * @author wangjixue
 * @date 2019-07-22 01:13
 */
public class MemberDaoTest {
    public static void main(String[] args) throws Exception{
        MemberDao memberDao= new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.err.println(result);
    }
}
