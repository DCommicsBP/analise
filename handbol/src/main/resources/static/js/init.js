(function($){
  $(function(){

    $('.sidenav').sidenav();
    $('.parallax').parallax();

  }); // end of document ready
})(jQuery); // end of jQuery name space

// 'router'

let renderPlayers = function(){
	$("#playersMain").show(); 
	$("#gameMain").hide(); 
	$("#historyReplace").hide(); 
	$("#teamsMain").hide(); 
}

let renderHistory = function(){
	$("#playersMain").hide(); 
	$("#gameMain").hide(); 
	$("#historyReplace").show(); 
	$("#teamsMain").hide(); 

}

let renderTeams = function(){
	$("#playersMain").hide(); 
	$("#gameMain").hide(); 
	$("#historyReplace").hide(); 
	$("#teamsMain").show(); 
}

let renderGames = function(){
	$("#playersMain").hide(); 
	$("#gameMain").show(); 
	$("#historyReplace").hide(); 
	$("#teamsMain").hide();
}
