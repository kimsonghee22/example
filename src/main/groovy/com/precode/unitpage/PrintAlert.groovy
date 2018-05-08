package com.precode.unitpage

import javax.servlet.http.HttpServletResponse

class PrintAlert {
	
	void alert(HttpServletResponse response, contents) {
		response.setContentType("text/html; charset=UTF-8")
		PrintWriter out = response.getWriter()
		out.println ("<script> alert ('$contents')</script>")
		out.flush()
	}
	
}
