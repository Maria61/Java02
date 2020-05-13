import javax.servlet.*;
import java.util.Date;

/**
 * @author Maria
 * @program homework06
 * @date 2020/5/13 14:28
 */
public final class MyServletContextListener implements ServletContextListener, ServletContextAttributeListener {
    private ServletContext context = null;

    public void contextInitialized(ServletContextEvent sce){
        context = sce.getServletContext();
        context.log("应用程序已启动："+new Date());
    }

    public void contextDestroyed(ServletContextEvent sce){
        context = sce.getServletContext();
        context.log("应用程序已关闭："+new Date());
    }

    public void attributeAdded(ServletContextAttributeEvent sce){
        context = sce.getServletContext();
        context.log("添加一个属性："+sce.getName()+"："+sce.getValue());
    }

    public void attributeRemoved(ServletContextAttributeEvent sce){
        context = sce.getServletContext();
        context.log("删除一个属性："+sce.getName()+"："+sce.getValue());
    }

    public void attributeReplaced(ServletContextAttributeEvent sce){
        context = sce.getServletContext();
        context.log("替换一个属性："+sce.getName()+"："+sce.getValue());
    }
}
