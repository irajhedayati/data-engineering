var  onSuccess = function(data, textStatus, request) {
    if (typeof data === 'undefined' ) {
        $("#response").html('UNDEFINED');
    } else {
        var str = JSON.stringify(data, undefined, 2);
        $("#response").html(syntaxHighlight(str));
    }
    $("#response-header").html(
        "<span class=\"key\">Status</span>: <span class=\"string\">" + textStatus + "</span>\n" +
        "<span class=\"key\">Status code</span>: <span class=\"number\">" + request.status + "</span>\n" +
        "<span class=\"key\">Content-Type</span>: <span class=\"string\">" + request.getResponseHeader('Content-Type') + "</span>"
    )
}

var onError = function(error) {
    alert(error);
}

var restCallWithData = function(restRoute, restMethod, data) {
    $.ajax({
        method: restMethod,
        url: restRoute,
        success : onSuccess,
        error : onError,
        data : data,
        headers: {
            'Content-Type': 'application/json'
        }
    });
};

var restCall = function(restRoute, restMethod) {
    $.ajax({
        method: restMethod,
        url: restRoute,
        success : onSuccess,
        error : onError
    });
};

function syntaxHighlight(json) {
    if (typeof json != 'string') {
         json = JSON.stringify(json, undefined, 2);
    }
    json = json.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
    return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function (match) {
        var cls = 'number';
        if (/^"/.test(match)) {
            if (/:$/.test(match)) {
                cls = 'key';
            } else {
                cls = 'string';
            }
        } else if (/true|false/.test(match)) {
            cls = 'boolean';
        } else if (/null/.test(match)) {
            cls = 'null';
        }
        return '<span class="' + cls + '">' + match + '</span>';
    });
}
