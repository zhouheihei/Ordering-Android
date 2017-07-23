package com.ogogc.app.bean;

import java.util.List;

public class Response<T> {
	private int event;
	private String msg;
	private T obj;
	private List<T> objlist;
	private int currentPage;
	private int pageSize;
	private int maxPage;
	private int maxcont;
	
	public int getEvent() {
		return event;
	}
	public void setEvent(int event) {
		this.event = event;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	public List<T> getObjlist() {
		return objlist;
	}
	public void setObjlist(List<T> objlist) {
		this.objlist = objlist;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxcont() {
		return maxcont;
	}
	public void setMaxcont(int maxcont) {
		this.maxcont = maxcont;
	}
}
