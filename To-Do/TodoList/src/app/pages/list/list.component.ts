import { Component, OnInit, Input, ViewChild, Output, EventEmitter } from '@angular/core';
import { Tasks } from 'src/app/model/task.interface';
import { ItemService } from 'src/app/services/item.service';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  @Input() task: Tasks;
  @ViewChild('Task') inputTask;
  @Output() delteTask = new EventEmitter<any>();
  @Output() addItem = new EventEmitter<any>();
  isEdit: boolean = false;
  indexEdit;
  constructor(private serviceItem: ItemService) { }

  ngOnInit(): void {

  }

  addSubTask(newItem) {
    /* this.task.items.push(newItem); */
    this.inputTask.nativeElement.value = ' ';
    this.serviceItem.addItem(newItem, this.task);
    this.addItem.emit();
  }

  deleteItem(idDelteItem) {

    let deleteIndex = this.task.items.findIndex(element => element.id === idDelteItem);
    let item = this.task.items[deleteIndex];
    this.serviceItem.deleteItem(item);
    this.task.items.splice(deleteIndex, 1);
  }

  configEditItem(item) {
    
    let editIndex = this.task.items.findIndex(element => element.id === item.id);
    this.indexEdit = editIndex;
    this.inputTask.nativeElement.value = this.task.items[this.indexEdit].name;
    this.isEdit = true;

  }

  editItem(nameUpdated) {

    let itemUpdate = this.task.items[this.indexEdit];
    itemUpdate.name=nameUpdated;
    this.serviceItem.editItem(itemUpdate);
    this.task.items[this.indexEdit].name = nameUpdated;
    this.isEdit = false;
    this.inputTask.nativeElement.value = ' ';
    this.indexEdit = null;
    console.log('Editado');

  }

  taskDelete() {
    this.delteTask.emit(this.task.id);
  }
}
