// Initialize the editor
var inputEditor = ace.edit("code-input");
inputEditor.session.setMode("ace/mode/json");
var outputEditor = ace.edit("code-output");
outputEditor.session.setMode("ace/mode/json");

// Tool selection
var inputTitles = {
    json_to_avro:"JSON document",
    avro_to_idl:"Avro schema",
    idl_to_avro:"Avro IDL"
}
var outputTitles = {
    json_to_avro:"Avro schema",
    avro_to_idl:"Avro IDL",
    idl_to_avro:"Avro schema"
}
var descriptions = {
    json_to_avro: `<h4>Infer Avro schema from JSON documents</h4>
                <p>First type in a JSON document in the left panel and then click on 'Generate'. The corresponding
                    inferred Avro schema will show up in the left panel.<br>
                    You could also use a JSON array as the input. In that case, the inferred schema is designed to
                    accept all the items of the Array.<br>
                    <strong>Note that only JSON record or JSON array of records is acceptable.</strong>
                </p>`,
    avro_to_idl: `<h4>Convert Avro schema to Avro IDL</h4>
                <p>Type in the Avro schema in the left panel and click "Generate". The equivalent Avro IDL will be
                generate on the right side.<br>
                <strong>The name space and protocol is given a default value and namespace is set to "null"</strong>
                </p>`,
    idl_to_avro: `<h4>Convert Avro IDL to Avro schema</h4>
                <p>Type in the Avro IDL in the left panel and click "Generate". The equivalent Avro schema protocol w
                ill be generate on the right side.<br></p>`
}
var inputCodeFormats = {
    json_to_avro: "ace/mode/json",
    avro_to_idl: "ace/mode/json",
    idl_to_avro: "ace/mode/c_cpp"
}
var outputCodeFormats = {
    json_to_avro: "ace/mode/json",
    avro_to_idl: "ace/mode/c_cpp",
    idl_to_avro: "ace/mode/json"
}
$('#tool').change(function () {
    $('#input-title').html(inputTitles[$('#tool').val()]);
    $('#output-title').html(outputTitles[$('#tool').val()]);
    $('#description').html(descriptions[$('#tool').val()]);
    outputEditor.session.setMode(outputCodeFormats[$('#tool').val()]);
    inputEditor.session.setMode(inputCodeFormats[$('#tool').val()]);
});

// Generate functionality
var restCall = function(restRoute, beautify) {
    var jsonDocument = inputEditor.getValue();
    restRoute.ajax({
        data: jsonDocument,
        success: function(data, textStatus, request) {
            if (beautify) outputEditor.setValue(js_beautify(data));
            else outputEditor.setValue(data);
        },
        error: function(error) {
            alert('Error in converting values. Check the input.');
        },
        headers: {
            'Content-Type': 'application/json'
        }
    });
};

$( "#generate" ).click(function() {
    if ($('#tool').val() == 'json_to_avro') {
        jsRoutes.controllers.AvroController.avroFromJsonDocument().ajax({
            data: inputEditor.getValue(),
            success: function(data, textStatus, request) {
                outputEditor.setValue(js_beautify(data));
            },
            error: function(error) {
                alert('Error in converting values. Check the input.');
            },
            headers: {
                'Content-Type': 'application/json'
            }
        });
    } else if ($('#tool').val() == 'avro_to_idl') {
        jsRoutes.controllers.AvroController.idlFromAvro().ajax({
            data: inputEditor.getValue(),
            success: function(data, textStatus, request) {
                outputEditor.setValue(data);
            },
            error: function(error) {
                alert('Error in converting values. Check the input.');
            },
            headers: {
                'Content-Type': 'application/json'
            }
        });
    } else if ($('#tool').val() == 'idl_to_avro') {
        jsRoutes.controllers.AvroController.avroFromIdl().ajax({
            data: inputEditor.getValue(),
            success: function(data, textStatus, request) {
                outputEditor.setValue(js_beautify(data));
            },
            error: function(error) {
                alert('Error in converting values. Check the input.');
            },
            headers: {
                'Content-Type': 'text/plain'
            }
        });
    }
} );