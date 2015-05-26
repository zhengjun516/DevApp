package com.devapp.service.impl;

import java.util.List;

import org.json.JSONObject;

import android.content.Context;
import android.net.Uri;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.devapp.domain.Book;
import com.devapp.http.ErrorInfo;
import com.devapp.http.ResponseHandler;
import com.devapp.service.IBookService;



public class BookServiceImpl extends BaseServiceImpl implements IBookService{
	
	public BookServiceImpl(Context context) {
		super(context);
	}

	/**
	 * https://api.douban.com/v2/book/:id
	 */
	public void getBookInfoById(String bookId,final ResponseHandler<Book, Exception> responseHandler){
	       String url = "https://api.douban.com/v2/book/"+bookId;
			Uri.Builder builder = Uri.parse(url).buildUpon();
			System.out.println("reuqest url:"+builder.toString());
			request(Request.Method.GET,builder.toString(),null,new Response.Listener<JSONObject>() {
				@Override
				public void onResponse(JSONObject response) {
					//正确逻辑
					Book book = new Book();
					responseHandler.onSuccess(ResponseHandler.SUCCESS, book, null);
					
					//错误逻辑
					ErrorInfo errorInfo = new ErrorInfo();
					responseHandler.onSuccess(errorInfo.code, null, errorInfo);
				}
			},new Response.ErrorListener() {

				@Override
				public void onErrorResponse(VolleyError error) {
					responseHandler.onError(error);
				}
			});
	}
	
	/**
	 * https://api.douban.com/v2/book/isbn/
	 * @param isbn
	 */
	public void getBookInfoByISBN(String isbn,final ResponseHandler<Book, Exception> responseHandler){
		 
	}
	
	/**
	 * https://api.douban.com/v2/book/search
	 * @param keywords
	 */
	public void serchBook(String keywords,String tag,final ResponseHandler<List<Book>, Exception> responseHandler ){
		   
	}
	
	/**
	 * 推荐图书
	 */
	public void recommendBook(){
		
	}
}
