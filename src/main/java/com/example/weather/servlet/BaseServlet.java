package com.example.weather.servlet;

import com.example.weather.servlet.listener.ThymeleafListener;
import com.example.weather.servlet.listener.WebContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {
    protected TemplateEngine templateEngine;
    protected WebContext webContext;

    @Override
    public void init(){
        templateEngine = (TemplateEngine) getServletContext().getAttribute(ThymeleafListener.TEMPLATE_ENGINE_ATTR);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        webContext = WebContextUtil.buildWebContext(req, resp, getServletContext());
        super.service(req, resp);
    }
}
