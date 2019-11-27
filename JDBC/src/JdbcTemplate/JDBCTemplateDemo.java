package JdbcTemplate;

import datasource.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateDemo {
    public static void main(String[] args) {
        //导入jar包
        //创建JDBCTemplate 对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //调用方法
        String sql =" update accont set balance =5000 where id =?";
        int count = template.update(sql, 3);
        System.out.println(count);
    }


}
