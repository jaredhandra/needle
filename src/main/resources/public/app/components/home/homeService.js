angular.module('needleHomeService', [])
  .factory('homeContent',['$q', '$http', function($q, $http){
    return {
      searchDiscogs : function(searchParameter){
        var deferred = $q.defer();
        var urlnm =  '/searchrelease';

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
      getReleaseInfo : function(id){
        var deferred = $q.defer();
        var urlnm =  '/getreleaseinfo';

        $http({
          method: 'GET',
          url: urlnm,
          params : {
            id : id
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
      getVersionInfo : function(id){
        var deferred = $q.defer();
        var urlnm = resource_url;

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
      },
      sendTweet : function(title, artist, uri){
        var deferred = $q.defer();
        var urlnm = '/posttweet';

        $http({
          method: 'POST',
          url: urlnm,
          data : {
            "title" : title,
            "artist" : artist,
            "uri" : uri
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
    };
  }]);
