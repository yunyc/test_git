package root.pack.lms.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import root.pack.lms.valueobject.VGangjwa;
import root.pack.lms.valueobject.VPersonalInfo;

/**
 * Handles requests for the application home page.
 */
@Service
public class MGangjwa {	
		
	public List<VGangjwa> select(String userId, String fileName) throws IOException {
		
		List<VGangjwa> vGangjwas = null;
		Scanner scanner = null;
		try {
			ClassPathResource resource = new ClassPathResource("data/" + fileName);
			String path = Paths.get(resource.getURI()).toString();
			File file = new File(path);
			scanner = new Scanner(file);
			
			vGangjwas = new ArrayList<VGangjwa>();
			while(scanner.hasNext()) {
				
				VGangjwa vGangjwa = new VGangjwa();
				
				if (fileName.equals("miridamgi") || fileName.equals("sincheong")) {
					vGangjwa.setUser(scanner.next());
				}
				
				vGangjwa.setId(scanner.nextInt());
				vGangjwa.setGangjwaName(scanner.next());
				vGangjwa.setGyosuName(scanner.next());
				vGangjwa.setHakjeom(scanner.nextInt());
				vGangjwa.setTime(scanner.next());
				vGangjwa.setFileName(fileName);
				
				if (userId == null) {
					vGangjwas.add(vGangjwa);
				} else if (userId.equals(vGangjwa.getUser())) {
					vGangjwas.add(vGangjwa);
				}
				
			}			
			scanner.close();		
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vGangjwas;
	}
	
	
	public void write(String id, VGangjwa vGangjwa, String fileName) {
		try {
			ClassPathResource resource = new ClassPathResource("data/" + fileName);
			String path = Paths.get(resource.getURI()).toString();
			
			File file = new File(path);
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			printWriter.println(id);
			printWriter.println(vGangjwa.getId());
			printWriter.println(vGangjwa.getGangjwaName());
			printWriter.println(vGangjwa.getGyosuName());
			printWriter.println(vGangjwa.getHakjeom());
			printWriter.println(vGangjwa.getTime());
			
			fileWriter.close();
			
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void delete(int id, String userId, String fileName) throws IOException {
		
		List<VGangjwa> list = select(userId, fileName);
		
		ClassPathResource resource = new ClassPathResource("data/" + fileName);
		String path = Paths.get(resource.getURI()).toString();
		
		File file = new File(path);
		FileWriter fileWriter = new FileWriter(file, false);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		for (VGangjwa item : list) {
			
			if (item.getId() == id && item.getUser().equals(userId)) {
				
			} else {
				
				printWriter.println(item.getUser());
				printWriter.println(item.getId());
				printWriter.println(item.getGangjwaName());
				printWriter.println(item.getGyosuName());
				printWriter.println(item.getHakjeom());
				printWriter.println(item.getTime());
			}
		}
		
		fileWriter.close();
		
		
	}
		
}
	
