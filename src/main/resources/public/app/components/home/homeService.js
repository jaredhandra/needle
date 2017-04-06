angular.module('needleHomeService', [])
  .factory('homeContent',['$q', '$http', function($q, $http){
    return {
      searchDiscogs : function(searchParameter){
        var deferred = $q.defer();
        var urlnm =  'http://localhost:8080/searchrelease';

        $http({
          method: 'GET',
          url: urlnm,
          params: {
            searchParam : searchParameter
          }
        })
          .success(function(response){
            deferred.resolve(response);
          })
          .error(function(response){
            deferred.reject(response);
          })
        return deferred.promise;
      }
      // getUserAccess : function(){
      //   var deferred = $q.defer();
      //   var url = "";
      //   $http
      //
      //   .success(function(response)){
      //     deferred.resolve
      //   }
      //   .error(function(response)){
      //
      //   }
      //   return deferred.promise;
      // }
    };
  }]);
