package com.mvc.step1;

public class ActionForward {
	private String path = null;
	// true = sendRedirect로 처리한다, false = forward로 처리한다 / 주소가 바뀐다 안바뀐다. 응답이 끊긴다 유지된다.
	private boolean isRedirect = false;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
