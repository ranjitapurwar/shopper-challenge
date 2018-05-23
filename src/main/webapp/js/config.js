app.config(function($routeProvider, $locationProvider){
    $locationProvider.hashPrefix('');
    $routeProvider.when('/consent', {templateUrl: '/partials/consent.html', controller:consentController});
    $routeProvider.when('/', {templateUrl: '/partials/form.html', controller:formController});
    $routeProvider.otherwise({redirectTo: '/'});

});