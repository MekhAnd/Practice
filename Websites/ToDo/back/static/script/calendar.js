/********** BASIC DATA**********/
const monthArray = [
  "January",
  "February",
  "March",
  "April",
  "May",
  "June",
  "July",
  "August",
  "September",
  "October",
  "November",
  "December",
];

const options = {
  month: "short",
  day: "numeric",
  year: "numeric",
};

const qDaysArrayLow = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
const qDaysArrayHigh = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
let monthNumber = new Date().getMonth();
let yearNumber = new Date().getFullYear();

const monthBtn = document.getElementsByClassName("header-todo__calendar-month_");

/********** PREPEARING BASIC DATA FOR CALENDAR BODY  **********/

for (let i = 0; i < monthBtn.length; i++) {
  monthBtn[i].addEventListener("click", (e) => {
   if (e.explicitOriginalTarget.ownerDocument.activeElement.attributes[1].value === "prev") {
      
      monthNumber -= 1;
      if (monthNumber < 0) {
        monthNumber = 11;
        yearNumber -= 1;
        calendar(monthNumber, yearNumber);
      }
      calendar(monthNumber);
    } else {
      monthNumber += 1;
      if (monthNumber > 11) {
        monthNumber = 0;
        yearNumber += 1;
        calendar(monthNumber, yearNumber);
      }
      calendar(monthNumber);
    }
  });
}

/********** DRAWING CALENDAR BODY  **********/
const calendar = (monthNumber) => {
  const calendarTitle = document.querySelector(
    ".header-todo__calendar-month-title"
  );
  const calendarBody = document.querySelector(
    ".header-todo__calendar-every-day"
  );
  let firstDay = new Date(yearNumber, monthNumber, 1);
  let firstDayWeek = firstDay.getDay();

  calendarTitle.innerHTML = monthArray[monthNumber];

  if (calendarBody.hasChildNodes()) {
    while (calendarBody.firstChild) {
      calendarBody.removeChild(calendarBody.firstChild);
    }
  }

  let firstDivs = firstDayWeek === 0 ? 6 : firstDayWeek - 1; //first day of current month
  let fullCalendarDivs =
    firstDivs +
    (highYear() ? qDaysArrayHigh[monthNumber] : qDaysArrayLow[monthNumber]); //The total number of cells for body of month calendar
  let dayDiv = 1;


  /***** Drawing calendar body *****/
  for (let i = 1; i <= fullCalendarDivs; i++) {
    const newDay = document.createElement("div");
    if (firstDivs >= 1) {
      newDay.className = `calendar__day_undefined`;
      newDay.innerHTML = "";
      calendarBody.appendChild(newDay);
      firstDivs--;
    } else if (dayDiv <= qDaysArrayLow[monthNumber]) {
     newDay.className = `${new Date(
        yearNumber,
        monthNumber,
        dayDiv
      ).getTime()} calendar`;
      newDay.innerHTML = `${dayDiv}`;
      let today = new Date();
      newDay.style.lineHeight = "1.75em";
      newDay.style.borderRadius = "25%";
      newDay.style.cursor = "pointer";
      dayDiv === today.getDate()
        ? (newDay.style.border = "white 1px solid")
        : "";
      checkHolidays(dayDiv) ? (newDay.style.color = "red") : ""; //Check the current day and draw with different color
      calendarBody.appendChild(newDay);
      dayDiv++;
    }
  }
};



/***** Check date, if this day is holiday draw this day with red color *****/
const checkHolidays = (dayDiv) => {
  let checkedDay = new Date(yearNumber, monthNumber, dayDiv);
  if (checkedDay.getDay() === 6 || checkedDay.getDay() === 0) {
    return true;
  } else {
    return false;
  }
};

/***** Check leap year *****/
const highYear = () => {
  if (new Date(yearNumber, 1, 29).getMonth() === 1) {
    return true;
  } else {
    return false;
  }
};