$("#Customer_a").click(function () {
    loadAllCustomer();
})

function loadAllCustomer() {
    $("#customerTable").empty();
    $.ajax({
        url: "customer",
        method: "GET",
        success: function (resp) {
            for (const customer of resp) {
                let row = `<tr><td>${customer.id}</td><td>${customer.name}</td><td>${customer.address}</td><td>${customer.salary}</td></tr>`;
                $("#tblCustomerJson").append(row);
            }
            bindClickEvents();
        }
    })
}

function bindClickEvents() {
    $("#tblCustomerJson>tr").click(function () {
        let id = $(this).children().eq(0).text();
        let name = $(this).children().eq(1).text();
        let address = $(this).children().eq(2).text();
        let salary = $(this).children().eq(3).text();

        $("#txtCusID").val(id);
        $("#txtCusName").val(name);
        $("#txtCusAddress").val(address);
        $("#txtCusSalary").val(salary);
    });
}