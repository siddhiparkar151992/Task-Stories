taskStories.controller('StoryBoardCtrl', [
		'$scope',
		'$http',
		'StoriesModel',
		'STORY_TYPE',
		'STORY_STATUS',
		'UsersModel',
		function($scope, $http, StoriesModel, STORY_TYPE, STORY_STATUS,
				UsersModel) {

			var initStoryBoard = function() {
				$scope.statuses = STORY_STATUS;
				$scope.detailsForm = {
					inputAssignee : '',
					inputReporter : 0,
					inputType : '',
					inputStatus : '',
					inputTitle : ''
				};
				$scope.isDetailsVisible = true;
				
				$scope.storyTypes = STORY_TYPE;
				getAllStories();
				UsersModel.all().then(function(res) {
					$scope.users = res.data;
				});
			};
			var getAllStories = function(){
				StoriesModel.all().then(function(res) {
					$scope.stories = res.data;
				});
			}
			initStoryBoard();
			$scope.setCurrentStory = function(story) {
				$scope.currentStoryId = story.id;
				$scope.currentStory = story;
				$scope.editedStory = angular.copy($scope.currentStory);
			};

			$scope.deleteStory = function(story) {
				StoriesModel.deleteEntity(story.id).then(function(res) {
					$scope.stories = res.data;
				});
			};
			$scope.isEmptyStatus = function(status) {
				var isEmpty = true;
				if ($scope.stories) {
					$.each($scope.stories, function(i, story) {

						if (story.status == status)
							isEmpty = false;
					});
				}
				return isEmpty;
			};
			$scope.showMessages = function(field) {
				return $scope.detailsForm[field].$touched
						&& $scope.detailsForm[field].$invalid;
			};
			$scope.setDetailsVisible = function(boolFlag) {
				$scope.isDetailsVisible = boolFlag;
			};
			$scope.resetForm = function() {
				$scope.currentStory = {};
				$scope.editedStory = {};
				$scope.detailsForm.$setPristine;
				$scope.detailsForm.$setUntouched;
			};
			$scope.updateCancel = function() {
				$scope.resetForm();
			};
			$scope.updateStory = function() {
				var fields = ['title', 'description', 'criteria', 'status', 'type', 'reporter', 'assignee'];
				
				
				StoriesModel.update($scope.currentStoryId, $scope.editedStory).then(function(){
					fields.forEach(function(field){
						$scope.currentStory[field] = $scope.editedStory[field];
					});
					$scope.resetForm();
				});
			};
			$scope.createStory= function(story){
				StoriesModel.create(story).then(function(){
					$scope.resetForm();
					getAllStories();
				});
			}
		} ]);