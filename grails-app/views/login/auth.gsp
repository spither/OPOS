<html>
<head>
	<meta name='layout' content='main'/>
	<title><g:message code="springSecurity.login.title"/></title>
</head>

<body>
    <content tag="header">
        Login
    </content>

    <div class="row">
		<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
            <fieldset>
                <legend><g:message code="springSecurity.login.header"/></legend>

                <f:field property="j_username" label="Email address" required="${true}">
                    <g:field type="text" name="j_username" class="xlarge" />
                </f:field>
                <f:field property="j_password" label="Password" required="${true}">
                    <g:field type="password" name="j_password" class="xlarge" />
                </f:field>
                <f:field property="${rememberMeParameter}" label="Remember me" >
                    <g:checkBox name="${rememberMeParameter}" checked="${hasCookie}" />
                </f:field>

			    <div class="actions">
				    <input class="btn primary" type='submit' id="submit" value='${message(code: "springSecurity.login.button")}'/>
			    </div>
            </fieldset>
        </form>
    </div>

<script type='text/javascript'>
	<!--
	(function() {
		document.forms['loginForm'].elements['j_username'].focus();
	})();
	// -->
</script>
</body>
</html>
