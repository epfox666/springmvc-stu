package com.epfox.controller;

import com.epfox.pojo.Books;
import com.epfox.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部书籍 返回一个页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }
    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
    //跳转到增加书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBooks",books);
        return "updateBook";
    }
    //跳转到增加书籍页面
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
//    //删除书籍
//    @RequestMapping("/deleteBook")
//    public String deleteBook(int id){
//        System.out.println("deleteBookId=>"+id);
//        bookService.deleteBookById(id);
//        return "redirect:/book/allBook";
//    }
    //删除书籍restful
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        System.out.println("deleteBookId=>"+id);
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }


}
