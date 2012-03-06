<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>One Planet Action Plan Homepage</title>
	</head>
	<body>

        <content tag="header">
            BioRegional: One Planet Action Plan website
        </content>

        <!-- Main hero unit for a primary marketing message or call to action -->
        <div class="hero-unit">
            <h1>Introduction</h1>
            <p>The One Planet Living framework can help you to live and work within a fair share of our planet’s resources. It is scalable, adaptable and free to use. It provides a common sustainability language that enables us to share best practice and learn from each other.</p>
            <p>On this site you can create and publish your One Planet Action Plan, give and receive feedback, share good practice, and compare your own plan with others. Follow the links below to see what others are doing, or register above and begin creating your own One Planet Action Plan.</p>
        </div>

        <div class="row">
            <block:latestPlans />
            <block:latestNews />
        </div>

        <div class="row">
            <div class="span8">
                <div class="pageblock">
                <h2>Browse By...</h2>
                <p><g:link controller="browse" action="location">Location (map)</g:link></p>
                <p><g:link controller="browse" action="list" params="[ sort: 'org.name', order: 'asc' ]">Organisation</g:link></p>
                <p><g:link controller="browse" action="list" params="[ sort: 'name', order: 'asc' ]">Action Plan</g:link></p>
                </div>
            </div>
            <block:latestComments />
        </div>

	</body>
</html>
