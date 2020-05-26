package com.mango.im.dao;

import com.mango.im.bean.TMessage;
import com.mango.im.db.DBAcess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author：Mango Cheng
 * Date：2020/5/26
 * Time：07:59
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
        // 1.定义
        List<TMessage> messageList = new ArrayList<>();
        DBAcess dbAcess = new DBAcess();
        SqlSession sqlSession = null;
        try {
            // 2.获取
            sqlSession = dbAcess.getSqlSession();
            // 3.查询： namespace.id
            TMessage message = new TMessage();
            message.setCommand(command);
            message.setDescription(description);
            messageList = sqlSession.selectList("Message.queryMessageList",message);
            System.out.println("[Result:messageList]-" + messageList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            sqlSession.close();
        }
        return messageList;
    }

    /**
     * 根据条件删除
     * @param id
     */
    public void deleteOne(short id) {
        // 1.定义
        DBAcess dbAcess = new DBAcess();
        SqlSession sqlSession = null;
        try {
            // 2.获取
            sqlSession = dbAcess.getSqlSession();
            // 3.删除：id
            sqlSession.delete("Message.deleteOne",id);
            // 4.提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            sqlSession.close();
        }
    }

    /**
     * 根据条件批量删除
     * @param idList
     */
    public void deleteBatch(List<Short> idList) {
        // 1.定义
        DBAcess dbAcess = new DBAcess();
        SqlSession sqlSession = null;
        try {
            // 2.获取
            sqlSession = dbAcess.getSqlSession();
            // 3.删除
            sqlSession.delete("Message.deleteBatch",idList);
            // 4.提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            sqlSession.close();
        }
    }

    public static void main(String[] args) {
        MessageDAO messageDAO = new MessageDAO();
        messageDAO.queryMessageList("", "");
//         Types.SMALLINT
    }
}
