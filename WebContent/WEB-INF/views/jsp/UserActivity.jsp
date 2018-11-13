<%-- 
    Document   : Home
    Created on : Nov 5, 2018, 09:40:08 PM
    Author     : Helal | m.helal.k@gmail.com
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/Header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/style/authentication.css"
	type="text/css">
<div class="page">
	<div class="container">
		<br />
		<div class="section latest-jobs-ads">
			<div class="section-title tab-manu">
				<h4>User activity</h4>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
					
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
					<tr>
						<td>John</td>
						<td>Doe</td>
						<td>john@example.com</td>
						<td><a href="#" class="btn"><i class="fas fa-history"></i> View details</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/layouts/Footer.jsp"%>