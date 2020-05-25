package com.mango.im.bean;

/**
 * Author：Mango Cheng
 * Date：2020/5/25
 * Time：13:37
 * Description：消息POJO
 */
public class TMessage {

    private short id ;
    private String command;
    private String description;
    private String content;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
