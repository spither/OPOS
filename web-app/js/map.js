function loadMarkers() {
    $.ajax({
        url: pinUrl,
        success: function(data) {
            for(var i = 0; i < data.length; i++) {
                var marker = new google.maps.Marker({
                    position: new google.maps.LatLng(data[i].lat, data[i].lng),
                    title: data[i].title,
                    map: window.theMap
                });
                attachInfo(marker, data[i].title, data[i].url);
            }
        }
    });
}

function attachInfo(marker, title, url) {
    var infowindow = new google.maps.InfoWindow({
        content: '<div><a href="' + url + '">' + title + '</a></div>'
    });
    google.maps.event.addListener(marker, 'click', function() {
        infowindow.open(window.theMap, marker);
    });
}

function initMap() {
    var myOptions = {
        zoom: 2,
        center: new google.maps.LatLng(51.5001, -0.1262),
        mapTypeId: google.maps.MapTypeId.HYBRID
    }
    window.theMap = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    loadMarkers();
}

function loadMap() {
    var script = document.createElement("script");
    script.type = "text/javascript";
    script.src = "http://maps.googleapis.com/maps/api/js?key=AIzaSyBZyDNcqzT3pn7mSpEXT1t0fge_jXYTX0A&sensor=false&callback=initMap";
    document.body.appendChild(script);
}

$(function() {
    loadMap();
});
