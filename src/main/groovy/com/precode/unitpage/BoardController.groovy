package com.precode.unitpage

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("Board")
class BoardController {
	
	@Autowired
	ExampleSql sql = new ExampleSql()

	
	@RequestMapping("/")
	String select(@RequestParam Map params, Model model) {
		Map map = sql.row("select * from nksc.board where id=$params.id")
		model.addAttribute("map", map)
		return "board/map"
	}
	
	@RequestMapping("/update")
	String update(@RequestParam Map params, Model model) {
		Map update = sql.row("select * from nksc.board where id=$params.id")
		model.addAttribute("update", update)
		return "board/update"
	}
		

}
