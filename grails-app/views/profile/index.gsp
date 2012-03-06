<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Profile: One Planet Action Plan</title>
	</head>
	<body>

        <content tag="header">
            User Profile
        </content>

        <div class="row">
            <ul class="tabs" data-tabs="tabs">
                <li class="active"><a href="#yourAccount">Your Account</a></li>
                <g:if test="${org}">
                    <li><a href="#yourOrg">Your Organisation</a></li>
                </g:if>
            </ul>

            <div class="tab-content">
                <div id="yourAccount" class="active tab-pane">
                    <form method="post" action="updateUser">
                        <fieldset>
                            <legend>Your account details are:</legend>

                            <f:field bean="${userInstance}" property="email" disabled="true" />
                            <f:field bean="${userInstance}" property="name" disabled="true" />
                            <f:field bean="${userInstance}" property="alias" disabled="true" />
                            <f:field bean="${userInstance}" property="postcode" disabled="true" />
                            <%-- FIXME <f:field bean="${userInstance}" property="country" disabled="true" /> --%>
                        </fieldset>
                        <div class="actions">
                            <g:link class="btn primary" action="editUser">Edit</g:link>
                        </div>
                    </form>
                </div>
                <g:if test="${org}">
                    <div id="yourOrg" class="tab-pane">
                        <form>
                            <fieldset>
                                <legend>Your organisation details are:</legend>

                                <f:field bean="${org}" property="name" disabled="true" />
                                <f:field bean="${org}" property="type" disabled="true" />
                                <f:field bean="${org}" property="address" disabled="true" />
                                <f:field bean="${org}" property="postcode" disabled="true" />
                                <%-- FIXME <f:field bean="${org}" property="country" disabled="true" /> --%>
                            </fieldset>
                            <div class="actions">
                                <g:link class="btn primary" action="editOrg">Edit</g:link>
                            </div>
                        </form>
                    </div>
                </g:if>
            </div>
		</div>
	</body>
</html>
