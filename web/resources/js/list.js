/**
 * Author：Mango Cheng
 * Date：2020/5/26
 * Time：16:28
 * Description：列表js
 */

/**
 * 批量删除
 */
function deleteBatch(basePath) {

    $("#mainForm").attr("action",basePath + "/DeleteBatchServlet.action");
    $("#mainForm").submit();
}
