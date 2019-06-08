<fieldset>
    <legend>Users List</legend>
    <table class="table">
      <tr>
      <th>Id</th>
        <th>Name</th>
        
      </tr>
            <tr>
          <td>${file.id}</td>
          <td>${file.fileName}</td>
          </tr>
    </table>
  </fieldset>
  <br>
  <br>
  <br>
<div>
   <img src="<spring:url value="${file.data}"/>" width="200">
   </div>
