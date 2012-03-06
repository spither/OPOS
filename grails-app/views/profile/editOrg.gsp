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
                <li class="active"><a href="#yourOrg">Edit</a></li>
            </ul>

            <div class="tab-content">
                <div id="yourOrg" class="active tab-pane">
                    <g:form method="post" action="updateOrg">
                        <fieldset>
                            <legend>Your organisation details are:</legend>

                            <input type="hidden" name="version" value="${org.version}" />
                            <f:field bean="${org}" property="name" />
                            <f:field bean="${org}" property="type" />
                            <f:field bean="${org}" property="address" />
                            <f:field bean="${org}" property="postcode" />
                            <f:field bean="${org}" property="country" />
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
