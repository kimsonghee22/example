package com.precode.unitpage

import javax.servlet.http.HttpServletResponse

import org.springframework.stereotype.Component

@Component
class Alert {

	public void alert(HttpServletResponse response,content) {
		response.setContentType("text/html; charset=UTF-8")
		PrintWriter out = response.getWriter()
		out.println ("<script> alert ('$content')</script>")
		out.flush()
	}
}
