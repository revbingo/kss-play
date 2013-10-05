kss-play
=======

This is a Play module that provides a "living styleguide" in your Play applications, a la [http://warpspire.com/kss]

### Creating a Styleguide

* Annotate your CSS with KSS - see http://warpspire.com/kss
* Add the kssplay module to your dependencies.yml file, and import the routes for the module in your routes file
    
    GET		  /styleguide								module:kssplay
    
* In your application, create a views/Styleguide/styleguide.html file that extends Styleguide/base.html. Add #{styleguide}
  tag for each section of your styleguide.  The body of the tag should be the html that will be used to demonstrate the style. 
  Add the "-modifierClass" class to be replaced by each modifier in the examples
  
Example:
   
    #{extends 'Styleguide/base.html' /}
  
    #{styleguide section: '1.0'}
        <div class="flashydiv -modifierClass">This is a really flashy div</div>
    #{/styleguide}
    
    #{styleguide section: '1.1'}
       <button class="whizzybutton -modifierClass">This is a really whizzy button</button>
    #{/styleguide}

Optionally, you can set the folder that should be scanned for stylesheet in application.conf, using the stylesheets.dir property

### Viewing the styleguide

Head off to http://localhost:9000/styleguide and enjoy!  The styleguide is only available when running Play in DEV mode.
