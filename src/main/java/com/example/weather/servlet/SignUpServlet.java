package com.example.weather.servlet;

import com.example.weather.commons.util.ValidationUtil;
import com.example.weather.dto.UserRequestDto;
import com.example.weather.entity.User;
import com.example.weather.service.AuthenticationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
@WebServlet("/sign-up")
public class SignUpServlet extends BaseServlet {
private final AuthenticationService authenticationService = new AuthenticationService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       templateEngine.process("sign-up", webContext, resp.getWriter());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserRequestDto userDto = new UserRequestDto(login, password);

        ValidationUtil.validate(userDto);
        User user = authenticationService.add(userDto);

//toDo   добавить сессию и куки

    }
}


















