package controllers.kssplay;

import play.*;
import play.mvc.*;

import java.util.*;

import com.revbingo.kss.KssParser;

import models.*;

public class Styleguide extends Controller {

    public static void index() {
    	KssParser parser = new KssParser("public/stylesheets");
        render(parser);
    }

}