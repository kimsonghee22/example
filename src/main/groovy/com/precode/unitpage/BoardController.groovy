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

	
	@RequestMapping("{url}")
	String map(@RequestParam Map params, @PathVariable String url, Model model) {
		Map map = sql.row("select * from nksc.board where id=$params.id")
		model.addAttribute("map", map)
		return "board/map"
	}
		

}
