(function(){
'use strict';
angular.module('app').controller('EstudianteController',UserController);
UserController.$inject = ['UserService', '$scope','Upload', '$timeout','$filter','Flash','ngDialog'];
function UserController( UserService, $scope , Upload , $timeout ,$filter,Flash,ngDialog) {
        var self = this;
        self.user = {};
        self.users=[];
        self.smartTablePageSize=10;

        self.submit = submit;
        self.getAllUsers = getAllUsers;
        self.createUser = createUser;
        self.updateUser = updateUser;
        self.removeUser = removeUser;
        self.openInscripcion = openInscripcion;
        self.editUser = editUser;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
        self.DNI = /^\d{7}([-]\w{1})?$/;
        self.rowCollection = getAllUsers();
        $scope.$on('actualizar', function() {
			$scope.clearFilter();
		});
		$scope.clearFilter = function(){
			UserService.loadAllUsers().then(function(){
				var v = getAllUsers();
				console.log(v,v.length);
				self.rowCollection=[];
				for(var i=0;i<v.length;i++)
					self.rowCollection.push(v[i]);
			},function(){});
		};
        
        
        function submit() {
            console.log('Submitting');
            if (self.user.id === undefined || self.user.id === null) {
            	console.log('%c[INFO]Guardando [nuevo] Estudiante. %o',log.wait, self.user);
                createUser(self.user);
            } else {
                updateUser(self.user, self.user.id);
                console.log('%c[INFO]%cEstudiante updated with id '+ self.user.id,log.info,log.fx);
            }
        }

        function createUser(user) {
        	console.log('%c[INFO]creando estudiante...',log.info);
            UserService.createUser(user)
                .then(
                    function (response) {
                    	console.log('%c[OK]%cEstudiante creado Exitosamente!!',log.ok,log.fx);
                        $scope.$broadcast('actualizar');
                        Flash.create('success', 'Maestro creado exitosamente', 'small-text');
                        self.done = true;
                        self.user={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                    	console.error('%c[ERROR]Error mientras creaba Estudiante',log.error);
						Flash.create('danger', 'Error mientras creando Estudiante: '+errResponse.data.errorMessage, 'small-text');
                    }
                );
        }


        function updateUser(user, id){
            console.log('About to update user');
            UserService.updateUser(user, id)
                .then(
                    function (response){
                    	console.log('%c[OK]%cEstudiante Actualizado correctamente',log.ok,log.fx);
						Flash.create('info', 'Estudiante actualizado Correctamente!: ', 'large-text');
						$scope.$broadcast('actualizar');
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                    	console.error('%c[ERROR]Error mientras editaba estudiante ' + id + ', Error :' + errResponse.data,log.error);
						Flash.create('danger', 'Error mientras editaba estudiante ' + id + ', Error :' + errResponse.data.errorMessage, 'large-text');
                    }
                );
        }


        function removeUser(id){
        	console.log('%c[INFO]%cAcerca para borrar Maestro con rda %s',log.info,log.fx,id);
            UserService.removeUser(id)
                .then(
                    function(){
                    	$scope.$broadcast('actualizar');
						console.log('%c[OK]%cEstudiante '+id + ' borrado correctamente',log.ok,log.fx);
                    },
                    function(errResponse){
                    	Flash.create('danger', 'Error mientras eliminaba Estudiante: '+id+', Error :'+errResponse.data, 'large-text');
						console.error('%cError mientras eliminaba Estudiante  '+id +', Error :'+errResponse.data,log.error);
                    }
                );
        }


        function getAllUsers(){
            return UserService.getAllUsers();
        }

        function editUser(id) {
            UserService.getUser(id).then(
                function (user) {
                	self.user = user;
					self.user.rude_old=user.rude;
					self.user.ci_old=user.ci;
                },
                function (errResponse) {
                	if(errResponse.status==404){
						console.error('%c[ERROR] ERROR recurso no encontrado'+errResponse,log.error);
						Flash.create('danger', 'ERROR recurso no encontrado: '+errResponse.status, 'large-text');
					}
					else if(errResponse.status==401){
						console.error('%c[ERROR] El servidor no esta Disponible o no hay conexion de Internet',log.error);
						Flash.create('danger', 'El servidor no esta Disponible o no hay conexion de Internet: '+errResponse.status, 'large-text');
					}else
						console.error('%c[ERROR]Error mientras editaba estudiante ' + id + ', Error :' + errResponse.data,log.error);
                }
            );
        }
        function reset(){
            self.user={};
            $scope.myForm.$setPristine(); //reset Form
        }
        function openInscripcion(est){
        	$scope.InsEstudiante=est;
        	ngDialog.open({
				template: '/app/modules/dashboard/registro/dialog.html',
				scope:$scope,
				controller:['$scope','ColegioService',function($scope,ColegioService){
					$scope.colegios = [];
					ColegioService.loadAllColegios().then(function(result){
						$scope.colegios = ColegioService.getAllColegios();
					},function(e){});
					$scope.dialogColegio = function(){
						var dialog2 = ngDialog.open({
							template:'/app/modules/dashboard/registro/colegio/dialog.html',
							scope:$scope,
							controller:['$scope','ColegioService',function($scope,ColegioService){
								$scope.col={};
								$scope.registroAddColegio=function(col){
									alert();
								}
							}]
						});
					}
				}],
				className: 'ngdialog-theme-default'
			});
        }
}
})();