<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Dashboard: Create Action</title>
	</head>
	<body>

        <content tag="header">
            Create Action
        </content>

        <div class="row">
            <g:form action="saveAction">
                <fieldset>
                    <legend>Enter your Action details</legend>

                    <g:if test="${act?.id}">
                        <input type="hidden" name="id" value="${act.id}" />
                    </g:if>
                    <input type="hidden" name="pid" value="${plan.id}" />
                    <input type="hidden" name="cid" value="${cat.id}" />

                    <f:field bean="${act}" property="title" />
                    <f:field bean="${act}" property="summary" />
                    <f:field bean="${act}" property="progress" />

                    <div class="actions">
                        <input type="submit" value="Save Action" class="btn primary" />
                    </div>

                </fieldset>
            </g:form>

        </div>

	</body>
</html>
