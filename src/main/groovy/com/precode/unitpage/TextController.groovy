package com.precode.unitpage

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("text")
class TextController {

	@Autowired
	ExampleSql sql = new ExampleSql()
	Alert print = new Alert()

	//submit
	@RequestMapping("/onlineSubmit")
	public String onlineSubmit(Model model, @RequestParam Map params, HttpServletResponse response, HttpServletRequest request) {
		sql.execute("insert into nksc.online (name,type,tel,email,date,address,content) values ($params.name,$params.type,$params.tel,$params.email,$params.date,$params.address,$params.content)")
		return "redirect:/"
	}

	@RequestMapping("/officeSubmit")
	public String officeSubmit(Model model, @RequestParam Map params,  HttpServletResponse response) {
		sql.execute("insert into nksc.office (name,tel,type,address) values ($params.name,$params.tel,$params.type,$params.address)")
		return "redirect:/"
	}



}
