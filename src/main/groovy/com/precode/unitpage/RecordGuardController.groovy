package com.precode.unitpage

import javax.servlet.http.HttpServletResponse

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("recordGuard")
class RecordGuardController {
	
	@Autowired
	ExampleSql sql = new ExampleSql()
	Alert alert = new Alert()
	
	@RequestMapping("/")
	String select(@RequestParam Map params, Model model) {
		Map map = sql.row("select * from nksc.recordGuard where id=$params.id")
		model.addAttribute("map", map)
		return "board/map"
	}
	
	@RequestMapping("/update")
	String update(@RequestParam Map params, Model model) {
		Map update = sql.row("select * from nksc.recordGuard where id=$params.id")
		model.addAttribute("update", update)
		return "board/update"
	}
	
	@RequestMapping("/updateOk")
	String updateOk(@RequestParam Map params, Model model, HttpServletResponse response) {
		sql.execute("update nksc.board set title=$params.title, content=$params.content where id=$params.id")
		alert.alert(response, '변경되었습니다.')
		Map map = sql.row("select * from nksc.recordGuard where id=$params.id")
		model.addAttribute("map", map)
		return "board/map"
	}
	
	@RequestMapping("/delete")
	String delete(@RequestParam Map params, Model model) {
		sql.execute("delete from nksc.recordGuard where id=$params.id")
		List board = sql.query("select * from nksc.board")
		model.addAttribute("board", board)
		return "index"	
	}
	
	@RequestMapping("/insert")
	String insert(@RequestParam Map params, Model model) {
		return "board/insert"
	}
	
	@RequestMapping("/insertOk")
	String insertOk(@RequestParam Map params, Model model) {
		sql.execute("insert into nksc.recordGuard (title, content) values ($params.title, $params.content)")
		List board = sql.query("select * from nksc.recordGuard")
		model.addAttribute("board", board)
		return "index"
	}

}
