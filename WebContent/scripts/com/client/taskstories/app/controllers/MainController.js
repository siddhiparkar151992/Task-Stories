angular.module('taskStories.Common')
    .controller('MainCtrl', MainCtrl);
function MainCtrl($scope, $location) {
    var main = this;
    main.currentUser = null;
};
