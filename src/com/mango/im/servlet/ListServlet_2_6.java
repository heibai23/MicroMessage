package com.mango.im.servlet;

import com.mango.im.bean.TMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author：Mango Cheng
 * Date：2020/5/25
 * Time：20:55
 * Description：列表Servlet  2-6章节
 */
@SuppressWarnings("serial")
public class ListServlet_2_6 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 声明对象,获取前端表单数据
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        /**
         * 注意点：
         * 1.jdbc驱动版本与本地mysql对应
         * 2.驱动包放置tomcat安装目录lib文件夹下
         */
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
                req.setAttribute("command", command);
            }
            if (description != null && !"".equals(description.trim())) {
                sql.append(" and description like '%' ? '%'");
                paramList.add(description);
                req.setAttribute("description", description);
            }
            PreparedStatement preparedStatement = conn.prepareStatement(sql.toString());
            for (int i = 0; i < paramList.size(); i++) {
                preparedStatement.setString(i + 1, paramList.get(i));
            }
            // 4.执行语句
            ResultSet rs = preparedStatement.executeQuery();
            // 4.1 读取结果集
            List<TMessage> messageList = new ArrayList<>();
            while (rs.next()) {
                TMessage message = new TMessage();
                message.setId((short) rs.getInt(1));
                message.setCommand(rs.getString(2));
                message.setDescription(rs.getString(3));
                message.setContent(rs.getString(4));
                messageList.add(message);
            }
            req.setAttribute("messageList", messageList);    // 设值
            // 5.关闭资源
            rs.close();
            preparedStatement.close();
            conn.close();
            System.out.println("[Result:messageList]-" + messageList.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

