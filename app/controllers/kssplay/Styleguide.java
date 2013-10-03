package controllers.kssplay;

import play.mvc.Controller;

import com.revbingo.kss.KssParser;

public class Styleguide extends Controller {

    public static void index() {
    	KssParser parser = new KssParser("public/stylesheets");
        render(parser);
    }

}