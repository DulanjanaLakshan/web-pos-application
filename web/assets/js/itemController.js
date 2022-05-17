/*
* @author : U.K.Dulanjana Lakshan Kumarasingha
* @since : 0.1.0
*/

$("#Item_a").click(function () {
    loadAllItem();
})
$("#btnItemSearch").click(function () {
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

