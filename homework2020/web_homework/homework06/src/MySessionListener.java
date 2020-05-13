import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author Maria
 * @program homework06
 * @date 2020/5/13 14:30
 */
public final class MySessionListener implements HttpSessionListener {
    private int count = 0;
    public void sessionCreated(HttpSessionEvent se){
        count++;
        se.getSession().getServletContext().setAttribute(
                "onlineCount",new Integer(count));
    }

    public void sessionDestroyed(HttpSessionEvent se){
        count--;
        se.getSession().getServletContext().setAttribute(
                "onlineCount",new Integer(count));
    }
}
