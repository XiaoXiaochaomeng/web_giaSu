
let jsonData;
let r = 3;
function fetchData() {
    fetch('http://localhost:3000/branch')
        .then(response => response.json())
        .then(data => {
            jsonData = data; // lưu giá trị của file JSON vào biến
            console.log(jsonData);
            countBranches(jsonData);
            Morris.Donut({
                element: 'donut-example',
                data: [
                    { label: "SamSung", value: jsonData },
                    { label: "Apple", value: 30 },
                    { label: "Xiaomi", value: 20 }
                ],
                labelColor: '#fff',
                colors: ['orange', '#0072f2', '#fde9ea']
            });
            Morris.Line({
                // ID of the element in which to draw the chart.
                element: 'myfirstchart',
                lineColors: ['orange'],
                // Chart data records -- each entry in this array corresponds to a point on
                // the chart.
                data: [
                    { year: '20-1-2008', value: jsonData },
                    { year: '20-1-2009', value: 10 },
                    { year: '20-1-2010', value: 5 },
                    { year: '20-1-2011', value: 5 },
                    { year: '20-1-2012', value: 30 },
                    { year: '20-1-2014', value: 40 }
                ],
                // The name of the data record attribute that contains x-values.
                xkey: 'year',
                // A list of names of data record attributes that contain y-values.
                ykeys: ['value'],
                // Labels for the ykeys -- will be displayed when you hover over the
                // chart.
                labels: ['Value']
            });

        })
        .catch(error => {
            console.error(error);
        });
}
function countBranches(result) {
    $('.total-branch').text(result)
}
fetchData()


