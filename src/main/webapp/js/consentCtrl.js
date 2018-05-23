function consentController($scope) {
    $scope.newApplicant = true;
    $scope.submitBackGroundCheck = function(){
        $scope.newApplicant = false;
    };
};