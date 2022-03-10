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
import java.text.SimpleDateFormat;
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

import root.pack.lms.valueobject.VBoard;
import root.pack.lms.valueobject.VGangjwa;
import root.pack.lms.valueobject.VPersonalInfo;

/**
 * Handles requests for the application home page.
 */
@Service
public class MBoard {	
		
	public List<VBoard> select(String id) throws IOException {
		
		List<VBoard> boardList = null;
		Scanner scanner = null;
		try {
			ClassPathResource resource = new ClassPathResource("data/" + "board");
			String path = Paths.get(resource.getURI()).toString();
			File file = new File(path);
			scanner = new Scanner(file);
			
			boardList = new ArrayList<VBoard>();
			while(scanner.hasNext()) {
				
				VBoard vBoard = new VBoard();
				
				vBoard.setId(scanner.next());
				vBoard.setTitle(scanner.next());
				vBoard.setContents(scanner.next());
				vBoard.setName(scanner.next());
				vBoard.setDate(scanner.next());
				
				if (id == null) {
					boardList.add(vBoard);
				} else if (id.equals(vBoard.getId())) {
					boardList.add(vBoard);
				}
				

			}			
			scanner.close();		
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return boardList;
	}
	
	
	public void write(VBoard vBoard) {
		try {
			ClassPathResource resource = new ClassPathResource("data/board");
			String path = Paths.get(resource.getURI()).toString();
			
			File file = new File(path);
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss");
			SimpleDateFormat format2 = new SimpleDateFormat ("MM-dd");
			Date time = new Date();
			String id = format1.format(time);
	
			printWriter.println(id);
			printWriter.println(vBoard.getTitle());
			printWriter.println(vBoard.getContents());
			printWriter.println(vBoard.getName());
			printWriter.println(format2.format(time));
			
			fileWriter.close();
			
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void update(VBoard vBoard) throws IOException {
		
		List<VBoard> list = select(null);
		
		ClassPathResource resource = new ClassPathResource("data/board");
		String path = Paths.get(resource.getURI()).toString();
		
		File file = new File(path);
		FileWriter fileWriter = new FileWriter(file, false);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		for (VBoard item : list) {
			
			if (item.getId().equals(vBoard.getId())) {
				
			} else {
				printWriter.println(item.getId());
				printWriter.println(item.getTitle());
				printWriter.println(item.getContents());
				printWriter.println(item.getName());
				printWriter.println(item.getDate());
			}
				
		}
		
		printWriter.println(vBoard.getId());
		printWriter.println(vBoard.getTitle());
		printWriter.println(vBoard.getContents());
		printWriter.println(vBoard.getName());
		printWriter.println(vBoard.getDate());
		
		fileWriter.close();
	}
	
	public void delete(String id) throws IOException {
		
		List<VBoard> list = select(null);
		
		ClassPathResource resource = new ClassPathResource("data/board");
		String path = Paths.get(resource.getURI()).toString();
		
		File file = new File(path);
		FileWriter fileWriter = new FileWriter(file, false);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		for (VBoard item : list) {
			
			if (item.getId().equals(id)) {
				
			} else {
				
				printWriter.println(item.getId());
				printWriter.println(item.getTitle());
				printWriter.println(item.getContents());
				printWriter.println(item.getName());
				printWriter.println(item.getDate());
			}
		}
		
		fileWriter.close();
	}
		
}
	
