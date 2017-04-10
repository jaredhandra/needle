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
      },
      getReleaseInfo : function(resource_url){
        var deferred = $q.defer();
        var urlnm =  resource_url;

        $http({
          method: 'GET',
          url: urlnm,
        })
          .success(function(response){
            deferred.resolve(response);
          })
          .error(function(response){
            deferred.reject(response);
          })
        return deferred.promise;
      }
    };
  }]);
