## 微聊天

> 慕课网课程《通过自动回复机器人学Mybatis-基础版》
>
> feature-1 分支对应 2-6及之前章节代码
>
> feature-2 分支对应 2-7 重构后的代码 + 2-6
>
> feature-3 分支对应 4-5及之前章节代码 
>
>持续更新中...


### 1.开发环境
+ jdk版本 1.8
+ MySql版本 8
+ mybatis 3.5


### 2.注意点
+ jdbc驱动版本与本地MySql版本对应
+ 驱动包放置tomcat安装目录lib文件夹下
+ 改版本配置日志，只需在Configuration配置文件开启
```xml
<settings>
  <setting name="logImpl" value="STDOUT_LOGGING" />
</settings>
```

### 3.技术点

#### 1）jstl
+ 使用
    1. 引入依赖
    ```jsp
    <!-- JSTL 核心标签库 -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    ```
    2. 放入依赖包：jstl.jar、standard.jar       
        