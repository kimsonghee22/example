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
		return "login"
	}
	
		@RequestMapping("loginOk")
	public String loginOk(HttpSession session, @RequestParam Map param, HttpServletResponse response) {
		if(param.pwd=='123') {
			session.setAttribute("admin", "admin")
			print.alert(response, '관리자 로그인')
		}else {
			print.alert(response, '비밀번호 확인')
		}
		
		
		return "login"
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session, HttpServletResponse response,  HttpServletRequest request, Model model) {
		session.invalidate();
		print.alert(response, '관리자 로그아웃')
		
	/*	String referer = request.getHeader("Referer")
		return "redirect:" + referer
	*/
		List board = sql.query("select * from nksc.board")
		List siteMap = sql.query("select * from nksc.siteMap")
		
		model.addAttribute("siteMap", siteMap)
		model.addAttribute("board", board)
		return "index"
			
	}
	
}
