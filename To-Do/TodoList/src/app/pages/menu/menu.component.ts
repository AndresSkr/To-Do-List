import { Component, OnInit, ViewChild } from '@angular/core';
import { Tasks } from 'src/app/model/task.interface';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})

export class MenuComponent implements OnInit {

  @ViewChild('name') inputName;
  listTask: Tasks[] = [];
  constructor(private serviceTask: TaskService) {
    this.getData();
  }

  getData = () => {
    setTimeout(() => {
       this.serviceTask.task().subscribe(data => {
         this.listTask = data;
         console.log(this.listTask, "Load Data");
       })
     }, 150);

  }

  ngOnInit() {
  }

   addTask(name) {
     this.serviceTask.addTask(name);
    this.getData();
    console.log(this.listTask, "Load Data2");

    this.inputName.nativeElement.value = ' ';
  }

   deleteTask(idDeleteTask) {
     this.serviceTask.Delete(idDeleteTask);
     this.getData();

    /* 
    let indexDelete = this.listTask.findIndex(element => element.id===idDeleteTask);
    this.listTask.splice(indexDelete, 1);
    */
  }

}
