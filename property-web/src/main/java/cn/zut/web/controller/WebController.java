package cn.zut.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
@RequestMapping("web")
@RestController
public class WebController {

    /**
     * test home
     *
     * @return String
     */
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String login() {
        return "success amos!";
    }


}
