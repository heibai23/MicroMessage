package com.mango.im.service;

import com.mango.im.bean.TMessage;
import com.mango.im.dao.MessageDAO;

import java.util.List;

/**
 * Author：Mango Cheng
 * Date：2020/5/25
 * Time：21:11
 * Description：服务类
 */
public class ListService {

    /**
     * 根据条件获取信息集合
     * @param command
     * @param description
     * @return
     */
    public List<TMessage> queryMessageList(String command, String description) {
        MessageDAO messageDAO = new MessageDAO();
        return messageDAO.queryMessageList(command, description);
    }
}
