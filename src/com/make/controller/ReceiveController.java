/**  
 * @Title: ReceiveController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-20
 */
package com.make.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: ReceiveController
 * 
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-20
 */
@Controller
@RequestMapping("receive")
public class ReceiveController {

	@RequestMapping("list.do")
	public String loadInfo() {

		return "receive/receive";
	}

}
