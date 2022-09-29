const course = 'https://bank.gov.ua/NBUStatService/v1/statdirectory/exchangenew?json';

const xhr  =new XMLHttpRequest();
var data ='';

xhr.open('GET', course);

xhr.onreadystatechange = ()=>{
    if (xhr.readyState == 4 && xhr.status == 200) {
     data = JSON.parse(xhr.responseText);
     workWithCourse(data)
     console.log(data)
    }
}

const workWithCourse = (data)=>{
   
    for (let i = 0; i < data.length; i++) {
        let main = document.querySelector('main');
        let div = document.createElement('div');
        div.className = 'currency_container';
        main.appendChild(div);

        let flag = document.createElement('div');
        flag.className = 'flag';
        flag.innerHTML = data[i].txt;

        let country = document.createElement('div');
        country.className = 'country';
        country.innerHTML = data[i].cc;

        let currency = document.createElement('div');
        currency.className = 'currency';
        currency.innerHTML = (data[i].rate);
        
        div.style.display = 'flex';
        div.appendChild(flag);
        div.appendChild( country)
        div.appendChild(currency)
       
    //    let flag = document.getElementById('flags');
    //    let country =  document.getElementById('countries');
    //    let rate = document.getElementById('currencies');

    //    
    //    country.innerHTML = data[i].cc;
    //    rate.innerHTML = data[i].rate;

        
      // document.write(data[i].cc + '<br>');
        // document.write(data[i].rate + '<br>');
        // document.write(data[i].txt + '<br>');
        // document.write('<hr>');
    }
}


xhr.send();
