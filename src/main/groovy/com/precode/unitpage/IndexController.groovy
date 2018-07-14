package com.precode.unitpage


import java.util.Map

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
class IndexController {

	@Autowired
	ExampleSql sql = new ExampleSql();
	Alert Aprint = new Alert()
	
	@RequestMapping("/")
	public String index(Model model) {
		List board = sql.query("select * from nksc.board")

		model.addAttribute("board", board)
		return "view/index"
	}
	

}
