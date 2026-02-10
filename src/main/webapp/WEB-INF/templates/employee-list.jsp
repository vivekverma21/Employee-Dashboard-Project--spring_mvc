<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<div class="container">
    <header>
        <h1>Employees</h1>
        <a class="btn btn-add" href="employee/add">+ Add Employee</a>
    </header>

    <div class="table-wrap">
        <table class="employee-table">
            <thead>
            <tr>
                <th>Emp ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Department</th>
                <th>Salary</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="emp" items="${employees}">
                <tr>
                    <td>${emp.empId}</td>
                    <td>${emp.firstName}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.department}</td>
                    <td><fmt:formatNumber value="${emp.salary}" type="currency" currencySymbol="₹"/></td>
                    <td class="actions">
                        <a class="btn btn-edit" href="employee/edit?eid=${emp.empId}">Edit</a>
                        <a class="btn btn-delete" href="employee/delete?eid=${emp.empId}" onclick="return confirm('Are you sure to delete?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty employees}">
                <tr><td colspan="6" class="no-data">No employees found. Click "Add Employee" to create one.</td></tr>
            </c:if>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
