package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import spring.service.TransferService;

@Controller
public class AccountController {

    @Autowired
    private TransferService transferService;

    public void transfer(Integer userId1,Integer userId2,Integer money){transferService.transfer(userId1,
            userId2,
            money);}
}
