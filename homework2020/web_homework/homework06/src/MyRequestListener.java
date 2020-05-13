import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Maria
 * @program homework06
 * @date 2020/5/13 14:35
 */
public final class MyRequestListener implements ServletRequestListener {
    private int count = 0;
    public void requestInitialized(ServletRequestEvent re){
        HttpServletRequest request= (HttpServletRequest)re.getServletRequest();
        if(request.getRequestURI().equals("/helloapp/onlineCount.jsp")){
            count++;
            re.getServletContext().setAttribute("count",new Integer(count));
        }
    }

    public void requestDestroyed(ServletRequestEvent re){

    }

}
