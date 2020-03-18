const element = document.getElementById('mapid');

var points = [[${points}]]

var map = L.map(element).setView([51.505, -0.09], 13);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

points.forEach(value =>{
    if(value.province.equals("")){
        L.marker([value.latitude, value.longitude]).addTo(map)
            .bindPopup('country: ' + value.country +
                       '<br> province: ' + value.province +
                       '<br> recovered: ' + value.recovered +
                       '<br> deaths: ' + value.deaths +
                       '<br> confirmed: ' + value.confirmed)
            .openPopup();
    }else{
        L.marker([value.latitude, value.longitude]).addTo(map)
            .bindPopup('country: ' + value.country +
                       '<br> recovered: ' + value.recovered +
                       '<br> deaths: ' + value.deaths +
                       '<br> confirmed: ' + value.confirmed)
            .openPopup();
    }
});
