package controllers.kssplay;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.revbingo.kss.KssParser;
import com.revbingo.kss.StyleguideSection;

import play.Play;
import play.mvc.Controller;
import play.vfs.VirtualFile;

public class Styleguide extends Controller {

    public static void styleguide() {
    	String stylesheetLocation = Play.configuration.getProperty("stylesheets.dir", "public/stylesheets");
		try {
			File stylesheetsDir = new File(stylesheetLocation);
			if(!stylesheetsDir.exists()) throw new IOException();
			VirtualFile vf = VirtualFile.open(stylesheetsDir);
			KssParser parser = new KssParser(vf.getRealFile());
			Map<String, StyleguideSection> sections = parser.getStyleguideSections();
			Set<String> sectionList = parser.getStyleguideSections().keySet();
	        render(sectionList, sections);
		} catch (IOException e) {
			error("Cannot read directory " + stylesheetLocation + ". Please check the stylesheets.dir property");
		}
		
    }
}