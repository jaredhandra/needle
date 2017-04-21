angular.module('needleHomeCtrl', [])
.controller('homeCtrl', ['$scope', 'homeContent', '$q', function($scope, homeContent){

  $scope.searchParam = "";
  $scope.searchResults = [];
  $scope.showLoad = false;
  $scope.errorMessage = "";
  $scope.albumArt = "";
  $scope.releaseNotes = false;
  $scope.artist = "";

  $scope.searchDiscogs = function(searchParam) {
    $scope.errorMessage = "";
    toggleSpinner();
    homeContent.searchDiscogs(searchParam)
      .then(function(result){
        trimTitle(result);
        $scope.searchResults = result;
        $scope.artist = searchParam;
        toggleSpinner();
      })
      .catch(function(result){
        console.log(result);
        $scope.errorMessage = result.message;
        toggleSpinner();
      })
  }

  $scope.viewReleaseInfo = function(id, thumb){
    $scope.albumArt = thumb;
    homeContent.getReleaseInfo(id)
      .then(function(result){
        $scope.release = result;
      })
      .catch(function(result){
        console.log(result);
      })
  }

  $scope.sendTweet = function(title, uri){
    artist = $scope.artist;
    uri = "https://www.discogs.com" + uri;
    homeContent.sendTweet(title, artist, uri)
      .then(function(result){
        console.log('tweet sent');
      })
      .catch(function(result){
        console.log(result);
      })
  }

  trimTitle = function(result) {
    for (var i = 0; i < result.length; i++) {
      result[i].title = result[i].title.split("-")[1];
    }
  }

  toggleSpinner = function(){
    $scope.showLoad = !$scope.showLoad;
  }

  toggleReleaseNotes = function(){
    $scope.releaseNotes = !$scope.releaseNotes;
    console.log($scope.releaseNotes);
  }

}]);
