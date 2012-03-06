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
                <li class="active"><a href="#yourAccount">Edit</a></li>
            </ul>

            <div class="tab-content">
                <div id="yourAccount" class="active tab-pane">
                    <g:form method="post" action="updateUser">
                        <fieldset>
                            <legend>Your account details are:</legend>

                            <input type="hidden" name="version" value="${userInstance.version}" />
                            <f:field bean="${userInstance}" property="email" />
                            <f:field bean="${userInstance}" property="name" />
                            <f:field bean="${userInstance}" property="alias" />
                            <f:field bean="${userInstance}" property="postcode" />
                            <f:field bean="${userInstance}" property="country" />
                        </fieldset>
                        <div class="actions">
                            <input type="submit" class="btn primary" value="Save" />
                        </div>
                    </g:form>
                </div>
            </div>
		</div>
	</body>
</html>
