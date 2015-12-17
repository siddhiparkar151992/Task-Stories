var taskStories = angular.module("taskStories", ['ngRoute']);
taskStories.value('STORY_TYPE',[
                                 {name: 'Feature'},
                                 {name: 'Enhancement'},
                                 {name: 'Bug'},
                                 {name: 'Spike'}
]);
taskStories.value('STORY_STATUS',[
                                 {
			name:"To Do"
		},
		{
			name:"In progress"
		},
		{
			name:"Code Review"
		},
		{
			name:"QA Review"
		},
		{
			name:"Verified"
		}
]);