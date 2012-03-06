<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Action Plan: One Planet Action Plan</title>
	</head>
	<body>

        <content tag="header">
            ${plan.name.encodeAsHTML()}<br />
        </content>

        <div class="row catRowTop">
            <g:render template="/blocks/actionCatRowWithRatingNoIcon" model="[ plan: plan, actionCat: cat ]" />
        </div>

        <div class="row">
            <g:each in="${actions}" var="action">
                <div class="span8">
                    <div class="pageblock">
                        <h2><r:img uri="/images/petals/${cat.code}.png" alt="" /> ${action.title.encodeAsHTML()}</h2>
                        <p>${action.summary?.encodeAsHTML()}</p>
                        <g:link controller="action" action="view" id="${action.id}">View</g:link>
                    </div>
                </div>
            </g:each>
            <g:if test="${actions.size() == 0}">
                <div class="span8">
                    <div class="pageblock">
                        <h2>Nothing is here yet!</h2>
                        <p>This action plan doesn't have any actions for ${cat.name.toLowerCase()} at the moment.</p>
                    </div>
                </div>
            </g:if>
        </div>
        <div class="row">
            <div class="clear actions">
                <a class="btn" href="javascript:history.go(-1);">Back</a>
            </div>
        </div>
	</body>
</html>
