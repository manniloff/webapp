import javax.resource.spi.work.ExecutionContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import java.io.IOException;

public class HttpAsyncListener implements AsyncListener {
    HttpAsyncListener() {
        System.out.println("HttpAsyncListener");
    }

    @Override
    public void onComplete(AsyncEvent asyncEvent) {
        System.out.println("onComplete+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        try {
            asyncEvent.getSuppliedResponse().getWriter().println("op timeout suka");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        System.out.println("onTimeout++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @Override
    public void onError(AsyncEvent asyncEvent) {
        System.out.println("onError");
    }

    @Override
    public void onStartAsync(AsyncEvent asyncEvent) {
        System.out.println("onStartAsync");
    }
}
