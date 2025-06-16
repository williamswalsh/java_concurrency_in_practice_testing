package ie.williamswalsh.servlets;

import jakarta.servlet.*;
import net.jcip.annotations.ThreadSafe;

import java.io.IOException;

@ThreadSafe
public class StatelessFactorizer implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("number");
        int num = Integer.parseInt(param);
        int[] factors = factor(num);
        if(factors.length==0) {
            throw new RuntimeException("No factors found - number is prime or 1");
        }

    }

    public static int[] factor(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                int otherFactor = number / i;
                return new int[]{i, otherFactor};
            }
        }
        // No factors found (number is prime or 1)
        return new int[]{};
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
