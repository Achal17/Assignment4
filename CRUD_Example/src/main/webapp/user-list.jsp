<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Registration form....</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<h1>
			<a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a>
		</h1>
	</header>

	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-context">List of users...</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>country</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- 1st Fields............... -->

				<tbody>
					<c:forEach var="user" items="${listUsers}">
						<tr>
							<td><c:out value="${user.id}"></c:out></td>
							<td><c:out value="${user.name}"></c:out></td>

							<td><c:out value="${user.email}"></c:out></td>
							<td><c:out value="${user.country}"></c:out></td>

							<td><a href="edit?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>


			</table>


		</div>
	</div>

</body>
</html>