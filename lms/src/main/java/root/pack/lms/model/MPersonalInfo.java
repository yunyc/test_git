package root.pack.lms.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import root.pack.lms.valueobject.VPersonalInfo;

/**
 * Handles requests for the application home page.
 */
@Service
public class MPersonalInfo {
		
	// 개인정보 읽기
	public List<VPersonalInfo> read() throws IOException {
		
		List<VPersonalInfo> list = new ArrayList<VPersonalInfo>();
		
		try {
			ClassPathResource resource = new ClassPathResource("data/" + "temp");
			String path = Paths.get(resource.getURI()).toString();
			
			File file = new File(path);
			Scanner scanner = new Scanner(file);
			
			
			while(scanner.hasNext()) {
				
				VPersonalInfo vPersonalInfo = new VPersonalInfo();
				
				vPersonalInfo.setId(scanner.next());
				vPersonalInfo.setUserId(scanner.next());
				vPersonalInfo.setPassword(scanner.next());
				vPersonalInfo.setName(scanner.next());
				vPersonalInfo.setPhone(scanner.next());
				
				list.add(vPersonalInfo);
			}			
			scanner.close();
			
			return list;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// 개인 정보 쓰기
	public void write(VPersonalInfo vPersonalInfo) {
		try {
			ClassPathResource resource = new ClassPathResource("data/" + "temp");
			String path = Paths.get(resource.getURI()).toString();
			
			File file = new File(path);
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss");
			Date time = new Date();
			String id = format1.format(time);
			
			printWriter.println(id);
			printWriter.println(vPersonalInfo.getUserId());
			printWriter.println(vPersonalInfo.getPassword());
			printWriter.println(vPersonalInfo.getName());
			printWriter.println(vPersonalInfo.getPhone());
			
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	// 개인정보 수정(읽기, 쓰기)
	public void update(VPersonalInfo vPersonalInfo) throws IOException {
		ClassPathResource resource = new ClassPathResource("data/" + "temp");
		String path = Paths.get(resource.getURI()).toString();
		
		List<VPersonalInfo> list = read();
		
		File file = new File(path);
		FileWriter fileWriter = new FileWriter(file, false);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		for (VPersonalInfo item : list) {
			
			if (item.getId().equals(vPersonalInfo.getId())) {
				
			} else {
				printWriter.println(item.getId());
				printWriter.println(item.getUserId());
				printWriter.println(item.getPassword());
				printWriter.println(item.getName());
				printWriter.println(item.getPhone());
			}
			
		}
		printWriter.println(vPersonalInfo.getId());
		printWriter.println(vPersonalInfo.getUserId());
		printWriter.println(vPersonalInfo.getPassword());
		printWriter.println(vPersonalInfo.getName());
		printWriter.println(vPersonalInfo.getPhone());
		
		fileWriter.close();
		
		
	}
	
	// 개인정보 삭제(읽기, 쓰기)
	public void delete(VPersonalInfo vPersonalInfo) throws IOException {
		ClassPathResource resource = new ClassPathResource("data/" + "temp");
		String path = Paths.get(resource.getURI()).toString();
		
		List<VPersonalInfo> list = read();
		
		File file = new File(path);
		FileWriter fileWriter = new FileWriter(file, false);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		for (VPersonalInfo item : list) {
				
			if (item.getId().equals(vPersonalInfo.getId())) {
					
			} else {
				printWriter.println(item.getId());
				printWriter.println(item.getUserId());
				printWriter.println(item.getPassword());
				printWriter.println(item.getName());
				printWriter.println(item.getPhone());
			}
			
		}
			
		fileWriter.close();
			
			
		}
	
	
	
}
