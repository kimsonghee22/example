package com.precode.unitpage

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired
=======
>>>>>>> 796f582c17cfaacb2cc228c3e7391da44db2dea1
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class IndexController {

<<<<<<< HEAD
	@Autowired
	ExampleSql sql = new ExampleSql();
	
	@RequestMapping("/")
	public String index() {
		List board = sql.query("select * from board")
			
		println board
		return "index"
	}
	
	@RequestMapping("/header")
	public String header() {
		return "header"	
	}
	
	@RequestMapping("/footer")
	public String footer() {
		return "footer"
	}
=======
	@RequestMapping("/index")
	public String index() {
		return "index"
	}
>>>>>>> 796f582c17cfaacb2cc228c3e7391da44db2dea1
}
