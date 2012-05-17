<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta name="layout" content="principal">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mis obras</title>
  </head>
  <body>
    <div class="main-content">
      <h1><g:message code="Obras"/></h1>
    </div>
    <div>
      <h3>Aca van las obras</h3>
      
        <g:each in="${artistaInstance.obras}">
          ${artistaInstance.obras.nombre}
        </g:each>      
        
      
    </div>           
  </body>
</html>
