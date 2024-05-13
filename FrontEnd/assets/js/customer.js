getAllCustomers();
/*loadNextCustomerId();*/

/*get all*/
function getAllCustomers() {
    $.ajax({
        url: "http://localhost:8080/app/api/v1/customers/getAllCustomers",
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log(response);
            console.log(response.length);
            loadCustomerDataInTable(response);
        },
        error: function (xhr, status, err) {
            console.log(err)
        }
    })
}

/*load customer into table*/
function loadCustomerDataInTable(customers) {
    var tableBody = document.getElementById("customerTable");
    tableBody.innerHTML = "";

    customers.forEach(function(customer) {
        var row = document.createElement("tr");

        ["customerCode", "customerName", "gender", "joinDate", "level", "totalPoints", "dob", "address"].forEach(function(property) {
            var cell = document.createElement("td");
            cell.textContent = customer[property];
            row.appendChild(cell);
        });

        tableBody.appendChild(row);
    });
}


/*var customers = [
    {
        customerCode: "C001",
        customerName: "John Doe",
        gender: "Male",
        joinDate: "2024-05-08",
        level: "Gold",
        totalPoints: 500,
        dob: "1990-01-01",
        address: "1234 Main St, City"
    },
    {
        customerCode: "C002",
        customerName: "Jane Smith",
        gender: "Female",
        joinDate: "2024-05-09",
        level: "Silver",
        totalPoints: 300,
        dob: "1985-05-15",
        address: "5678 Elm St, Town"
    }
];*/

/*/!*load customer data*!/
function loadCustomerData() {
    var tableBody = document.getElementById("customerTable");
    tableBody.innerHTML = "";

    customers.forEach(function(customer) {
        var row = document.createElement("tr");

        ["customerCode", "customerName", "gender", "joinDate", "level", "totalPoints", "dob", "address"].forEach(function(property) {
            var cell = document.createElement("td");
            cell.textContent = customer[property];
            row.appendChild(cell);
        });

        tableBody.appendChild(row);
    });
}
window.onload = function() {
    loadCustomerData();
};*/

/*/!*next id*!/
function loadNextCustomerId(){
    $.ajax({
        url:"http://localhost:8080/api/v1/customers/nextId",
        method:"GET",
        success:function (response) {
            console.log(response)
            $("#cId").val(response);
        },
        error:function (xhr, status, error) {
            console.log(error)
        }
    })
}*/

$("#btnCustomerSave").click(function (){
    saveCustomer();
})

/*save*/
function saveCustomer(){
    const customerCode = document.getElementById('customerCode').value;
    const customerName = document.getElementById('customerName').value;
    const gender = document.getElementById('gender').value;
    const joinDate = document.getElementById('joinDate').value;
    const level= document.getElementById('level').value;
    const totalPoints = document.getElementById('totalPoints').value;
    const dob = document.getElementById('dob').value;
    const address1 = document.getElementById('inputAddress').value;
    const address2 = document.getElementById('inputCity').value;

    const customer = {
        customerCode:customerCode,
        customerName:customerName,
        gender:gender,
        joinDate:joinDate,
        level:level,
        totalPoints:totalPoints,
        dob:dob,
        address:`${address1},${address2}`
    }

    $.ajax({
        url: 'http://localhost:8080/app/api/v1/customers/save',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(customer),
        success: function (response) {
            console.log(response);
            /*document.getElementById('customerForm').reset();*/
            alert('Customer information saved successfully!');

        },
        error: function (xhr, status, error) {
            console.error(error);
            alert('Failed to save customer information. Please try again.');
        }
    });
}


/*update customer*/
$("#btnCustomerUpdate").click(function (){
    updateCustomer()
})
function updateCustomer() {
    const customerCode = document.getElementById('customerCode').value;
    const customerName = document.getElementById('customerName').value;
    const gender = document.getElementById('gender').value;
    const joinDate = document.getElementById('joinDate').value;
    const level= document.getElementById('level').value;
    const totalPoints = document.getElementById('totalPoints').value;
    const dob = document.getElementById('dob').value;
    const address1 = document.getElementById('inputAddress').value;
    const address2 = document.getElementById('inputCity').value;

    const customer = {
        customerCode:customerCode,
        customerName:customerName,
        gender:gender,
        joinDate:joinDate,
        level:level,
        totalPoints:totalPoints,
        dob:dob,
        address:`${address1},${address2}`
    }



    $.ajax({
        url: 'http://localhost:8080/app/api/v1/customers/update',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(customer),
        success: function (response) {
            console.log(response);
            /*document.getElementById('customerForm').reset();*/
            alert('Customer information update successfully!');

        },
        error: function (xhr, status, error) {
            console.error(error);
            alert('Failed to update customer information. Please try again.');
        }
    });
}

/*table click*/
$('#customerTable').on('click', 'tr', function (){
    var code = $(this).find('td:eq(0)').text();
    var name = $(this).find('td:eq(1)').text();
    var gender = $(this).find('td:eq(2)').text();
    var joinDate = $(this).find('td:eq(3)').text();
    var level = $(this).find('td:eq(4)').text();
    var totalPoints = $(this).find('td:eq(5)').text();
    var dob = $(this).find('td:eq(6)').text();
    var address = $(this).find('td:eq(7)').text();

    $("#customerCode").val(code);
    $("#customerName").val(name);
    $("#gender").val(gender);
    $("#joinDate").val(joinDate);
    $("#level").val(level);
    $("#totalPoints").val(totalPoints);
    $("#dob").val(dob);
    $("#inputAddress").val(address);
})

/*$("#cClearBtn").click(function (){
    clearCustomerInputFields();
})*/

$(document).ready(function () {
    getAllCustomers();

    $('#btnCustomerDelete').on('click', function() {
        var customerCode = $('#customerCode').val();
        if (customerCode !== "") {
            deleteCustomer(customerCode);
        } else {
            alert("Please select a customer to delete.");
        }
    });
});

/*delete customer*/
function deleteCustomer(customerCode) {
    $.ajax({
        url: 'http://localhost:8080/app/api/v1/customers/delete/' + customerCode,
        type: 'DELETE',
        success: function (response) {
            console.log(response);
            alert('Customer deleted successfully!');
            getAllCustomers();
        },
        error: function (xhr, status, error) {
            console.error(error);
            alert('Failed to delete customer. Please try again.');
        }
    });
}




$(document).ready(function () {
    getAllCustomers();
});

function customerCapitalizeFirstLetter(str) {
    return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
}