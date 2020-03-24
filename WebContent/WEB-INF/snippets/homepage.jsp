<%@ page import="testpack.Item,java.util.ArrayList" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="center" width="70%">
	<tr>
	
		
		<td align=left><napster:Greetings>Welcome: ${name}</napster:Greetings></td>
		<td align=right>
			<a href="EditAccount">Edit Account</a> 
			
			<a href="Logout">LogOut</a>
		</td>
	</tr>
	<tr>
		<td colspan=2 align=center>
			<h2>List of Items</h2>
			
			<table class="center">
				<tr><th>Actions</th><th>Item Name</th><th>Quantity</th></tr>
				<c:forEach var="Item" items="${allItems}">
							<tr>
								<td>
									<a href="ViewItem?id=${Item.getId()}">View</a> 
									<a href="EditItem?id=${Item.getId()}">Edit</a> 
									<a href="DeleteItem?id=${Item.getId()}">Delete</a> 
								</td>
								<td>${Item.name}</td>
								<td>${Item.qty}</td>
							</tr>
						</c:forEach>
				
				
    
	
	

				
				
				
			</table>
			
			
		</td>
	</tr>
	
</table>
<a href="AddItems">add Items</a>










