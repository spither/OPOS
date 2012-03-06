<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Action : One Planet Action Plan</title>
	</head>
	<body>

        <content tag="header">
            ${act.actionCat.name} Action
        </content>

        <div class="row">
            <div class="span12">
                <div class="hero-unit">
                    <h1><r:img uri="/images/petals/${act.actionCat.code}.png" alt="" /> ${act.title.encodeAsHTML()}</h1>
                    <p><g:nl2br>${act.summary?.encodeAsHTML()}</g:nl2br></p>
                </div>
            </div>
            <div class="span4">
                <h2>${act.actionPlan.org.name.encodeAsHTML()}</h2>
                <p>${act.actionPlan.description.encodeAsHTML()}</p>
                <hr />
                <p><g:render template="/blocks/sharing" /></p>
            </div>
        </div>
        <g:if test="${act.progress}">
            <div class="row">
                <div class="span12">
                    <p><em>Progress:</em> <g:nl2br>${act.progress.encodeAsHTML()}</g:nl2br></p>
                </div>
            </div>
        </g:if>
        <div class="row">
            <div class="span12">
                <h3>Comments</h3>
                <g:listComments target="${act}" />
                <sec:ifLoggedIn>
                    <div id="add-comment" class="modal hide fade">
                        <g:render template="/blocks/addComment" model="[ target: act ]" />
                    </div>
                    <button data-controls-modal="add-comment" data-backdrop="static" data-keyboard="true" class="btn">Add Comment</button>
                </sec:ifLoggedIn>
                <sec:ifNotLoggedIn>
                    <g:link controller="login" action="auth" class="btn">Login to comment</g:link>
                </sec:ifNotLoggedIn>
            </div>
        </div>
	</body>
</html>
