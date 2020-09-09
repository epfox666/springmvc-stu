package com.epfox.dao;

import com.epfox.pojo.Books;

import java.util.List;

public interface BookMapper {

    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(int bookID);
    //更新一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBookById(int bookID);
    //查询全部的书
    List<Books> queryAllBook();
    //根据id查询，返回一本书
    Books queryBookByName(String bookName);

}
