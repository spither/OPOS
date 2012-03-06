<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Action Plan : One Planet Action Plan</title>
	</head>
	<body>

        <content tag="header">
            ${plan.org.name.encodeAsHTML()} Action Plan
        </content>

        <div class="row">
            <div class="span12">
                    <h2>${plan.name.encodeAsHTML()}</h2>
                    <p><g:nl2br>${plan.description?.encodeAsHTML()}</g:nl2br></p>
            </div>
            <div class="span4">
                <p><g:render template="/blocks/sharing" /></p>
                <hr />
                <div class="row">
                    <div class="span2"><rating:stars active="false" bean="${plan}" caption="${false}" id="rating-${plan.id}" scope="any" /></div>
                    <div class="span2">(<rating:numRates bean="${plan}" tail="true" scope="any" />)</div>
                </div>
                <hr />
            </div>
        </div>
        <div class="row catList">
            <g:render template="/blocks/actionCatList" model="[ actionCats: actionCats, targetAction: 'cat', targetController: 'action' ]" />
        </div>
        <div class="row">
            <div class="span16">
                <h3>Comments</h3>
                <g:listComments target="${plan}" showAll="${params.int('showAll')}" />
                <sec:ifLoggedIn>
                    <div id="add-comment" class="modal hide fade">
                        <g:render template="/blocks/addComment" model="[ target: plan ]" />
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
