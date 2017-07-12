'use strict';
app.factory('ColegioService',['$localStorage', '$http', '$q', 'urls','Upload',
        function ($localStorage, $http, $q, urls,Upload) {

            var factory = {
                loadAllColegios: loadAllColegios,
                getAllColegios: getAllColegios,
                getColegio: getColegio,
                createColegio: createColegio,
                updateColegio: updateColegio,
                removeColegio: removeColegio
            };

            return factory;
            
            function loadAllColegios() {
                console.log('Fetching all colegios');
                var deferred = $q.defer();
                $http.get(urls.API_COLEGIO)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all colegios');
                            $localStorage.colegios = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading colegios');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllColegios(){
                return $localStorage.colegios;
            }

            function getColegio(id) {
                console.log('Fetching Colegio with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.API_COLEGIO + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Colegio with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading colegio with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createColegio(colegio) {
                console.log('Creating Colegio');
                var deferred = $q.defer();
                
                $http.post(urls.API_COLEGIO, colegio)
                    .then(
                        function (response) {
                            loadAllColegios();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Colegio : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateColegio(colegio, id) {
                console.log('Updating Colegio with id '+id);
                var deferred = $q.defer();
                $http.put(urls.API_COLEGIO + id, colegio)
                    .then(
                        function (response) {
                            loadAllColegios();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Colegio with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeColegio(id) {
                console.log('Removing Colegio with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.API_COLEGIO + id)
                    .then(
                        function (response) {
                            loadAllColegios();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Colegio with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
           
        }
    ]);