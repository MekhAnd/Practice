let currentScheduleDay;
const dayScheduleArray = [];
let newPoint = {};
let dayTransit;

const scheduleDay = document.querySelector(".header-todo__calendar-every-day");
scheduleDay.addEventListener("click", (e) => {
  if((e.target.attributes.class.value)!="calendar__day_undefined"){
  const day = (dayTransit = e.target.attributes.class.value.substr(0, 13));
  onCreateTodo(day);
  pointsList(day);}
});

//--- ON CREATE ITEM IN TODO LIST ---//
const scheduleButton = document.querySelector(".header-todo__todo-button");
scheduleButton.addEventListener("click", function (e) {
  const schedulePoint = document.querySelector(
    "input.header-todo__todo-input"
  ).value;
  if (schedulePoint != "") {
    newPoint = {
      key: ` ${new Date().getTime()}`,
      date: `${dayTransit}`,
      body: schedulePoint,
    };
    const options = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newPoint),
    };
    fetch(`/newItem/${currentUser.userEmail}`, options);
    document.querySelector("input.header-todo__todo-input").value = "";
    pointsList(newPoint);
  }
});

//---DRAWING ITEMS LIST ---//
const pointsList = (data) => {
  const listItems = document.querySelector(".header-todo__todo-pointsList");
  clearTodo();
  let scheduleDate;
  if (typeof data === "string") {
    scheduleDate = Number(data);
  } else {
    scheduleDate = data.date;
  }
  axios
    .get(`/itemsList/${scheduleDate}/${currentUser.userEmail}`)
    .then((response) => {
      const dayScheduleArray = response.data;
      for (let i = 0; i < dayScheduleArray.length; i++) {
        let newItem = document.createElement("div");
        newItem.innerHTML = dayScheduleArray[i].body;
        newItem.className = `${dayScheduleArray[i].key}_${dayScheduleArray[i].date}`;
        listItems.appendChild(newItem);
      }
    });
};

//--RETURN TO MAIN CALENDAR SCREEN FROM TODO LIST==//
const scheduleBackButton = document.querySelector(".header-todo__todo-back");
scheduleBackButton.addEventListener("click", (e) => {
  clearTodo();
  const calendarPanel = document.querySelector(".calendar_on");
  calendarPanel.style.display = "block";
  const toDoPanelMain = document.querySelector(".header-todo__todo");
  toDoPanelMain.style.display = "none";
});

//---DELETING ITEM FORM DAY ITEMS LIST---//
const itemCompleted = document.querySelector(".header-todo__todo-pointsList");
itemCompleted.addEventListener("click", (e) => {
  let itemIndex = e.target.className;
  axios
    .get(`/delete/${itemIndex}/${currentUser.userEmail}`)
    .then((response) => {
      const dayScheduleArray = response.data;
      pointsList(dayScheduleArray[0]);
    });
});

//--CLEARING TODO LIST--//
const clearTodo = () => {
  const listItems = document.querySelector(".header-todo__todo-pointsList");
  if (listItems.hasChildNodes()) {
    while (listItems.firstChild) {
      listItems.removeChild(listItems.firstChild);
    }
  }
};

//--CREATING BODY OF TODO LIST--//
const onCreateTodo = (day) => {
  let date = new Date(Number(day));
  const dateTodo = date.getDate();
  const monthTodo = date.getMonth();

  currentScheduleDay = `${Number(dateTodo)} ${monthArray[Number(monthTodo)]}`;
  const calendarPanel = document.querySelector(".calendar_on");
  calendarPanel.style.display = "none";
  const toDoPanelMain = document.querySelector(".header-todo__todo");
  toDoPanelMain.style.display = "flex";
  const toDoPanelDate = document.querySelector(".header-todo__todo-date");
  toDoPanelDate.innerHTML = `My plan on ${currentScheduleDay}`;
};
