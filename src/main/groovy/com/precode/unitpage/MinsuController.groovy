package com.precode.unitpage

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller //back
class MinsuController {

	@Autowired //생성자 연결
	ExampleSql sql = new ExampleSql();
	
	
	@RequestMapping("minsu")//URL 연결
	public String minsu(Model model) { //STRING URL 연결하려면
		List boardList = sql.query("select * from board") //데이를 읽기위한 쿼리부분
		//Map boardMap = sql.query("select * from board") 
		
		model.addAttribute("boardList", boardList)//데이터를 board라는 보내준다.
		//model.addAttribute("boardMap", boardMap)
		return "minsu/index"	//화면잡아주는것
	}
	
	
	
}
