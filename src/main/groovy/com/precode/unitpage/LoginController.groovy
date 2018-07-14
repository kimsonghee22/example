package com.precode.unitpage

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class LoginController {

	@Autowired
	Alert print = new Alert()
	ExampleSql sql = new ExampleSql();

	@RequestMapping("login")
	public String login() {
		return "view/login/login"
	}

	@RequestMapping("loginOk")
	public String loginOk(HttpSession session,HttpServletRequest request, @RequestParam Map params, HttpServletResponse response) {


		if((params.adminId).equals("kimji")&&(params.pwd)=="70037003") {
			session.setAttribute("admin", "admin")
			print.alert(response, '관리자 로그인 완료')
		}else {
			print.alert(response, '잘못 입력하셨습니다.')
			String referer = request.getHeader("Referer");
		}
		return "view/index"
	}




	@RequestMapping("logout")
	public String logout(HttpSession session, HttpServletResponse response,  HttpServletRequest request, Model model) {
		session.invalidate();

		return "view/index"
	}
}
