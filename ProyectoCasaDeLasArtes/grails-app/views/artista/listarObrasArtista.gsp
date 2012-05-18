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
    <div>
     <!-- <g:include controller="obra" action="listarObras"></g:include>  -->
    </div>
    <div>
      <g:link controller="obra" action="create" id="${artistaInstance}">Agregar obras</g:link>
    </div>
  </body>
</html>
