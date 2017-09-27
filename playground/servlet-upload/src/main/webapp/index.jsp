<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Upload</title>
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
</head>

<body>
<h1>File Upload Form</h1>
<hr />

<fieldset>
    <legend>Upload File</legend>
    <form action="/uploadservlet" method="post" enctype="multipart/form-data">
        <label for="filename_1">File: </label>
        <input id="filename_1" type="file" name="filename_1" size="50" /><br />
        <label for="filename_2">File: </label>
        <input id="filename_2" type="file" name="filename_2" size="50" /><br />
        <br />
        <input type="submit" value="Upload File" />
        <input id="resetId" type="reset" value="reset" style="display: none;">
    </form>
</fieldset>

<script type="text/javascript">
    $('form').submit(function (event) {
        event.preventDefault();
        var form = $(this);

        var formData = new FormData(this);
        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: formData,
            mimeType: "multipart/form-data",
            contentType: false,
            cache: false,
            processData: false
        }).success(function () {
            //成功提交
            alert("success");
            $('#resetId').click();
        }).fail(function (jqXHR, textStatus, errorThrown) {
            alert("fail")
            //错误信息
        });

    });
</script>
</body>
</html>