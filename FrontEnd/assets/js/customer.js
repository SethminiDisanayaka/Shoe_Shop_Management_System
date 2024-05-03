getAllCustomers();

function getAllCustomers(){
    $.ajax({
        url: "http://localhost:8080/api/v1/customer/getAllCustomers",
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

$("#btnCustomerSave").click(function (){
    saveCustomer();
})
function saveCustomer(){
    let id=$("#customerCode").val();
    let name=$("#customerName").val();
    let gender=$("#gender").val();
    let joinDate=$("#joinDate").val();
    let level=$("#level").val();
    let totalPoints=$("#totalPoints").val();
    let dob=$("#dob").val();
    let address=$("#inputAddress").val();
    let city=$("#inputCity").val();
    let country=$("#inputCountry").val();
    let state=$("#inputState").val();
    let zip=$("#inputZip").val();

    console.log(name)
    console.log(gender)
    console.log(joinDate)
    console.log(level)
    console.log(totalPoints)
    console.log(dob)
    console.log(address)
    console.log(city)
    console.log(country)
    console.log(state)
    console.log(zip)

    if(name==="" || gender==="" || joinDate==="" || level==="" || totalPoints==="" || dob==="" ||address==="" || city==="" ||  country==="" || state==="" || zip===""){
        alert("fill all empty fields !!")
        return;
    }

    $.ajax({
        url: 'http://localhost:8080/api/v1/customer/save',
        method:"Post",
        dataType: "json",
        contentType:"application/json",
        data:JSON.stringify({
            "code":id,
            "name":name,
            "gender":gender,
            "joinDate":joinDate,
            "level":level,
            "totalPoints":totalPoints,
            "dob":dob,
            "address":address,
            "city":city,
            "country":country,
            "state":state,
            "zip":zip
        }),

        success:function (response) {
            console.log(response)
        },
        error:function (xhr,status,err) {
            console.log(err)
            console.log(xhr.status)
            if(xhr.status===409){
                alert("This customer is already in the system !!")
            }
        }

    })
}
