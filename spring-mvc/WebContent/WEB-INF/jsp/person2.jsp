<%@taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>
   
   <body>
      <h2>Person Information</h2>
      <form:form method = "POST" action = "/spring-mvc/addPerson">
         <table>
            <tr>
               <td><form:label path = "name">Name</form:label></td>
               <td><form:input path = "name" /></td>
            </tr>
            <tr>
               <td><form:label path = "age">Age</form:label></td>
               <td><form:input path = "age" /></td>
            </tr>
            <tr>
               <td><form:label path = "surname">Surname</form:label></td>
               <td><form:input path = "surname" /></td>
            </tr>
            <tr>
               <td><form:label path = "country">Country</form:label></td>
               <td>
                  <form:select path = "country">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${countryList}" />
                  </form:select>     	
               </td>
            </tr>   
            
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
</html>