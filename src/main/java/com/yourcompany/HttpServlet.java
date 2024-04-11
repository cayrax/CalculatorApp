package com.yourcompany;

import java.io.IOException;

public abstract class HttpServlet {
    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
