package com.yourcompany;

import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double number1 = Double.parseDouble(req.getParameter("number1"));
        double number2 = Double.parseDouble(req.getParameter("number2"));
        String operation = req.getParameter("operation");
        double result = 0;

        switch (operation) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Divisão por zero não permitida.");
                    return;
                }
                break;
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Resultado: " + result + "</h1>");
        out.println("</body></html>");
    }
}
