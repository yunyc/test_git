package root.pack.lms.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

import root.pack.lms.valueobject.VHakgwa;
import root.pack.lms.valueobject.VPersonalInfo;

/**
 * Handles requests for the application home page.
 */
@Service
public class MHakgwa {	
	
	public List<VHakgwa> getData(String fileName) throws IOException {
			
			List<VHakgwa> vCampus = null;
			Scanner scanner = null;
			try {
				ClassPathResource resource = new ClassPathResource("data/" + fileName);
				String path = Paths.get(resource.getURI()).toString();
				File file = new File(path);
				scanner = new Scanner(file);
				
				vCampus = new ArrayList<VHakgwa>();
				while(scanner.hasNext()) {
					VHakgwa vData = new VHakgwa();
					
					vData.setId(scanner.nextInt());
					vData.setText(scanner.next());
					vData.setFileName(scanner.next());
					
					vCampus.add(vData);
				}			
				scanner.close();		
				} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			return vCampus;
		}
	
	
	
}
