package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CheckFilter init!");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String data = req.getParameter("data");

        int num = Integer.parseInt(data);
        if (num != 5) {
            resp.getWriter().println("Error");
        } else {
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
        System.out.println("CheckFilter init!");
    }
}
