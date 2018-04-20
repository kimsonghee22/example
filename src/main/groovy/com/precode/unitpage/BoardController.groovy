package com.precode.unitpage

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("Board/{url}")
class BoardController {
	
	@Autowired
	ExampleSql sql = new ExampleSql()

	
	@RequestMapping("list")
	String list(@RequestParam Map params, @PathVariable String url, Model model) {
		List list = sql.row("select * from board where id=$params.id and url=$url")
		model.addAttribute("list", list)
		return "board/list"
	}
	
	@RequestMapping("view")
	String view(@RequestParam Map params, @PathVariable String url, Model model){
		Map view = sql.row("select * from board where id=$params.id")	
		model.addAttribute("map", view)
		return "board/view"
	}
		

}
