<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bai2 MVC</title>
    <link rel="stylesheet" href="scripts/styles.css">
</head>
<body>
<form action="account-servlet" name="formDangKy" method="POST">
    <div>
        <input type="text" id="txtFName" name="txtFName" maxlength="30" pattern="[a-zA-Z\s]+"
               title="Only letters a-z or A-Z" placeholder="First Name" required>
    </div>
    <div>
        <input type="text" id="txtLName" name="txtLName" maxlength="30" pattern="[a-zA-Z\s]+"
               title="Only letters a-z or A-Z" placeholder="Last Name" required>
    </div>
    <div>
        <input type="email" id="txtEmail" name="txtEmail" placeholder="Email" required>
    </div>
    <div>
        <input type="password" id="txtPass" name="txtPass" placeholder="Password" required>
    </div>
    <div>
        <label>Date of birth</label>
        <select name="day" required>
            <option value="">Day:</option>
            <!-- Day options 1-31 -->
            <script>
                for (let i = 1; i <= 31; i++) {
                    document.write('<option value="' + i + '">' + i + '</option>');
                }
            </script>
        </select>
        <select name="month" required>
            <option value="">Month:</option>
            <option value="1">January</option>
            <option value="2">February</option>
            <option value="3">March</option>
            <option value="4">April</option>
            <option value="5">May</option>
            <option value="6">June</option>
            <option value="7">July</option>
            <option value="8">August</option>
            <option value="9">September</option>
            <option value="10">October</option>
            <option value="11">November</option>
            <option value="12">December</option>
        </select>
        <select name="year" required>
            <option value="">Year:</option>
            <!-- Year options, ví dụ từ 1950 đến 2025 -->
            <script>
                for (let y = 1950; y <= 2025; y++) {
                    document.write('<option value="' + y + '">' + y + '</option>');
                }
            </script>
        </select>
    </div>
    <div>
        <input type="radio" id="male" name="gender" value="MALE" required><label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="FEMALE"><label for="female">Female</label>
    </div>
    <div class="form-buttons">
        <input type="submit" value="Sign Up">
    </div>
</form>
</body>
</html>