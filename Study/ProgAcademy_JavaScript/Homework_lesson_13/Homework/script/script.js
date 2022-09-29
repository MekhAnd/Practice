const course = 'https://bank.gov.ua/NBUStatService/v1/statdirectory/exchangenew?json';

const xhr  =new XMLHttpRequest();
var data ='';

xhr.open('GET', course);

xhr.onreadystatechange = ()=>{
    console.log("xhr.status", xhr.status)
    if (xhr.readyState == 4 && xhr.status == 200) {
     data = JSON.parse(xhr.responseText);
     workWithCourse(data)
     console.log(data)
    }else if(xhr.status >= 400|| xhr.status <200 ){
        let main = document.querySelector('main');
        let div = document.createElement('div');
        div.style.cssText = `width: 1000px;    
                             background: black;
                             color: rgb(255, 1, 1);
                             text-align: center;`

        div.innerHTML = 'YOU HAVE SOME PROBLEM WITH YOUR REQUEST'
        main.appendChild(div);
    }
}

const workWithCourse = (data)=>{
    data.sort((a,b) => a.rate>b.rate? 1:-1);
   
    for (let i = 0; i < data.length; i++) {
        if(data[i].rate>25){
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
        } else{
            continue
        }
    }
}


xhr.send();
