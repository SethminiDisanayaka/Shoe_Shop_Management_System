getAllSuppliers();
/*loadNextCustomerId();*/

/*get all*/
function getAllSuppliers() {
    $.ajax({
        url: "http://localhost:8080/app/api/v1/suppliers/getAllSuppliers",
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log(response);
            console.log(response.length);
            loadSupplierDataInTable(response);
        },
        error: function (xhr, status, err) {
            console.log(err)
        }
    })
}


function loadSupplierDataInTable(suppliers) {
    var tableBody = document.getElementById("supplierTable");
    tableBody.innerHTML = "";

    suppliers.forEach(function(supplier) {
        var row = document.createElement("tr");

        ["supplierCode", "supplierName", "category", "address", "contactNo1", "contactNo2", "email"].forEach(function(property) {
            var cell = document.createElement("td");
            cell.textContent = supplier[property];
            row.appendChild(cell);
        });

        tableBody.appendChild(row);
    });
}

/*$("#btnSupplierSave").click(function (){
    saveSupplier();
})*/

$("#btnSupplierSave").click(function (){
    saveSupplier();
})

/*save*/
function saveSupplier(){
    const supplierCode = document.getElementById('supplierCode').value;
    const supplierName = document.getElementById('supplierName').value;
    const category = document.getElementById('category').value;
    const address1 = document.getElementById('inputAddress').value;
    const address2 = document.getElementById('inputCity').value;
    const contactNo1 = document.getElementById('contactNumber1').value;
    const contactNo2 = document.getElementById('contactNumber2').value;
    const email = document.getElementById('inputEmail').value;

    const supplier = {
        supplierCode: supplierCode,
        supplierName: supplierName,
        category: category,
        address: `${address1}, ${address2}`,
        contactNo1: contactNo1,
        contactNo2: contactNo2,
        email: email
    }

    $.ajax({
        url: 'http://localhost:8080/app/api/v1/suppliers/save',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(supplier),
        success: function (response) {
            console.log(response);
            /*console.log("Success")*/
            alert('Supplier information saved successfully!');
            getAllSuppliers();
        },
        error: function (xhr, status, error) {
            console.error(error);
            /*console.log("Fail")*/
            alert('Failed to save supplier information. Please try again.');
        }
    });
}


/*table click*/
$('#supplierTable').on('click', 'tr', function (){
    var supplierCode = $(this).find('td:eq(0)').text();
    var supplierName = $(this).find('td:eq(1)').text();
    var category = $(this).find('td:eq(2)').text();
    var address = $(this).find('td:eq(3)').text();
    var contactNo1 = $(this).find('td:eq(4)').text();
    var contactNo2 = $(this).find('td:eq(5)').text();
    var email = $(this).find('td:eq(6)').text();

    $("#supplierCode").val(supplierCode);
    $("#supplierName").val(supplierName);
    $("#category").val(category);
    $("#inputAddress").val(address);
    $("#contactNumber1").val(contactNo1);
    $("#contactNumber2").val(contactNo2);
    $("#inputEmail").val(email);
})

$("#btnSupplierUpdate").click(function (){
    updateSupplier();
})

/*save*/
function updateSupplier(){
    const supplierCode = document.getElementById('supplierCode').value;
    const supplierName = document.getElementById('supplierName').value;
    const category = document.getElementById('category').value;
    const address1 = document.getElementById('inputAddress').value;
    const address2 = document.getElementById('inputCity').value;
    const contactNo1= document.getElementById('contactNumber1').value;
    const contactNo2 = document.getElementById('contactNumber2').value;
    const email = document.getElementById('inputEmail').value;

    const supplier = {
        supplierCode:supplierCode,
        supplierName:supplierName,
        category:category,
        address:`${address1},${address2}`,
        contactNo1:contactNo1,
        contactNo2:contactNo2,
        email:email
    }

    $.ajax({
        url: 'http://localhost:8080/app/api/v1/suppliers/update',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(supplier),
        success: function (response) {
            console.log(response);
            /*document.getElementById('customerForm').reset();*/
            alert('Supplier information updated successfully!');

        },
        error: function (xhr, status, error) {
            console.error(error);
            alert('Failed to update supplier information. Please try again.');
        }
    });
}

$(document).ready(function () {
    getAllSuppliers();
});

function customerCapitalizeFirstLetter(str) {
    return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
}