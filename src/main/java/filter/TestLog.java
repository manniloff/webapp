package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

public class TestLog implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TestLog init!");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;

        String servletPath = request.getServletPath();

        System.out.println("#INFO " + new Date() + " - ServletPath :" + servletPath //
                + ", URL =" + request.getRequestURL());

        // Разрешить request продвигаться дальше. (Перейти данный Filter).
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("TestLog destroy!");
    }
}
