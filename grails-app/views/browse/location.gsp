<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Browse by location : One Planet Action Plan</title>
        <r:require module="map" />
	</head>
	<body>

        <content tag="header">
            Browse by location
        </content>

        <div class="row">
            <div class="span16">
                <div id="map_canvas">
                </div>
            </div>
        </div>

        <g:javascript>
            var pinUrl = '${createLink(controller: 'browse', action: 'listPins')}';
        </g:javascript>

	</body>
</html>
