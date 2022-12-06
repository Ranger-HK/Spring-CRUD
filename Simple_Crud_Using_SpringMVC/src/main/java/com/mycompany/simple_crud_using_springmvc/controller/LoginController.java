package com.mycompany.simple_crud_using_springmvc.controller;

import com.mycompany.simple_crud_using_springmvc.dto.UserDTO;
import com.mycompany.simple_crud_using_springmvc.service.LoginService;
import com.mycompany.simple_crud_using_springmvc.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(params = {"userName", "password"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil userLogin(@RequestParam String userName, String password) {

        for (UserDTO dto : loginService.fetchAllUser()) {
            if (dto.getUserName().equalsIgnoreCase(userName) & dto.getPassword().equalsIgnoreCase(password)) {
                return new ResponseUtil(200, "Ok", null);
            }
        }

        return new ResponseUtil(400, "error", null);
    }
}
