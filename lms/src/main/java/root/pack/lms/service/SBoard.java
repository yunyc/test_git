package root.pack.lms.service;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import root.pack.lms.model.MBoard;
import root.pack.lms.model.MPersonalInfo;
import root.pack.lms.valueobject.VBoard;
import root.pack.lms.valueobject.VLoginInfo;
import root.pack.lms.valueobject.VPersonalInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SBoard {
	
	@Resource
	private MBoard mBoard;
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String boardInit(Model model) throws IOException {
		List<VBoard> boardList = mBoard.select(null);
		
		model.addAttribute("boardList", boardList);
		return "PBoard";
	}
	
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public String boardDetailInit(@RequestParam String id, Model model) throws IOException {
		List<VBoard> boardList = mBoard.select(id);
		
		model.addAttribute("vBoard", boardList.get(0));
		return "PBoardDetail";
	}
	
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public String boardRegisterInit(@RequestParam(defaultValue = "0") String id, Model model) throws IOException {
		
		model.addAttribute("vBoard", new VBoard());
		
		if (!id.equals("0")) {
			List<VBoard> boardList = mBoard.select(id);
			model.addAttribute("vBoard", boardList.get(0));
		}
		
		return "PBoardRegister";
	}

	
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public String boardRegister(@ModelAttribute VBoard vBoard) throws IOException {
		
		if (vBoard.getId() == null) {
			mBoard.write(vBoard);
		} else {
			mBoard.update(vBoard);
		}
		
		return "redirect:/board";
	}
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String boardDelete(@RequestParam String id) throws IOException {
		
		mBoard.delete(id);
		
		return "redirect:/board";
	}
	
	
	
	
	
}
