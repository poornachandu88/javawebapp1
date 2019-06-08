

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <fieldset>
    <legend>Users List</legend> 
    <table class="table">
      <tr>
      <th>Id</th>
        <th>File Name</th>
        
      </tr>
      <c:forEach items="${files}" var="file">
        <tr>
          <td>${file.id}</td>
          <td>${file.fileName}</td>
     
         
        </tr>
       
      </c:forEach>

     

    </table>
  </fieldset>


