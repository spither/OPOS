<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>News : One Planet Action Plan</title>
	</head>
	<body>

        <content tag="header">
            News
        </content>

        <div class="hero-unit">
            <h1>${newsItem.title.encodeAsHTML()}</h1>
            <p><g:nl2br>${newsItem.body?.encodeAsHTML()}</g:nl2br></p>
            <a class="btn" href="javascript:history.go(-1);">Back</a>
        </div>

	</body>
</html>
