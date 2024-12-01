package com.springboot.springboot.service.serviceImpl;

import com.springboot.springboot.domain.AtdInfo;
import com.springboot.springboot.repository.AtdInfoDao;
import com.springboot.springboot.service.AtdInfoService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class AtdInfoServiceImpl implements AtdInfoService {
    @Resource
    private AtdInfoDao atdInfoDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public AtdInfo displayAtdInfoService(Integer id) {
        String sql = "SELECT COLUMN_NAME FROM information_schema.columns WHERE table_name = 'attendance'";

        // 使用 query 方法执行查询并映射结果
        List<String> columnNames = jdbcTemplate.queryForList(sql, String.class);
        System.out.println(columnNames);
        System.out.println(columnNames.size());
        // 定义SQL查询，使用参数占位符而不是字符串拼接

        if(Objects.equals(columnNames.size(), 3)){
            return null;
        }
        String sqlfind = "SELECT * FROM attendance WHERE id = ?";

        // 执行查询，使用参数化的方式传递id值
        List<Map<String, Object>> findRes = jdbcTemplate.queryForList(sqlfind, new Object[]{id});

        // 检查结果列表是否不为空，并且确实包含了一行数据
        if (!findRes.isEmpty()) {
            // 获取查询结果的第一行（也是唯一一行）
            Map<String, Object> row = findRes.get(0);

            // 从这里开始，你可以将这一行数据转换为AtdInfo对象或者以其他方式存储
            AtdInfo atdInfo = new AtdInfo();
            atdInfo.setId( (Integer) row.get("id"));
            atdInfo.setNjuid((String) row.get("njuid"));
            atdInfo.setSname((String) row.get("sname"));
            // 假设你有一个方法来处理动态字段
            atdInfo.setStates(mapDynamicFields(row));
            return atdInfo;
            // 现在 atdInfo 包含了查询结果，你可以将它存储或者做其他处理
        }
        return null;

    }
    // 动态字段映射方法
    private Map<String, String> mapDynamicFields(Map<String, Object> row) {
        Map<String, String> dynamicFields = new HashMap<>();
        // 假设你已经知道了所有的列名，这里只是一个示例
        // 实际上你可能需要从row中获取所有键作为列名
        for (Map.Entry<String, Object> entry : row.entrySet()) {
            // 排除已知的固定列
            if (!"id".equals(entry.getKey()) && !"njuid".equals(entry.getKey()) && !"sname".equals(entry.getKey())) {
                dynamicFields.put(entry.getKey(), (String) entry.getValue());
            }
        }
        return dynamicFields;
    }
}
