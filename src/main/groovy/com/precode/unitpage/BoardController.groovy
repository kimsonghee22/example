package com.precode.unitpage

import java.util.Map

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

import org.hibernate.annotations.Columns
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

import groovy.beans.ListenerList

@Controller
@RequestMapping("board/{siteName}")
class BoardController {

	@Autowired
	ExampleSql sql = new ExampleSql()
	Alert Aprint = new Alert()


	@RequestMapping("")
	String view(@RequestParam Map params, Model model, @PathVariable String siteName) {
		model.addAttribute("siteName", siteName)
		List list;

		if(siteName.equals("maintain_record")) {
			list = [[title:"시설", siteName:"maintain_record_pro"], [title:"청소",siteName:"maintain_record_clean"], [title:"경비", siteName:"maintain_record_guard"]]
			model.addAttribute("list", list)
			return "view/board/recordList"
		}else if(siteName.equals("clean_record")) {
			list = [[title:"학교", siteName:"clean_record_school"], [title:"아파트",siteName:"clean_record_apt"]]
			model.addAttribute("list", list)
			return "view/board/recordList"
		}

		Map view = sql.row("select * from nksc.board where siteName=$siteName")

		if(params.listId) {
			view = sql.row("select * from nksc."+siteName+" where id=$params.listId")
			view.put("siteName", siteName)
			model.addAttribute("view", view)
			return "view/board/view"
		}

		int hrefRecord = 0;

		if(view.form=='list') {
			if(params.record) {
				if((params.beSiteName).equals("clean_record")) {
					hrefRecord=2
				}else if((params.beSiteName).equals("maintain_record")) {
					hrefRecord=1
				}
			}
			model.addAttribute("hrefRecord", hrefRecord)
			list = sql.query("select * from nksc."+view.siteName)
			model.addAttribute("list", list)
		}

		model.addAttribute("view", view)
		return "/view/board/${view.form}"
	}



	@RequestMapping("adminList")
	String adminListView(@RequestParam Map params, HttpServletRequest request, @PathVariable String siteName, Model model, HttpSession session, HttpServletResponse response) {
		List list;
		int adminList=9;

		if(!session.getAttribute("admin")) {
			Aprint.alert(response, "관리자 로그인이 필요합니다.")
			return "view/login/login"
		}

		if(siteName.equals("online")) {
			list = sql.query("select * from nksc.online")
			adminList = 0;
		}else if(siteName.equals("office")) {
			list = sql.query("select * from nksc.office")
			adminList = 1;
		}
		model.addAttribute("list", list)
		model.addAttribute("adminList", adminList)

		return "view/board/adminList"
	}


	@RequestMapping("write")
	String write(@RequestParam Map params, HttpServletRequest request, @PathVariable String siteName, Model model, HttpSession session, HttpServletResponse response) {

		if(!session.getAttribute("admin")) {
			Aprint.alert(response, "관리자 로그인이 필요합니다.")
			return "view/login/login"
		}

		return "view/board/write"
	}
	
	
	@RequestMapping("writeOk")
	String writeOk(@RequestParam Map params,@PathVariable String siteName, HttpServletRequest request, Model model, HttpSession session, HttpServletResponse response) {

		if(!session.getAttribute("admin")) {
			Aprint.alert(response, "관리자 로그인이 필요합니다.")
			return "view/login/login"
		}

		if(siteName.equals("notice")) {
			sql.execute("insert into nksc.notice (name, content) values ($params.name, $params.content)")	
		}else if((params.beSiteName).equals("clean_record")) {
			sql.execute("insert into nksc."+siteName+" (name, content, way, note) values ($params.name, $params.content, $params.way, $params.note)")
		}else if((params.beSiteName).equals("maintain_record")) {
			sql.execute("insert into nksc."+siteName+" (name, content, place) values ($params.name, $params.content, $params.place)")
		}

		return "view/index"
	}

}