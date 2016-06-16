<!doctype html>
<html ng-app="todoApp">
<head>
<script src="js/ng/angular.min.js"></script>
<script src="js/todo.js"></script>
<script src="js/todo_service.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/todo.css">
</head>
<body>
	<div class="todoView" align="center">
		<div>
			<h2 class="u">
				<strong>Your Tasks List</strong>
			</h2>
			<div ng-controller="TodoListController as todoList">
				<form ng-submit="todoList.addTodo()">
					<input type="text" ng-model="todoList.todoText" size="30" maxlength="50"
						placeholder="Task to do" required> <input type="date"
						ng-model="todoList.date" placeholder="dd/mm/yyyy" min="2011-07-16" max="{{today.value | date:'yyyy-MM-dd'}}" required><input
						class="btn-primary" type="submit" value="Add">
				</form>

				<div class="Table">
					<div class="Title">
						<input type="checkbox" ng-model="todoList.isAllDone()" ng-click="todoList.doAll()"> <span>Mark
							all as complete</span>
					</div>
					<div class="Row" ng-repeat="todo in todoList.todos">
						<div class="Cell">
							<input type="checkbox" ng-model="todo.done" ng-click="todoList.isAllDone()">
						</div>
						<div class="Cell2">
							<span class="done-{{todo.done}}">{{todo.text}}</span>
						</div>
						<div class="Cell3">
							<span class="done-{{todo.done}}">{{todo.date | date:'dd/MM/yyyy'}}</span>
						</div>
					</div>
				</div>

				<div style="padding: 10px;">
					<div style="padding-left: 60px; text-align: left;">
						<span>{{todoList.remaining()}} Items left</span>
						<div style="float: right; padding-right: 60px">
							<input class="btn-primary" type="button"
								ng-click="todoList.archive()"
								value="Clear {{todoList.todos.length-todoList.remaining()}} completed item" />
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>