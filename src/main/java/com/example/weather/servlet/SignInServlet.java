package com.example.weather.servlet;

import java.io.*;

import com.example.weather.commons.util.ValidationUtil;
import com.example.weather.dto.UserRequestDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/sign-in")
public class SignInServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        templateEngine.process("sign-in", webContext, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserRequestDto userDto = new UserRequestDto(login, password);

        ValidationUtil.validate(userDto);

        //toDo   добавить сессию и куки
    }
}