package com.precode.unitpage

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
	public String onlineSubmit(Model model, @RequestParam Map params, HttpServletResponse response) {
		sql.execute("insert into nksc.online (name,type,tel,email,date,address,content) values ($params.name,$params.type,$params.tel,$params.email,$params.date,$params.address,$params.content)")
		print.alert(response, '등록되었습니다.')
		return"index"
	}
	
	@RequestMapping("/officeSubmit")
	public String officeSubmit(Model model, @RequestParam Map params,  HttpServletResponse response) {
		sql.execute("insert into nksc.office (name,tel,type,address) values ($params.name,$params.tel,$params.type,$params.address)")
		print.alert(response, '등록되었습니다.')
		return "index"
	}
	
	
	//List
	@RequestMapping("/onlineList")
	public String onlineView(Model model) {
		List onlineList = sql.query("select * from nksc.online")
		model.addAttribute("onlineList", onlineList)
		return "board/onlineList"
	}
	@RequestMapping("/officeList")
	public String officeView(Model model) {
		List officeList = sql.query("select * from nksc.office")
		model.addAttribute("officeList", officeList)
		return "board/officeList"
	}
	
	
}
