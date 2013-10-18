kss-play
=======

This is a Play module that provides a "living styleguide" in your Play applications, a la http://warpspire.com/kss

### Creating a Styleguide

* Annotate your CSS with KSS - see http://warpspire.com/kss



* Add the kssplay module to your dependencies.yml file, and import the routes for the module in your routes file
    
```
    GET		  /styleguide								module:kssplay
```

Then you have 2 choices:

1) Add markup to your KSS.  This uses the same format as supported by the [Node.js](https://github.com/hughsk/kss-node)
and [PHP](https://github.com/scaninc/kss-php) ports of this project. 

```css
/*
# Star Button

A button suitable for giving stars to someone.

Markup: <a class="button star $modifierClass">Button</a>

:hover              - Subtle hover highlight.
.stars--given       - A highlight indicating you've already given a star.
.stars--given:hover - Subtle hover highlight on top of stars-given styling.
.stars--disabled    - Dims the button to indicate it cannot be used.

Styleguide 2.1.3.
*/
a.button.star {
  ...
}
a.button.star:hover {
  ...
}
a.button.stars--given {
  ...
}
a.button.stars--given:hover {
  ...
}
a.button.stars--disabled {
  ...
}
```   

By including the markup in your KSS documentation, the styleguide will be automatically produced when you hit http://localhost:9000/styleguide

2) If you prefer to remain true to the orignal spec - in your application, create a `views/Styleguide/styleguide.html` file that extends `kssplay/Styleguide/styleguide-base.html`. Add `#{styleguide}`
  tag for each section of your styleguide.  The body of the tag should be the html that will be used to demonstrate the style. 
  Add the `-modifierClass` class to be replaced by each modifier in the examples
  
Example:
   
```
    #{extends 'kssplay/Styleguide/styleguide-base.html' /}
  
    #{styleguide section: '1.0'}
        <div class="flashydiv -modifierClass">This is a really flashy div</div>
    #{/styleguide}
    
    #{styleguide section: '1.1'}
       <button class="whizzybutton -modifierClass">This is a really whizzy button</button>
    #{/styleguide}
```

* Optionally, you can set the folder that should be scanned for stylesheet in application.conf, using the stylesheets.dir property

### Viewing the styleguide

Head off to http://localhost:9000/styleguide and enjoy!  The styleguide is only available when running Play in DEV mode.
