function validatePhoneNumber(evt) {

    var ch = String.fromCharCode(evt.which);

    if (!(/[0-9]/.test(ch))) {
        evt.preventDefault();
    }

};

function searchFunction() {
    var input, filter, list, row, p, p2, p3, p4, p5, i, txtValue, txtValue2, txtValue3, txtValue4, txtValue5;
    input = document.getElementById("search-box");
    filter = input.value.toUpperCase();
    list = document.getElementById("request-list");
    row = list.getElementsByClassName("board-row");
    console.log(row);
    for (i = 0; i < row.length; i++) {
        p = row[i].getElementsByTagName("p")[0];
        p2 = row[i].getElementsByTagName("p")[1];
        p3 = row[i].getElementsByTagName("p")[2];
        p4 = row[i].getElementsByTagName("p")[3];
        p5 = row[i].getElementsByTagName("p")[4];
        txtValue = p.textContent || p.innerText;
        txtValue2 = p2.textContent || p2.innerText;
        txtValue3 = p3.textContent || p3.innerText;
        txtValue4 = p4.textContent || p4.innerText;
        txtValue5 = p5.textContent || p5.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1
            || txtValue2.toUpperCase().indexOf(filter) > -1
            || txtValue3.toUpperCase().indexOf(filter) > -1
            || txtValue4.toUpperCase().indexOf(filter) > -1
            || txtValue5.toUpperCase().indexOf(filter) > -1) {
            row[i].style.display = "";
        } else {
            row[i].style.display = "none";
        }
    }
};

