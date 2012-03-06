<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Register : One Planet Action Plan</title>
	</head>
	<body>

        <content tag="header">
            Registration
        </content>

        <div class="row">
            <div class="span16">
                <g:form action="save">
                    <fieldset>
                        <legend>Enter your details below, then rate and comment on One Planet Action Plans.</legend>

                        <f:field bean="${reg}" property="email" label="Email" />
                        <f:field bean="${reg}" property="name" label="Name" helpBlock="This will be used in any private messages you send but is otherwise not displayed to other users." />
                        <f:field bean="${reg}" property="alias" label="Alias" helpBlock="This is shown publicly on this site, for example when you leave public comments." />
                        <f:field bean="${reg}" property="password" label="Password" />
                        <f:field bean="${reg}" property="confirmPassword" label="Confirm password" />
                        <f:field bean="${reg}" property="postcode" label="Postcode" />
                        <f:field bean="${reg}" property="country" label="Country" />
                        <f:field bean="${reg}" property="iAm" label="I am registering as" />

                    </fieldset>

                    <fieldset id="orgFields">
                        <legend>Enter details for your organisation below, then publish and share <br />your One Planet Action Plan.</legend>

                        <f:field bean="${orgReg}" property="orgName" label="Organisation Name" />
                        <f:field bean="${orgReg}" property="orgType" label="Type" noSelection="[ '': '-- please select --' ]" />
                        <f:field bean="${orgReg}" property="orgAddress" label="Address" />
                        <f:field bean="${orgReg}" property="orgPostcode" label="Postcode" />
                        <f:field bean="${orgReg}" property="orgCountry" label="Country" />

                    </fieldset>

                    <div class="actions">
                        <input type="submit" value="Register" class="btn primary" />
                        <a class="btn" href="javascript:history.go(-1);">Cancel</a>
                    </div>
                </g:form>
            </div>
        </div>

    <g:javascript>
        function setOrgDisplay() {
            var sel = $('#iAm option:selected');
            if($(sel).val() == 'an organisation') {
                $('#orgFields').show();
                $('#orgFields input[name=orgName]').attr('required', true);
                $('#orgFields input[name=orgType]').attr('required', true);
                $('#orgFields input[name=orgPostcode]').attr('required', true);
                $('#orgFields select[name=orgCountry]').attr('required', true);
            }
            else {
                $('#orgFields').hide();
                $('#orgFields input:required').removeAttr('required');
                $('#orgFields select:required').removeAttr('required');
            }
        }
        $(function() { setOrgDisplay(); });
    </g:javascript>
	</body>
</html>
