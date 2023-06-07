package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.service.BookService;
import spring.service.CheckOutService;
import spring.service.TransferService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CheckOutService checkOutService;


    public void buyBook(Integer userId,Integer bookId){
        bookService.buyBook(userId,bookId);
    }

    public void checkout(Integer userId,Integer[] bookIds){
        checkOutService.checkout(userId,bookIds);
    }


}


