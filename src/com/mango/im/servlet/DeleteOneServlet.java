package com.mango.im.servlet;

import com.mango.im.bean.TMessage;
import com.mango.im.service.ListService;
import com.mango.im.service.MaintainService;

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
 * Description：单个删除Servlet
 */
@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.设置编码
        req.setCharacterEncoding("utf-8");
        // 2.获取前端表单数据
        String id = req.getParameter("id");
        // 3.获取数据、设值
        MaintainService maintainService = new MaintainService();
        maintainService.deleteOne(id);
        // 4.跳转
        req.getRequestDispatcher("List.action").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
