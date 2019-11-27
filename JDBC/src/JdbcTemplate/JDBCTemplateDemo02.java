package JdbcTemplate;

import datasource.JDBCUtils;
import domain.emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.awt.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTemplateDemo02 {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void test() {
        System.out.println("被执行了！");
    }

    @Test
    public void test01() {
        String sql = "select * from emp1 where id = ? ";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }

    @Test
    public void test02() {
        String sql = "select * from emp1";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> valuse : list) {
            System.out.println(valuse);
        }
    }

    @Test
    public void test03() {
        String sql = "select * from emp1";
        List<emp> list = template.query(sql, new RowMapper<emp>() {
            @Override
            public emp mapRow(ResultSet rs, int i) throws SQLException {
                emp emp = new emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                return emp;
            }
        });

        for (emp emp : list) {
            System.out.println(emp);
        }

    }

    @Test
    public void test04() {
        String sql = "select * from emp1";
        List<emp> list = template.query(sql, new BeanPropertyRowMapper<emp>(emp.class));
        for (emp emp : list) {
            System.out.println(emp);
        }
    }


    @Test
    public void test05() {
        String sql = "select count(id) from emp1";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }

}
