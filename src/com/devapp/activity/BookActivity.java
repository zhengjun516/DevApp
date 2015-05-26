package com.devapp.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.devapp.R;
import com.devapp.activity.base.BaseActivity;
import com.devapp.domain.Book;
import com.devapp.http.ErrorInfo;
import com.devapp.http.ResponseHandler;
import com.devapp.service.IBookService;
import com.devapp.utils.ServiceFactory;


public class BookActivity extends BaseActivity {
	private TextView mTitleText;
	
	private IBookService bookService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reading);
		mTitleText.setText("读书");
		
		//bookService = (IBookService) ServiceFactory.getService(ServiceFactory.BOOK_SERVICE, this);
		bookService = ServiceFactory.getBookService(this);
		
		getBookInfoById("1001");
	}
	
	private void getBookInfoById(String bookId){
       bookService.getBookInfoById(bookId,new ResponseHandler<Book, Exception>() {
			
			@Override
			public void onSuccess(int status, Book t, ErrorInfo errorInfo) {
				
			}
			
			@Override
			public void onError(Exception e) {
				
			}
		});
	}
}
