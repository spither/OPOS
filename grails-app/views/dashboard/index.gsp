<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Dashboard: One Planet Action Plan</title>
	</head>
	<body>

        <content tag="header">
            Dashboard
        </content>

        <g:if test="${org}">
            <div class="row">
                <ul class="tabs" data-tabs="tabs">
                    <li class="active"><a href="#yourActions">Your Actions</a></li>
                    <g:if test="${plan}">
                        <li><a href="#yourPlans">Your Plans</a></li>
                    </g:if>
                    <li><a href="#yourNews">Your News</a></li>
                </ul>

                <div class="tab-content">
                    <div id="yourActions" class="active tab-pane">
                        <g:if test="${plan}">
                            <g:form action="index" method="get">
                                <fieldset>
                                    <f:field property="id" label="Selected Action Plan">
                                        <g:select class="xxlarge" name="id" from="${plans}" value="${plan.id}" optionKey="id" optionValue="name" onchange="\$(this).parents('form').submit();" />
                                    </f:field>
                                </fieldset>
                            </g:form>
                            <br />
                            <g:render template="/blocks/actionCatList" model="[ actionCats: actionCats, targetAction: 'actionCat', targetController: 'dashboard' ]" />
                        </g:if>
                        <g:else>
                            <h2>Action Plan Missing!</h2>
                            <p><span class="label important">Important</span> You need to create your One Planet Action Plan.  Click the button below to get started.<p>
                            <div class="actions">
                                <g:link class="btn primary" action="createPlan">Create your One Planet Action Plan</g:link>
                            </div>
                        </g:else>
                    </div>
                    <g:if test="${plans}">
                        <div id="yourPlans" class="tab-pane">
                            <div class="row">
                                <g:each in="${plans}" var="pl">
                                    <div class="span8">
                                        <div class="pageblock">
                                            <h3><g:if test="${pl.autoShow}">(Default) </g:if>${pl.name.encodeAsHTML()}</h3>
                                            <p>${pl.description?.encodeAsHTML()}</p>
                                            <g:link action="editPlan" id="${pl.id}" class="btn">Edit this plan</g:link>
                                            <g:link action="defaultPlan" id="${pl.id}" class="btn">Make this my default plan</g:link>
                                        </div>
                                    </div>
                                </g:each>
                            </div>
                            <div class="actions">
                                <g:link action="createPlan" class="btn primary">Create new plan</g:link>
                            </div>
                        </div>
                    </g:if>
                    <div id="yourNews" class="tab-pane">
                        <g:each in="${news}" var="newsItem">
                            <h2>${newsItem.title.encodeAsHTML()}</h2>
                            <p><g:nl2br>${newsItem.body.encodeAsHTML()}</g:nl2br></p>
                            <g:link class="btn" action="createNews" id="${newsItem.id}">Edit</g:link>
                        </g:each>
                        <div class="actions">
                            <g:link class="btn primary" action="createNews">Post news</g:link>
                        </div>
                    </div>
                </div>
            </div>
        </g:if>
        <g:else>
            <div class="hero-unit">
                <h1>Notice</h1>
                <p>To use this dashboard you must currently be an organisational user.</p>
            </div>
        </g:else>
	</body>
</html>
