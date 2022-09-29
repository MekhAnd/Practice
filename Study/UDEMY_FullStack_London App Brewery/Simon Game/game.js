var buttonColours = ["red", "blue", "green", "yellow"];
var gamePattern = [];
var userClickedPattern = [];
var gameStarted = false;

var level = 0;

$(document).keydown((e)=>{
    if(!gameStarted){
        nextSequence()
        $("#level-title").text("Level " + level);
        gameStarted = true;
    }

})

function nextSequence(){
    level++
    userClickedPattern = [];
    $("#level-title").text("Level " + level);
    var randomNumber = Math.round(Math.random()*3);
    var randomChosenColour = buttonColours[randomNumber];
    gamePattern.push(randomChosenColour);

    $("#"+randomChosenColour).fadeOut(100).fadeIn(100).fadeOut(100).fadeIn(100);
    playSound(randomChosenColour)
}

function playSound(name){
    var audio = new Audio ("sounds/"+name+".mp3")
    audio.play();
}

$(".btn").click( (e)=>{
    var userChosenColour = e.target.id;
    userClickedPattern.push(userChosenColour);
    playSound(userChosenColour);
    animatePress("."+userChosenColour)
    checkAnswer(userClickedPattern.length-1)
})

function animatePress(name){
    $(name).toggleClass("pressed");
    setTimeout(() => {
        $(name).toggleClass("pressed");    
    }, 100);
}

function checkAnswer(currentLevel) {
    if(gamePattern[currentLevel] === userClickedPattern[currentLevel]){
        console.log("Ok")
        if(gamePattern.length === userClickedPattern.length){
            for(let i = 0; i<currentLevel; i++){
                if(gamePattern[i]===userClickedPattern[i]){
                    continue
                } else {
                    console.log("Not passed");
                    break;
                }
            }
            setTimeout(() => {
                console.log("New level has been started")
               nextSequence() 
            }, 1000);

        } 


    }
     else {

        $("#level-title").text("Game Over, Press Any Key to Restart " + level);
        let wrong = new Audio("sounds/wrong.mp3")
        wrong.play();
        $("body").toggleClass("game-over");
        setTimeout(() => {
            $("body").toggleClass("game-over");    
        }, 300);
        startOver()

    }
    
    console.log(userClickedPattern)
    console.log(gamePattern)
    
    
}
function startOver(){
    level = 0;
    gamePattern = [];
    gameStarted = false;
}