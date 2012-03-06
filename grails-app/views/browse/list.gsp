<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>One Planet Action Plan Homepage</title>
	</head>
	<body>

        <content tag="header">
            Browse Action Plans
        </content>

        <div class="row">
            <div class="span16">
                <table class="zebra-striped">
                <thead>
                    <tr>
                        <g:sortableColumn property="org.name" title="Organisation" />
                        <g:sortableColumn property="name" title="Plan Name" />
                        <g:sortableColumn property="type" title="Type" />
                        <%-- <th>Actions</th> --%>
                    </tr>
                </thead>
                <tbody>
                <g:each in="${plans}" status="i" var="plan">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td>${plan.org.name.encodeAsHTML()}</td>
                        <td><g:link controller="action" action="plan" id="${plan.id}">${fieldValue(bean: plan, field: "name")}</g:link></td>
                        <td>${fieldValue(bean: plan, field: "type")}</td>
                        <%-- <td>0</td> --%>
                    </tr>
                </g:each>
                </tbody>
            </table>
            <div class="pagination">
                <g:paginate total="${planTotal}" />
            </div>
            </div>
        </div>
	</body>
</html>
