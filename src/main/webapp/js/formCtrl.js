function formController($scope, $location, $http, $log) {
    $scope.newApplicant = true;
    $scope.successOnApply = false;
    $scope.successOnUpdate = false;
    $scope.shopper ={};
    $scope.nextCount = 1;

    $scope.submit = function(){
        $http({
            method: 'POST',
            url: 'api/shopper',
            data: $scope.shopper
        }).then(function (response) {
            $log.info("Applicant details saved: " + response.data);
            $scope.shopper = response.data;
            $scope.successOnApply = true;
            if($scope.newApplicant) {
                $location.url("/consent");
                $scope.newApplicant = false;
            } else {
                $scope.successOnUpdate = true;
            }    
        }, function () {
            //if record already exists
            $scope.newApplicant = true;
            $log.error("Failed to save the application : Call to API failed");
        });
    }

};