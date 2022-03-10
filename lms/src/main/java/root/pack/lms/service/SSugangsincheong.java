package root.pack.lms.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class SSugangsincheong {
	
	@Resource private MHakgwa mHakgwa;
	@Resource private MGangjwa mGangjwa;

	@RequestMapping(value = "/sugangsincheong", method = RequestMethod.GET)
	public String sugangsincheongInit(HttpServletRequest req, Model model) throws IOException {
		
		return "PSugangsincheong";
	}
	
	// 학과 가져오기
	@ResponseBody
	@RequestMapping(value = "/sugangsincheong/hakgwa", method = RequestMethod.POST)
	public List<VHakgwa> getHakgwa(@RequestParam String fileName, Model model) throws IOException {
		List<VHakgwa> list = mHakgwa.getData(fileName);
		return list;
	}
	
	// 강좌 가져오기
	@ResponseBody
	@RequestMapping(value = "/sugangsincheong/gangjwa", method = RequestMethod.POST)
	public List<VGangjwa> getGangjwa(@RequestParam String fileName, Model model) throws IOException {
		List<VGangjwa> gangjwaList = mGangjwa.select(null, fileName);
		List<VGangjwa> sinchoengList = mGangjwa.select(null, "sincheong");
		
		for (VGangjwa gangjwa : gangjwaList) {
			
			for (VGangjwa sinchoeng : sinchoengList) {
				
				if (gangjwa.getId() == sinchoeng.getId()) {
					gangjwa.setSincheong(gangjwa.getSincheong() + 1);
				}
			}
		}
		return gangjwaList;
	}
	
	
	
	
	
}
