package ru.ap.tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class TimeWorker extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date date = new Date();
        req.setAttribute("date", date.toString());
        req.getRequestDispatcher("time.jsp").forward(req, resp);
    }
}
/** web.xml управляет проектом по сути вместо Main. Показывает какие сервлеты у нас есть (например этот класс - это сервлет)
 Для чего нужен web.xml? Для маппинга. В нем мы распишем для Tomcat, какие url-запросы передавать на какие сервлеты.
 Например, на этот класс (сервлет) пойдут запросы /time в адресной строке нашего "сайта"

 index.jsp - это файл, который будет выполнен по умолчанию, типа главной страницы, как index.html
 но в web.xml можно это изменить, переопределить название файла по умолчанию (welcome-file-list),
 например time.jsp, только поправить url-pattern.
 */