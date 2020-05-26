package com.mango.im.service;

import com.mango.im.dao.MessageDAO;
import com.mysql.cj.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author：Mango Cheng
 * Date：2020/5/26
 * Time：12:59
 * Description：维护服务
 */
public class MaintainService {

    /**
     * 删除-单个
     * @param id
     */
    public void deleteOne(String id) {
        if(StringUtils.isNullOrEmpty(id)){
           return;
        }
        MessageDAO messageDAO = new MessageDAO();
        messageDAO.deleteOne(Short.valueOf(id.trim()));
    }

    /**
     * 删除-批量
     * @param idArr
     */
    public void deleteBatch(String[] idArr) {
        if(idArr == null || idArr.length == 0){
            return;
        }
        // 1.处理参数
        List<Short> idList = new ArrayList(idArr.length);
        for(String id : idArr){
            idList.add(Short.valueOf(id));
        }
        // 2.数据操作
        MessageDAO messageDAO = new MessageDAO();
        messageDAO.deleteBatch(idList);
    }

}
