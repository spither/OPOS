<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Dashboard: Create News</title>
	</head>
	<body>

        <content tag="header">
            Create news article
        </content>

        <div class="row">
            <g:form action="saveNews" method="post">
                <fieldset>
                    <legend>Enter details of your news</legend>

                    <g:if test="${newsItem?.id}">
                        <input type="hidden" name="id" value="${newsItem.id}" />
                    </g:if>

                    <f:field bean="${newsItem}" property="title" label="Title" />
                    <f:field bean="${newsItem}" property="body" label="Story" />

                    <div class="actions">
                        <input type="submit" value="Save News" class="btn primary" />
                    </div>

                </fieldset>
            </g:form>
        </div>
	</body>
</html>
