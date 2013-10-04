package controllers.kssplay;

import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Set;

import play.Play;
import play.mvc.Controller;
import play.vfs.VirtualFile;

import com.revbingo.kss.KssParser;
import com.revbingo.kss.Section;

public class Styleguide extends Controller {

    public static void index() {
    	String stylesheetLocation = Play.configuration.getProperty("stylesheets.dir", "public/stylesheets");
		KssParser parser = new KssParser(stylesheetLocation);
		Map<String, Section> sections = parser.getSections();
		Set<String> sectionList = parser.getSections().keySet();
        render(sectionList, sections);
    }
}