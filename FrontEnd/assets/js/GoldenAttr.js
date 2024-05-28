var bearerToken = 'eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjpbeyJhdXRob3JpdHkiOiJSb2xlX0FETUlOIn1dLCJzdWIiOiJtYW5pdGhAZ21haWwuY29tIiwiaWF0IjoxNzE2MzkzMzQ0LCJleHAiOjE3MTY0Nzk3NDR9.0mLJTGZgd8Nc5NsegcZVaKwZSjpiO1TsLfSrcIJ6gdk';

function showAlert(iconType,titleMessage,textMessage){
    Swal.fire({
        icon: iconType,
        title: titleMessage,
        text: textMessage,
    });
}

function formatDate(dateString) {
    var date = new Date(dateString);
    var year = date.getFullYear();
    var month = ('0' + (date.getMonth() + 1)).slice(-2);
    var day = ('0' + date.getDate()).slice(-2);
    return `${year}-${month}-${day}`;
}