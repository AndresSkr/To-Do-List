import { Component, Input, OnInit, Output, EventEmitter  } from '@angular/core';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {


  @Input() item;
  @Output() eventItemDelte = new EventEmitter<string>();
  @Output() eventItemEdit = new EventEmitter<string>();
  constructor(private serviceItem:ItemService) { }

  ngOnInit(): void {
  }

  ChangeStatus() {
    this.item.done = ! this.item.done;
    this.serviceItem.editItem(this.item);
  }

  delete(){
    this.eventItemDelte.emit(this.item.id);
  }

  edit(){
    this.eventItemEdit.emit(this.item);
  }

}
