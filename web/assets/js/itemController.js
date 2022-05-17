/*
* @author : U.K.Dulanjana Lakshan Kumarasingha
* @since : 0.1.0
*/

$("#Item_a").click(function () {
    loadAllItem();
})

function loadAllItem() {
    $("#ItemTable").empty();
    $.ajax({
        url: "item",
        method: "GET",
        success: function (resp) {
            for (const item of resp) {
                let row = `<tr><td>${item.id}</td><td>${item.name}</td><td>${item.description}</td><td>${item.qty}</td><td>${item.price}</td></tr>`;
                $("#ItemTable").append(row);
            }
            bindClickEvents();
        }
    })
}

$("#btnSaveItem").click(function () {
    let data = $("#itemForm").serialize();
    alert("meka wada");
    $.ajax({
        url: "item",
        method: "POST",
        data: data,
        success: function (resp) {
            alert(resp);
            console.log(resp);
            loadAllItem();
        }
    })
})
$("#btnUpdateItem").click(function () {
    let fromData = $("#itemForm").serialize();
    $.ajax({
        url: "item?" + fromData,
        method: "PUT",
        success: function (res) {
            alert(res);
            loadAllItem();
        }
    })
})

$("#btnItemDelete").click(function () {
    let itemID = $("#txtItemID").val();
    $.ajax({
        url:"item?txtItemID="+itemID,
        method:"DELETE",
        success:function (res) {
            alert(res);
            loadAllItem();
        }
    })
})