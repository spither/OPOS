<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Dashboard: Create Plan</title>
	</head>
	<body>

        <content tag="header">
            Create your One Planet Action Plan
        </content>

        <div class="row">
            <g:form action="savePlan">
                <fieldset>
                    <legend>Enter your Action Plan details</legend>

                    <g:if test="${plan?.id}">
                        <input type="hidden" name="id" value="${plan.id}" />
                    </g:if>

                    <f:field bean="${plan}" property="name" class="xlarge" label="Action Plan Name" />
                    <f:field bean="${plan}" property="type" class="xlarge" label="Action Plan Type" />
                    <f:field bean="${plan}" property="description" label="What is this action plan for" helpBlock="Please enter a short description of your plan and what you want to achieve by implementing it." />
                    <f:field bean="${plan}" property="lat" label="Latitude" helpBlock="Enter the latitude for where this action plan is happening." />
                    <f:field bean="${plan}" property="lng" label="Longitude" helpBlock="Enter the longitude for where this action plan is happening." />

                    <div class="actions">
                        <input type="submit" value="Save Plan" class="btn primary" />
                    </div>

                </fieldset>
            </g:form>

        </div>

	</body>
</html>
