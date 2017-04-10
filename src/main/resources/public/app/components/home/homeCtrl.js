angular.module('needleHomeCtrl', [])
.controller('homeCtrl', ['$scope', 'homeContent', '$q', function($scope, homeContent){

  $scope.searchParam = "";
  $scope.searchResults = [];

  $scope.artist = "";
  $scope.artistUri = "";
  $scope.artistImg = "";

  $scope.showLoad = false;
  $scope.errorMessage = "";


  $scope.searchDiscogs = function(searchParam) {
    $scope.errorMessage = "";
    toggleSpinner();
    homeContent.searchDiscogs(searchParam)
      .then(function(result){
        trimTitle(result);
        $scope.searchResults = result;
        toggleSpinner();
      })
      .catch(function(result){
        console.log(result);
        $scope.errorMessage = result.message;
        toggleSpinner();
      })
  }

  $scope.viewReleaseInfo = function(resource_url){
    homeContent.getReleaseInfo(resource_url)
      .then(function(result){
        $scope.release = result;
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
}]);
