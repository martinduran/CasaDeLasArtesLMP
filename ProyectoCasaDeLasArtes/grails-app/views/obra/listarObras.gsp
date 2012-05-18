<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <body>
    <div class="main-content">
      <h1><g:message code="Obras"/></h1>
    </div>
    <div>
      <h3>Aca van las obras...</h3> 
      <g:each in="${artista.obras}" var="obras">
           ${obras.nombre}
          <p>SI ENTRA</p>
      </g:each>
        
    </div>    
  </body>
</html>
