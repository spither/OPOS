<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Dashboard: One Planet Action Plan</title>
	</head>
	<body>

        <content tag="header">
            ${cat.name}
        </content>

        <div class="row">
            <div class="span16">
                <h2>${plan.name.encodeAsHTML()}</h2>
            </div>
            <g:each in="${actions}" var="action">
                <div class="span8">
                    <div class="pageblock">
                        <h2><r:img uri="/images/petals/${cat.code}.png" alt="" /> ${action.title.encodeAsHTML()}</h2>
                        <p>${action.summary?.encodeAsHTML()}</p>
                        <g:link class="btn" action="createAction" id="${action.id}">Edit</g:link>
                        <g:link class="btn" action="deleteAction" id="${action.id}" onclick="return confirm('Really delete this action?');">Delete</g:link>
                        <g:link class="btn" controller="action" action="view" id="${action.id}">View</g:link>
                    </div>
                </div>
            </g:each>
            <g:if test="${actions.size() < 10}">
                <div class="span8">
                    <div class="pageblock">
                        <h2>Create new action</h2>
                        <p></p>
                        <g:link class="btn primary" action="createAction" params="[ pid: plan.id, cid: cat.id ]">Add</g:link>
                    </div>
                </div>
            </g:if>
        </div>
	</body>
</html>
