getAllEmployees();

/*getAll Employees*/
function getAllEmployees(){
    $.ajax({
        url: "http://localhost:8080/app/api/v1/employees/getAllEmployees",
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log(response);
            console.log(response.length);
            console.log("success to load employees")
            loadEmployeeDataInTable(response);
        },
        error: function (xhr, status, err) {
            console.log("Fail to load employees")
            console.log(err)
        }
    })
}

/*load employee into table*/
function loadEmployeeDataInTable(employees) {
    var tableBody = document.getElementById("employeeTable");
    tableBody.innerHTML = "";

    employees.forEach(function (employee) {
        var row = document.createElement("tr");

        ["employeeCode", "employeeName", "employeeProfilePic", "gender", "status", "branch", "designation", "accessRole",
            "dob", "joinDate", "address", "contactNo", "Email", "guardianName", "guardianContactNo"].forEach(function (property) {
            var cell = document.createElement("td");
            cell.textContent = employee[property];
            row.appendChild(cell);
        });
        tableBody.appendChild(row);
    });

}

/*Save employee*/

$("#btnEmployeeSave").click(function (){
    saveEmployee();
})

function saveEmployee(){
    const employeeCode = document.getElementById('employeeCode').value;
    const employeeName = document.getElementById('employeeName').value;
    const employeeProfilePic = document.getElementById('employeeProfilePic').value;
    const gender = document.getElementById('gender').value;
    const status= document.getElementById('status').value;
    const branch = document.getElementById('branch').value;
    const designation = document.getElementById('designation').value;
    const accessRole = document.getElementById('accessRole').value;
    const dob = document.getElementById('dob').value;
    const joinDate = document.getElementById('joinDate').value;
    const address1 = document.getElementById('inputAddress').value;
    const address2 = document.getElementById('inputCity').value;
    const contactNo = document.getElementById('contactNo').value;
    const Email = document.getElementById('Email').value;
    const guardianName = document.getElementById('guardianName').value;
    const guardianContactNo = document.getElementById('guardianContactNo').value;

    const employee = {
        employeeCode:employeeCode,
        employeeName:employeeName,
        employeeProfilePic:employeeProfilePic,
        gender:gender,
        status:status,
        branch:branch,
        designation:designation,
        accessRole:accessRole,
        dob:dob,
        joinDate:joinDate,
        address:`${address1},${address2}`,
        contactNo:contactNo,
        Email:Email,
        guardianName:guardianName,
        guardianContactNo:guardianContactNo
    }

    $.ajax({
        url: 'http://localhost:8080/app/api/v1/employees/save',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(employee),
        success: function (response) {
            console.log(response);
            alert('Employees information saved successfully!');
        },
        error: function (xhr, status, error) {
            console.error(error);
            alert('Failed to save employee information. Please try again.');
        }
    });
}

/*table click*/
$('#employeeTable').on('click', 'tr', function (){
    var employeeCode = $(this).find('td:eq(0)').text();
    var employeeName = $(this).find('td:eq(1)').text();
    var employeeProfilePic = $(this).find('td:eq(2)').text();
    var gender = $(this).find('td:eq(3)').text();
    var status = $(this).find('td:eq(4)').text();
    var branch = $(this).find('td:eq(5)').text();
    var designation = $(this).find('td:eq(6)').text();
    var accessRole = $(this).find('td:eq(7)').text();
    var dob = $(this).find('td:eq(8)').text();
    var joinDate = $(this).find('td:eq(9)').text();
    var address = $(this).find('td:eq(10)').text();
    var contactNo = $(this).find('td:eq(11)').text();
    var Email = $(this).find('td:eq(12)').text();
    var guardianName = $(this).find('td:eq(13)').text();
    var guardianContactNo = $(this).find('td:eq(14)').text();

    $("#employeeCode").val(employeeCode);
    $("#employeeName").val(employeeName);
    $("#employeeProfile").val(employeeProfilePic);
    $("#gender").val(gender);
    $("#status").val(status);
    $("#branch").val(branch);
    $("#designation").val(designation);
    $("#accessRole").val(accessRole);
    $("#dob").val(dob);
    $("#joinDate").val(joinDate);
    $("#inputAddress").val(address);
    $("#contactNo").val(contactNo);
    $("#Email").val(Email);
    $("#guardianName").val(guardianName);
    $("#guardianContactNo").val(guardianContactNo);

})


$(document).ready(function () {
    getAllEmployees();
});

function employeeCapitalizeFirstLetter(str) {
    return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
}