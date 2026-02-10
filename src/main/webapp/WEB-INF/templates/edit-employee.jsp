<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Employee</title>
    <link rel="stylesheet" href="/employee-dashboard/CSS/style.css" />
</head>
<body>
<div class="container form-container">
    <h2>Update Existing Employee</h2>

    <form method="post" action="update" class="emp-form">

        <div class="form-row">
            <label for="empId">Employee ID</label>
            <input type="text" name="empId" value="${emp.empId}" id="empId" class="tb" readonly/>
        </div>

        <div class="form-row">
            <label for="firstName">Edit First Name</label>
            <input type="text" name="firstName" value="${emp.firstName}" id="firstName" class="tb" required>
        </div>

        <div class="form-row">
            <label for="lastName">Edit Last Name</label>
            <input type="text" name="lastName" value="${emp.lastName}" id="lastName" class="tb" required/>
        </div>

        <div class="form-row">
            <label for="department">Edit Department</label>
            <input type="text" name="department" value="${emp.department}" class="tb" id="department" required/>
        </div>

        <div class="form-row">
            <label for="salary">Edit Salary</label>
            <input type="text" name="salary" value="${emp.salary}" id="salary" class="tb" required/>
        </div>

        <div class="form-actions">
            <input type="submit" value="Update" class="btn btn-primary"/>
            <a href="/employee-dashboard" class="btn btn-cancel">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
