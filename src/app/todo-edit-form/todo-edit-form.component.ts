import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Todo } from '../model/Todo';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TodoService } from '../service/todo.service';

@Component({
  selector: 'app-todo-edit-form',
  templateUrl: './todo-edit-form.component.html',
  styleUrls: ['./todo-edit-form.component.css']
})
export class TodoEditFormComponent implements OnInit {

  @Input('id') id:number;
  todo:Todo;
  todoForm:FormGroup;
  constructor(private todoService:TodoService) {
   }

  ngOnInit() {
    this.todo = this.todoService.getTodo(this.id);
    this.todoForm = new FormGroup({
      title: new FormControl(this.todo.title),
      description: new FormControl(this.todo.description),
      creationDate: new FormControl(this.todo.creationDate),
      completionDate:new FormControl(this.todo.completionDate),
      priority: new FormControl(this.todo.priority)
    });
  }
}
