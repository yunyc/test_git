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
public class SPersonalInfo {
		
	@Resource
	private MPersonalInfo mPersonalInfo;
	
	// 아이디 비밀번호 찾기
		@RequestMapping(value = "/find", method = RequestMethod.GET)
		public String recoveryInit(VLoginInfo vLoginInfo, Model model) {
				
			model.addAttribute("VLoginInfo", vLoginInfo);
			return "PRecovery";
		}
		
		// 개인 정보 입력
		@RequestMapping(value = "/personal_info", method = RequestMethod.GET)
		public String personalInfoInit(HttpServletRequest req, Model model) {
			HttpSession session = req.getSession();
			VPersonalInfo vPersonalInfo = (VPersonalInfo) session.getAttribute("login");
				
			model.addAttribute("vPersonalInfo", vPersonalInfo);
			return "PPersonalInfo";
		}
			
		// 개인 정보 입력
		@RequestMapping(value = "/personal_update", method = RequestMethod.GET)
		public String personalUpdateInit(HttpServletRequest req, Model model) {
			HttpSession session = req.getSession();
			VPersonalInfo vPersonalInfo = (VPersonalInfo) session.getAttribute("login");
					
			model.addAttribute("vPersonalInfo", vPersonalInfo);
			return "PPersonalUpdate";
		}
	
	// 개인 정보 추가
	@RequestMapping(value = "/personal_info", method = RequestMethod.POST)
	public String personalInfo(@ModelAttribute VPersonalInfo vPersonalInfo, HttpServletRequest req, Model model) throws IOException {
		
		List<VPersonalInfo> list = mPersonalInfo.read();
		
		// 아이디 중복 확인
		for (VPersonalInfo item : list) {
			
			if (item.getUserId().equals(vPersonalInfo.getUserId())) {
				model.addAttribute("alertMsg","이미 중복된 아이디가 있습니다.");
				return "alert";
			} 
		}
		
		// 유효성 검사
		if (vPersonalInfo.getUserId().length() < 5) {
			model.addAttribute("alertMsg","아이디를 5자리 이상 입력해주세요.");
			return "alert";
		
		} else if (vPersonalInfo.getPassword().length() < 8) {
			model.addAttribute("alertMsg","비밀번호를 8자리 이상 입력해주세요.");
			return "alert";
		
		} else if (!vPersonalInfo.getPassword().equals(vPersonalInfo.getConfirm())) {
			model.addAttribute("alertMsg","비밀번호 확인과 일치해야 합니다.");
			return "alert";
		
		} else if (vPersonalInfo.getName().length() < 1) {
			model.addAttribute("alertMsg","닉네임을 입력해주세요.");
			return "alert";
		
		} else if (vPersonalInfo.getPhone().length() < 1) {
			model.addAttribute("alertMsg","전화번호를 입력해주세요.");
			return "alert";
		}
		
		HttpSession session = req.getSession();
		VPersonalInfo login = (VPersonalInfo) session.getAttribute("login");
		
		if (login == null) {
			mPersonalInfo.write(vPersonalInfo);
		} else {
			mPersonalInfo.update(vPersonalInfo);
		}
		
		return "redirect:/login";
	}
	
	// 개인 정보 추가
		@RequestMapping(value = "/personal_update", method = RequestMethod.POST)
		public String personalUpdate(@ModelAttribute VPersonalInfo vPersonalInfo, HttpServletRequest req, Model model) throws IOException {
			
			List<VPersonalInfo> list = mPersonalInfo.read();
			
			// 유효성 검사
			if (vPersonalInfo.getUserId().length() < 5) {
				model.addAttribute("alertMsg","아이디를 5자리 이상 입력해주세요.");
				return "alert";
			
			} else if (vPersonalInfo.getPassword().length() < 8) {
				model.addAttribute("alertMsg","비밀번호를 8자리 이상 입력해주세요.");
				return "alert";
			
			} else if (!vPersonalInfo.getPassword().equals(vPersonalInfo.getConfirm())) {
				model.addAttribute("alertMsg","비밀번호 확인과 일치해야 합니다.");
				return "alert";
			
			} else if (vPersonalInfo.getName().length() < 1) {
				model.addAttribute("alertMsg","닉네임을 입력해주세요.");
				return "alert";
			
			} else if (vPersonalInfo.getPhone().length() < 1) {
				model.addAttribute("alertMsg","전화번호를 입력해주세요.");
				return "alert";
			}
			
			HttpSession session = req.getSession();
			VPersonalInfo login = (VPersonalInfo) session.getAttribute("login");
			
			if (login == null) {
				mPersonalInfo.write(vPersonalInfo);
			} else {
				mPersonalInfo.update(vPersonalInfo);
			}
			
			return "redirect:/login";
		}
	
	// 아이디/비밀번호 찾기
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String recovery(@RequestParam String phone, Model model) throws IOException {
			
		List<VPersonalInfo> list = mPersonalInfo.read();
			
		for (VPersonalInfo vPersonalInfo : list) {
				
			if (vPersonalInfo.getPhone().equals(phone)) {
					
				model.addAttribute("alertMsg","아이디: " + vPersonalInfo.getUserId() + " 비밀번호: " + vPersonalInfo.getPassword());
				model.addAttribute("redirectUrl","/login"); 
				return "alert";
				
			} 
		}
			
		model.addAttribute("alertMsg","일치하는 정보가 없습니다. 확인후 다시 입력해주세요.");
		return "alert";
	}
	
	// 탈퇴하기
	@RequestMapping(value = "/quit", method = RequestMethod.GET)
	public String quit(HttpServletRequest req) throws IOException {
		HttpSession session = req.getSession();
		VPersonalInfo login = (VPersonalInfo) session.getAttribute("login");
		session.setAttribute("login", null);
		
		mPersonalInfo.delete(login);
				
		return "redirect:/login";
	}
}
