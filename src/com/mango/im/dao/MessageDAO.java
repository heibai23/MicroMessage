package com.mango.im.dao;

import com.mango.im.bean.TMessage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author：Mango Cheng
 * Date：2020/5/25
 * Time：20:59
 * Description：信息DAO
 */
public class MessageDAO {

    /**
     * 根据条件获取信息集合
     *
     * @param command
     * @param description
     * @return
     */
    public List<TMessage> queryMessageList(String command, String description) {
        List<TMessage> messageList = new ArrayList<>();
        try {
            // 1.加载数据库驱动：mysql-8
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/micro_message";//数据库连接子协议
            // 2.创建连接
            Connection conn = DriverManager.getConnection(url, "root", "mysqlzkc123456");
            // 3.创建、处理预处理语句
            StringBuilder sql = new StringBuilder("select id,command,description,content from t_message where 1=1");
            List<String> paramList = new ArrayList<>();     // 参数
            if (command != null && !"".equals(command.trim())) {
                sql.append(" and command = ?");
                paramList.add(command);
            }
            if (description != null && !"".equals(description.trim())) {
                sql.append(" and description like '%' ? '%'");
                paramList.add(description);
            }
            PreparedStatement preparedStatement = conn.prepareStatement(sql.toString());
            for (int i = 0; i < paramList.size(); i++) {
                preparedStatement.setString(i + 1, paramList.get(i));
            }
            // 4.执行语句
            ResultSet rs = preparedStatement.executeQuery();
            // 5.读取结果集
            while (rs.next()) {
                TMessage message = new TMessage();
                message.setId((short) rs.getInt(1));
                message.setCommand(rs.getString(2));
                message.setDescription(rs.getString(3));
                message.setContent(rs.getString(4));
                messageList.add(message);
            }
            // 6.关闭资源
            rs.close();
            preparedStatement.close();
            conn.close();
            System.out.println("[Result:messageList]-" + messageList.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageList;
    }
}
