  jQuery(document).ready(function($){
      $(".accordion_example5").smk_Accordion({closeAble: true});
      $(".accordion_example2").smk_Accordion({closeAble: true});
      $(".accordion_example3").smk_Accordion({closeAble: true});
      // Demo text. Let's save some space to make the code readable. ;)
      $('.acc_content').html('<ul class="abo-quest"><li><a href="#acc">How do I set up an account?</a></li> <li><a href="#app">What is the PocketFinder 2.0 App?</a></li> <li><a href="#appf">What functionality is included with the App?</a></li> <li><a href="#appdd">Does the App show my mobile devices proximity to the PocketFinder Locators in my account?</a></li> <li><a href="#appde">Will you have a Mobile App for BlackBerry and Windows Mobile phones?</a></li> <li><a href="#appdf">Accepted payment types?</a></li> <li><a href="#appdg">Is the application available in my language?</a></li></ul>');
// Demo text. Let's save some space to make the code readable. ;)
      $('.acc_contentb').html('<ul class="abo-quest"><li><a href="#appdh">Where can I learn more about a particular application?</a></li></ul>');  
// Demo text. Let's save some space to make the code readable. ;)
      $('.acc_contentc').html('<ul class="abo-quest"><li><a href="#appdj">How do I change my profile picture, name, or status?</a></li> </ul>');      
    
      $('a#top').click(function() {
        $('html,body').animate({'scrollTop' : 0},1000);
    });
 
  });

var b = document.documentElement;
b.setAttribute('data-useragent',  navigator.userAgent);

var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-1656750-34']);
_gaq.push(['_trackPageview']);

(function() {
  var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
  ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
  (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(ga);
})();