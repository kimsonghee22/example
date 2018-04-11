package com.precode.unitpage

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class IndexController {

	@RequestMapping("/index1")
	public String index() {
		return "index"
	}
}
