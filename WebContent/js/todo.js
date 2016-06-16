angular.module('todoApp', [])
  .controller('TodoListController', ['$scope', function($scope, $http) {
	$scope.today = {
		value: new Date()
	};

    var todoList = this;
    var doneAll = false;
    todoList.todos = [ 
     ];
 
    todoList.addTodo = function() {
    	var todo = {text:todoList.todoText, date:todoList.date, done:false};
    	alert(todo);
    	todoList.todos.push(todo);
    	TodoService.createTodo(todo)
        .then(
                     function(d) {
                    	 alert( d);
                     },
                      function(errResponse){
                          console.error('Error while fetching Currencies');
                      }
             );
    	
      
      todoList.todoText = '';
      todoList.date = '';
    };
    
    todoList.doAll = function() {
    	var oldTodos = todoList.todos;
        todoList.todos = [];
        angular.forEach(oldTodos, function(todo) {
            todoList.todos.push({text:todo.text, date:todo.date, done:!doneAll});
        });
        doneAll = !doneAll;
    };
    
    todoList.isAllDone = function() {
    	var count = 0;
        angular.forEach(todoList.todos, function(todo) {
          count += todo.done ? 1 : 0;
        });
        doneAll = (count==todoList.todos.length);
        return doneAll;
    };
 
    todoList.remaining = function() {
      var count = 0;
      angular.forEach(todoList.todos, function(todo) {
        count += todo.done ? 0 : 1;
      });
      return count;
    };
 
    todoList.archive = function() {
      var oldTodos = todoList.todos;
      todoList.todos = [];
      angular.forEach(oldTodos, function(todo) {
        if (!todo.done) todoList.todos.push(todo);
      });
    };
  }]);