<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Internet of Chrony Things</title>
        <link rel="stylesheet" href="css/default.css" type="text/css" />
        <script type="text/javascript" src="javascripts/prototype.js"></script>
        <script type="text/javascript" src="javascripts/behaviour.js"></script>
        <script type="text/javascript" src="javascripts/moo.fx.js"></script>
        <script type="text/javascript" src="javascripts/moo.fx.pack.js"></script>
        <script type="text/javascript" src="javascripts/application.js"></script>
        
<script type="text/javascript">

function dsb()
 {

if(window.history.forward(1) != null)
         window.history.forward(1);
     
 }
   window.history.forward(1);
     
</script>   
        
        
        

        
    </head>
    
    <body>
        <p> You are now connected to Chrony with Serial No. <%=session.getAttribute("cname")%></p>
        <div id="container">
            <div id="container-inner">
                <div id="header">
                    <h1>Glassfish Connected</h1>
                </div>
                <div id="main">
                    <div id="display">
                    </div>
                    <div id="form">
                        <div id="system-message">Please input your name:</div>
                        <div id="login-form">
                            <input id="login-name" value=<%=session.getAttribute("username")%> type="text" />
                            <br />
                            <input id="login-button" type="button" value="Login" />
                        </div>
                      <!--  <div id="message-form" style="display: none;">
                            <div>
                                <textarea id="message" value= name="message" rows="2" cols="40"></textarea>
                                <br />
                                <input id="post-button" type="button" value="Post Message" />
                            </div> -->
                        </div>
                    </div>
                </div>
            </div>
            <h1> <a href="index.html" onclick="return dsb()"><span>Logout</span></a>
            </h1>
        </div>
        <iframe id="comet-frame" style="display: none;"></iframe>
        


        
    </body>
        
        
 <script type="text/javascript">
           $(document).ready(function() {
   alert("");
 });
            
        </script>
        
        
        
</html>
