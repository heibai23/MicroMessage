package com.mango.im.servlet;

import com.mango.im.bean.TMessage;
import com.mango.im.dao.MessageDAO;
import com.mango.im.service.ListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author：Mango Cheng
 * Date：2020/5/25
 * Time：11:08
 * Description：列表Servlet
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.设置编码
        req.setCharacterEncoding("utf-8");
        // 2.获取前端表单数据
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        // 3.获取数据、设值
        req.setAttribute("command", command);
        req.setAttribute("description", description);
        ListService listService = new ListService();
        List<TMessage> messageList = listService.queryMessageList(command, description);
        req.setAttribute("messageList", messageList);
        // 4.跳转
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
