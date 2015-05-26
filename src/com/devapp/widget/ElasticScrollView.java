package com.devapp.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;
import android.widget.Scroller;

import com.devapp.R;


/**
 * ScrollView反弹效果的实现
 * 
 */
public class ElasticScrollView extends ScrollView {
	private static final float DAMP_COEFFICIENT = 2;
	private static final int ELASTIC_DELAY = 200;
	private float damk = DAMP_COEFFICIENT;
	private int delay = ELASTIC_DELAY;
	private View inner;

	private float y;
	
	 /** 是否移动到顶部位置. */
    private boolean isTop = false;

	private Rect normal = new Rect();
	private View elasticView;
	private int height;
	
	private int imageHeight;
	
	private Scroller mScroller;
	
	private enum State {
	        /**顶部*/
	        UP,
	        /**底部*/
	        DOWN,
	        /**正常*/
	        NORMAL
	}
	
	/** 状态. */
    private State mState = State.NORMAL;

	public ElasticScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		imageHeight = BitmapFactory.decodeResource(getResources(), R.drawable.scrollview_header).getHeight()+80;
	}

	@Override
	protected void onFinishInflate() {
		if (getChildCount() > 0) {
			inner = getChildAt(0);
		}
		mScroller = new Scroller(getContext());
	}

	public void setElasticView(View view){
		if(elasticView != null){
			android.view.ViewGroup.LayoutParams layoutParams = elasticView.getLayoutParams();
			layoutParams.height = height;
			elasticView.setLayoutParams(layoutParams);
		}
		if(null != view){
			height = view.getLayoutParams().height;
		}
		elasticView = view;
	}
	public View getElasticView(){
		return elasticView;
	}
	
	public float getDamk() {
		return damk;
	}

	public void setDamk(float damk) {
		this.damk = damk;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (inner == null) {
			return super.onTouchEvent(ev);
		} else {
			commOnTouchEvent(ev);
		}
		return super.onTouchEvent(ev);
	}

	@Override
	public void computeScroll() {
		super.computeScroll();
		if (mScroller.computeScrollOffset()) {
			android.view.ViewGroup.LayoutParams layoutParams = elasticView.getLayoutParams();
			layoutParams.height = mScroller.getCurrY();
			elasticView.setLayoutParams(layoutParams);
			invalidate();
		}
	}
	
	 @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (getScrollY() == 0) {
            isTop = true;
        }
    }

	
	public void commOnTouchEvent(MotionEvent ev) {
		
		
		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			y = ev.getY();
//			if(elasticView == null && inner instanceof ViewGroup && ((ViewGroup)inner).getChildCount()>0){
//				elasticView = ((ViewGroup)inner).getChildAt(0);
//				height = elasticView.getLayoutParams().height;
//			}
			break;
		case MotionEvent.ACTION_UP:

			if (isNeedAnimation()) {
				if(null != elasticView){
					android.view.ViewGroup.LayoutParams layoutParams = elasticView.getLayoutParams();
//					layoutParams.height = height;
//					elasticView.setLayoutParams(layoutParams);
					mScroller.startScroll(0, layoutParams.height, 0, height - layoutParams.height, delay);
					invalidate();
					
				}else{
					animation();
				}
			}
			break;
		case MotionEvent.ACTION_MOVE:
		
			final float preY = y;
			float nowY = ev.getY();
			float distance = preY-nowY;
			int deltaY = Math.round(distance/ damk) ;

			//y = nowY;
			// 当滚动到最上或者最下时就不会再滚动，这时移动布局
			if (isNeedMove()) {
				if (normal.isEmpty()) {
					// 保存正常的布局位置
					normal.set(inner.getLeft(), inner.getTop(),	inner.getRight(), inner.getBottom());
				}
				// 移动布局
				//if(Math.abs(distance) <= this.getHeight()){
				   if(elasticView != null){
					
					   android.view.ViewGroup.LayoutParams layoutParams = elasticView.getLayoutParams();
					   
						if((layoutParams.height-deltaY) < imageHeight){
						   layoutParams.height -= deltaY;
						   elasticView.setLayoutParams(layoutParams);
						}
						
					
				   }else{
					    inner.layout(inner.getLeft(), inner.getTop() - deltaY, inner.getRight(), inner.getBottom() - deltaY);
				   }
				//}
			}
			break;
		default:
			break;
		}
	}

	// 开启动画移动

	public void animation() {
		// 开启移动动画
		TranslateAnimation ta = new TranslateAnimation(0, 0, inner.getTop(), normal.top);
		ta.setDuration(500);
		inner.startAnimation(ta);
		// 设置回到正常的布局位置
		inner.layout(normal.left, normal.top, normal.right, normal.bottom);

		normal.setEmpty();

	}

	// 是否需要开启动画
	public boolean isNeedAnimation() {
		return !normal.isEmpty();
	}

	// 是否需要移动布局
	public boolean isNeedMove() {

		int offset = inner.getMeasuredHeight() - getHeight();
		int scrollY = getScrollY();
		if (scrollY == 0) {
			return true;
		}
		return false;
	}	

}
