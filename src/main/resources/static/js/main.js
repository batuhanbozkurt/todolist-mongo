$(document).ready(function () {
    $('button').click(function () {
        addItem();
    });

    $("body").on('click', '#todo a', function () {
        var itemId = $(this).closest("li").data('value');
        var listItem = $(this).closest("li");
        removeItem(listItem, itemId);
    });
});

function addItem() {
    var itemText = $("input[name=task]").val();
    console.log(itemText);
    var dataJson = {"itemText": itemText};
    var itemId = 0;
    $.ajax({
        type: "POST",
        url: "/listItem",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(dataJson),
        success: function (response) {
            console.log('success');
            console.log(response);
            itemId = response.id;
            $('#todo').append("<li data-value=\"" + itemId + "\">" + itemText + " <a href='#' class='close' aria-hidden='true'>&times;</a></li>");
        },
        error: function (result) {
            // TODO:
        },
        complete: function (result) {
            // TODO:
        }
    });

    return itemId;
}

function removeItem(listItem, itemId) {

    var dataJson = { "itemId":itemId};

    console.log(listItem);
    console.log(itemId);

    $.ajax({
        type: "DELETE",
        url: "/listItem",
        contentType: "application/json",
        data: JSON.stringify(dataJson),
        success: function (response) {
            console.log('success');
            console.log(response);
            listItem.remove();
        },
        error: function (result) {
            console.log('error');
            console.log(result);
        },
        complete: function (result) {
            console.log('complete');
            console.log(result);
        }
    });
}