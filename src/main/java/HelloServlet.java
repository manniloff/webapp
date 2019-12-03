import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
//    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
//
//
//
//        System.out.println("enter in servlet hello world");
//        try {
//            String sleep = httpServletRequest.getParameter("sleep");
//            Thread.sleep(Integer.parseInt(sleep));
//            httpServletResponse.getWriter().println("Hello world"+ sleep);
//
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//
//        try (PrintWriter writer = resp.getWriter()) {
//            writer.println("<body>");
//            writer.println("<p>");
//            writer.println("curl -X POST -H \"Content-Type: application/json\" -d @/home/okulikov/work/unifun/unifun-sigtran-modules/development/UssdGate/pussr2.json http://127.0.0.1:7080/UssdGate/mapapi");
//            writer.println("</p>");
//            writer.println("</body>");
//        }
//    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

//        final AsyncContext context = req.startAsync();
//        context.addListener(new HttpAsyncListener());
//        context.setTimeout(3000);


        final String sleep = req.getParameter("sleep");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("doGet " + sleep);
                try {
                    Thread.sleep(Integer.parseInt(sleep));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("doGet2 " + sleep);

 //               context.complete();
                try {
                    resp.getWriter().println(sleep);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


//        ExecutorService EXECUTOR = Executors.newCachedThreadPool();
////
////        EXECUTOR.execute(() -> {
////            try {
////                resp.getWriter().println("ass");
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//        });
    }
}
