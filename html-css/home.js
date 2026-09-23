let button = document.getElementById("getTimeButton");
button.addEventListener("click", getDate);


async function getDate(e){
    e.preventDefault()


    let response = await fetch("https://time.now/developer/api/timezone/America/Chicago");
    let parsedResponse = await response.json()

    console.log(parsedResponse)

    let display = document.getElementById("timeDisplay");

    display.textContent = `Current time: ${parsedResponse.datetime}`;




}