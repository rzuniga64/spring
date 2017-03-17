<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <title>Insert title here</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

    <div class="container">
        <div class="row"></div>
        <form method="post"
              action="${pageContext.request.contextPath}/docreate">

            <div class="form-group">
                <label for="name">Name</label>
                <input  type="text"
                        class="form-control"
                        id="name"
                        name="name"
                        placeholder="Name">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email"
                       class="form-control"
                       id="email"
                       name="email"
                       placeholder="Email">
            </div>
            <div class="form-group">
                <label for="yourOffer">Your offer</label>
                <textarea class="form-control"
                          id="yourOffer"
                          name="yourOffer"
                          rows="10"
                          cols="10">
                </textarea>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>

        </form>
    </div>
</body>
</html>