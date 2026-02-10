<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" href="/employee-dashboard/CSS/style.css" />
</head>
<body>
<div class="container form-container">
    <h2>Add New Employee</h2>

    <form method="post" action="save" class="emp-form">

        <div class="form-row">
            <label for="empId">Employee ID</label>
            <input type="text" name="empId" id="empId" class="tb" required/>
        </div>

        <div class="form-row">
            <label for="firsName">First Name</label>
            <input type="text" name="firstName" id="firstName" class="tb" required>
        </div>

        <div class="form-row">
            <label for="lastName">Last Name</label>
            <input type="text" name="lastName" id="lastName" class="tb" required/>
        </div>

        <div class="form-row">
            <label for="department">Department</label>
            <input type="text" name="department" class="tb" id="department" required/>
        </div>

        <div class="form-row">
            <label for="salary">Salary</label>
            <input type="text" name="salary" id="salary" class="tb" required/>
        </div>

        <div class="form-actions">
            <input type="submit" value="Save" class="btn btn-primary"/>
            <a href="/employee-dashboard/employee" class="btn btn-cancel">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
