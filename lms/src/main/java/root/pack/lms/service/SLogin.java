package root.pack.lms.service;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

import root.pack.lms.model.MPersonalInfo;
import root.pack.lms.valueobject.VLoginInfo;
import root.pack.lms.valueobject.VPersonalInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SLogin {
	
	@Resource
	private MPersonalInfo mPersonalInfo;
	
	// 로그인 띄우기
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String loginInit(VLoginInfo vLoginInfo, Model model) {
				
			model.addAttribute("VLoginInfo", vLoginInfo);
			return "PLogin";
		}
		
	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute VLoginInfo vLoginInfo, HttpServletRequest req, Model model) throws IOException {
		
		List<VPersonalInfo> list = mPersonalInfo.read();
		
		for (VPersonalInfo vPersonalInfo : list) {
			
			if (vLoginInfo.getUserId().equals(vPersonalInfo.getUserId()) &&
					vLoginInfo.getPassword().equals(vPersonalInfo.getPassword())) {
				
				model.addAttribute("alertMsg","로그인 성공");
			    model.addAttribute("redirectUrl","/sugangsincheong"); 
			    
			    HttpSession session = req.getSession();
			    session.setAttribute("login", vPersonalInfo);
			    return "alert";
			
			} 
		}
		
		model.addAttribute("alertMsg","일치하는 정보가 없습니다. 확인후 다시 입력해주세요.");	
		return "alert";
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("login", null);
				
		return "redirect:/login";
	}
	
	
	
}
