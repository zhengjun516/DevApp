package com.devapp.service;

import java.util.List;

import com.devapp.domain.Book;
import com.devapp.http.ResponseHandler;

public interface IBookService{
	
	/**
	 * https://api.douban.com/v2/book/:id
	 */
	public void getBookInfoById(String bookId,final ResponseHandler<Book, Exception> responseHandler);
	
	/**
	 * https://api.douban.com/v2/book/isbn/
	 * @param isbn
	 */
	public void getBookInfoByISBN(String isbn,final ResponseHandler<Book, Exception> responseHandler);
	
	/**
	 * https://api.douban.com/v2/book/search
	 * @param keywords
	 */
	public void serchBook(String keywords,String tag,final ResponseHandler<List<Book>, Exception> responseHandler);
	
	/**
	 * 推荐图书
	 */
	public void recommendBook();
}
