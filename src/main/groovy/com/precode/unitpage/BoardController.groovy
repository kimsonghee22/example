package com.precode.unitpage

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("board/{siteName}")
class BoardController {
	
	@Autowired
	ExampleSql sql = new ExampleSql()
	Alert print = new Alert()

	
	@RequestMapping("/")
	String view(@RequestParam Map params, Model model, @PathVariable String siteName) {
		Map view = sql.row("select * from nksc.board where siteName=$siteName")
		
		model.addAttribute("view", view)
		
		
		if(view.form=='list') {
			List list = sql.query("select * from nksc."+view.siteName)
			model.addAttribute("list", list)
		}
		
		return "/view/board/${view.form}"
	}

}
