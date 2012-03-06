<!doctype html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><g:layoutTitle default="One Planet Action Plan"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

        <%-- TODO favicons
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
        --%>

		<g:layoutHead/>
        <r:require modules="jquery,bootstrap,opap,ui-stars"/>
        <r:layoutResources />
	</head>
	<body>
        <div class="topbar">
            <div class="fill">
                <div class="container">
                    <a class="brand" href="${createLink(uri: '/')}">One Planet Action Plan</a>
                    <ul class="nav">
                        <li><g:link controller="browse" action="location">Map</g:link></li>
                        <li><g:link controller="browse" action="list" params="[ sort: 'org.name', order: 'asc' ]">Browse</g:link></li>
                        <li><g:link controller="page" action="about">About</g:link></li>
                        <sec:ifNotLoggedIn>
                            <li><g:link controller="register" action="index">Register</g:link></li>
                        </sec:ifNotLoggedIn>
                        <sec:ifLoggedIn>
                            <li><g:link controller="profile" action="index">Profile</g:link></li>
                            <g:ifUserHasOrg>
                                <li><g:link controller="dashboard" action="index">Dashboard</g:link></li>
                            </g:ifUserHasOrg>
                        </sec:ifLoggedIn>
                    </ul>
                    <sec:ifNotLoggedIn>
                        <form action="${createLink(uri: '/j_spring_security_check')}" method="post" class="pull-right">
                            <input class="input-small" type="text" placeholder="Email" name="j_username">
                            <input class="input-small" type="password" placeholder="Password" name="j_password">
                            <button class="btn" type="submit">Sign in</button>
                        </form>
                    </sec:ifNotLoggedIn>
                    <sec:ifLoggedIn>
                        <form class="pull-right">
                            <a href="${createLink(uri: '/logout')}" class="btn">Sign out</a>
                        </form>
                    </sec:ifLoggedIn>
                </div>
            </div>
        </div>

        <div class="pagehead">
            <div class="inner">
                <div class="container">
                    <div class="row">
                        <div class="span2">
                            <a href="${createLink(uri: '/')}"><r:img uri="/images/header-logo-75px.png" alt="" /></a>
                        </div>
                        <div class="span14">
                            <h1><g:pageProperty name="page.header" /></h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container pageContent">
            <g:if test="${msgError || flash.error}">
                <div class="alert-message error"><p>${msgError ?: flash.error}</p></div>
            </g:if>
            <g:if test="${msgSuccess || flash.message}">
                <div class="alert-message success"><p>${msgSuccess ?: flash.message}</p></div>
            </g:if>

		    <g:layoutBody/>

            <footer>
                <p>&copy; BioRegional 2012</p>
            </footer>
        </div> <!-- /container -->

        <r:layoutResources />
	</body>
</html>
