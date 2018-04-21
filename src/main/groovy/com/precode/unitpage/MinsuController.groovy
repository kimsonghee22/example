package com.precode.unitpage

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller //back
class MinsuController {

	@Autowired //������ ����
	ExampleSql sql = new ExampleSql();
	
	
	@RequestMapping("minsu")//URL ����
	public String minsu(Model model) { //STRING URL �����Ϸ���
		List boardList = sql.query("select * from board") //���̸� �б����� �����κ�
		//Map boardMap = sql.query("select * from board") 
		
		model.addAttribute("boardList", boardList)//�����͸� board��� �����ش�.
		//model.addAttribute("boardMap", boardMap)
		return "minsu/index"	//ȭ������ִ°�
	}
	
	
	
}
