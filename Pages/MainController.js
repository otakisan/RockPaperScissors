var Main;
(function (Main) {
    //angular.module("MyApp").controller("Main.Controller", ["$scope", "$http", Controller]);
    var Value = (function () {
        function Value() {
        }
        return Value;
    })();
    Main.Value = Value;

    var Controller = (function () {
        function Controller($scope, $http) {
            this.httpService = $http;
            var controller = this;
            $scope.setValue = function () {
                var value = new Main.Value();
                value.Text = $scope.newText;
                controller.postValue(value, function (data) {
                    controller.getValue(function (data) {
                        $scope.newText = "";
                        $scope.value = data;
                    });
                });
            };
        }
        Controller.prototype.getValue = function (successCallback) {
            this.httpService.get("/api/values").success(function (data, status) {
                successCallback(data);
            });
        };

        Controller.prototype.postValue = function (value, successCallback) {
            this.httpService.post("/api/values", value).success(function (data, status) {
                successCallback(data);
            });
        };
        return Controller;
    })();
    Main.Controller = Controller;
})(Main || (Main = {}));

angular.module("MyAngularJs", []).controller("Controller", ["$scope", "$http", Main.Controller]);
//# sourceMappingURL=MainController.js.map
