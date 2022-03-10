package root.pack.lms.service;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import root.pack.lms.model.MGangjwa;
import root.pack.lms.model.MHakgwa;
import root.pack.lms.model.MPersonalInfo;
import root.pack.lms.valueobject.VGangjwa;
import root.pack.lms.valueobject.VHakgwa;
import root.pack.lms.valueobject.VLoginInfo;
import root.pack.lms.valueobject.VPersonalInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SSincheong {
	
	@Resource private MGangjwa mGangjwa;
	
	@RequestMapping(value = "/sincheong", method = RequestMethod.GET)
	public String sincheongInit(HttpServletRequest req, @RequestParam String fileName, Model model) throws IOException {
		HttpSession session = req.getSession();
		VPersonalInfo login = (VPersonalInfo) session.getAttribute("login");
		
		List<VGangjwa> gangjwaList = mGangjwa.select(login.getId(), fileName);
		List<VGangjwa> sinchoengList = mGangjwa.select(null, fileName);
		
		for (VGangjwa gangjwa : gangjwaList) {
			
			for (VGangjwa sinchoeng : sinchoengList) {
				
				if (gangjwa.getId() == sinchoeng.getId()) {
					gangjwa.setSincheong(gangjwa.getSincheong() + 1);
				}
			}
		}
		
		model.addAttribute("gangjwaList", gangjwaList);
		return "PSincheong";
	}

	// 미리담기 신청
	@ResponseBody
	@RequestMapping(value = "/sugangsincheong/miridamgi", method = RequestMethod.GET)
	public String miridamgi(HttpServletRequest req ,@ModelAttribute VGangjwa vGangjwa, Model model) throws IOException {
		HttpSession session = req.getSession();
		VPersonalInfo login = (VPersonalInfo) session.getAttribute("login");
			
		List<VGangjwa> list = mGangjwa.select(login.getId(), "miridamgi");
			
		for (VGangjwa item : list) {
				
			if (item.getId() == vGangjwa.getId()) {
				return "no";
			}
		}
			
		mGangjwa.write(login.getId(), vGangjwa, "miridamgi");
		return "miridamgi";
			
	}
		
	// 수강 신청
	@ResponseBody
	@RequestMapping(value = "/sugangsincheong/sincheong", method = RequestMethod.GET)
	public String sincheong(HttpServletRequest req ,@ModelAttribute VGangjwa vGangjwa, Model model) throws IOException {
		HttpSession session = req.getSession();
		VPersonalInfo login = (VPersonalInfo) session.getAttribute("login");
			
		List<VGangjwa> list = mGangjwa.select(login.getId(), "sincheong");
			
		for (VGangjwa item : list) {
				
			if (item.getId() == vGangjwa.getId()) {
				return "no";
			}
		}
			
		mGangjwa.write(login.getId(), vGangjwa, "sincheong");
		return "sincheong";
	}
	
	@RequestMapping(value = "/sincheong/delete", method = RequestMethod.GET)
	public String sincheongDelete(HttpServletRequest req, @RequestParam int id, @RequestParam String fileName) throws IOException {
		HttpSession session = req.getSession();
		VPersonalInfo login = (VPersonalInfo) session.getAttribute("login");
		
		mGangjwa.delete(id, login.getId(), fileName);
		return "redirect:/sincheong?fileName=" + fileName;
	}
	
	
	
	
	
	
	
}
