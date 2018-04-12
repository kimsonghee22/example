package cms.precode.unitpage.example

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ExampleController {

	Sql sql = new Sql();
	
	
	String select(@RequestParam Map params, Model model) {
		List list = sql.query("select * from board where userId= $params.userId")
		
		model.addAttribute("list", list)
		return "example/list"
	}
	
	
	String selectOneData(@RequestParam Map params, Model model) {
		Map map = sql.row("select * from board where userId= $params.userId")
		
		model.addAttribute("map", map)
		return "example/map"
	}
	
	void update(@RequestParam Map params) {
		sql.execute("update board set url= $params.url where id=$params.id")
	}

		
	void delete(@RequestParam Map params) {
		sql.execute("delete from file where fileName=$params.fileName")
	}
	
	void insert(@RequestParam Map params) {
		sql.execute("insert into board (title) values ($params.title)")
	}

	
}
