<div class="span8">
    <div class="pageblock">
        <h2>Latest News</h2>
        <g:each in="${news}" var="newsItem">
            <p><g:link controller="news" action="view" id="${newsItem.id}">${newsItem.title.encodeAsHTML()}</g:link></p>
        </g:each>
    </div>
</div>
