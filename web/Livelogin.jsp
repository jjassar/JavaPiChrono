<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Internet of Chrony Things </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-titillium-600.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<script type="text/javascript">
    
    window.oncontextmenu=function(){
        
        return false;
        
    }
    
    
    
</script>
<%
    session.invalidate();
   
    %>

  </head>
<body>

<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="index.html">Connected <span>Chronograph</span> <small>We deliver results</small></a></h1>
       </div>
      <div class="searchform">
        <form id="formsearch" name="formsearch" method="post" action="#">
          <span>
          <input name="editbox_search" class="editbox_search" id="editbox_search" maxlength="80" value="Search our ste:" type="text" />
          </span>
          <input name="button_search" src="images/search.gif" class="button_search" type="image" />
        </form>
      </div>
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"> <a href="#"><img src="images/slide1.jpg" width="940" height="310" alt="" /> </a> <a href="#"><img src="images/slide2.jpg" width="940" height="310" alt="" /> </a> <a href="#"><img src="images/slide3.jpg" width="940" height="310" alt="" /> </a> </div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="index.html"><span>Home Page</span></a></li>
          <li><a href="RegisterChrony.jsp"><span>Register Chrony</span></a></li>
          <li><a href="Livelogin.jsp"><span>Live View</span></a></li>
          <li><a href="AdminLogin.jsp"><span>Chrony Database</span></a></li>
          <li><a href="contact.html"><span>Contact</span></a></li>
        </ul>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2><span>Admin Login</span></h2>
          <div class="clr"></div>
       </div>
        <div class="article">
         
          <div class="clr"></div>
          <form action="LiveviewLogin" method="post" id="sendemail">
            <ol>
              <li>
                <label for="name">ID (required)</label>
                <input type="text" name="email" value=""class="text" />
              </li>
              <li>
                <label for="email">Password (required)</label>
                <input type="password" name="pass" value="" class="text"/>
              </li>
              <li>
                <input type="image" name="imageField" id="imageField" src="images/submit.gif" class="send" />
                <div class="clr"></div>
              </li>
            </ol>
          </form>
          <%
              
               String err=(String) request.getAttribute("error");
              if(err!=null)
              {
              
          %>
          <font color="red">
          <%=err%>
          
          </font>
          <% } %>
          
          
        </div>
      </div>
  <div class="sidebar">
        
        <div class="gadget">
          <h2 class="star"><span>Technologies Used</span></h2>
          <div class="clr"></div>
          <ul class="ex_menu">
            <li><a href="#">JAVA Embedded</a><br />
              Embedded Suite</li>
            <li><a href="#">Pi4j</a><br />
              Hardware Interface</li>
            <li><a href="#">Raspbian</a><br />
              Wheezy based Linux</li>
              <li><a href="#">Java Enterprise</a><br />
              Web Development</li>
            <li><a href="#">Java Comet</a><br />
              Async Chat &amp;</li>
            <li><a href="#">Google Glass</a><br />
             Time line</li>
          </ul>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="fbg">
    <div class="fbg_resize">
      <div class="col c1">
        <h2><span>Image</span> Gallery</h2>
        <a href="#"><img src="images/emp.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/emp2.png" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/emp3.gif" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/emp4.png" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/emp5.png" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/emp6.png" width="75" height="75" alt="" class="gal" /></a> </div>
      <div class="col c2">
          <h2><span>Hardware </span> Technologies</h2>
        <ul class="fbg_ul">
          <li><a href="#">Raspberry Pi</a></li>
          <li><a href="#">Google IOIO</a></li>
          <li><a href="#">Digital Circuits</a></li>
        </ul>
      </div>
      <div class="col c3">
        <h2><span>Contact</span> Us</h2>
        <p>Feel Free to connect with us. You can send Us your Query.</p>
        <p class="contact_info"> <span>Address:</span>IOT Chrono<br />
 </p>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="footer">
    <div class="footer_resize">
      <p class="lf">&copy; <a href="#">IOT Chrono</a>.</p>
      <p class="rf">Design by<a href="#">Charanjeet</a></p>
      <div style="clear:both;"></div>
    </div>
  </div>
</div>
</body>
</html>
